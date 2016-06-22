package hellotvxlet;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.tv.xlet.*;

import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
import org.havi.ui.event.HRcEvent;


public class HelloTVXlet implements Xlet, UserEventListener, HBackgroundImageListener, ResourceClient
{
    private int numberOfColors = 8;
    
    private HScene scene;
    private ButtonComponent[] buttons;
    private int cursor = 0;
    private int row = 0;
    private int guessCursor = 0;
    
    private int filledIn=0;
    
    private FeedbackComponent[] feedbacks;
    
    private ButtonComponent[][] lives;
    
    private Color[] colors;
    private Color[] computerGeneratedRandomizedCorrectColorCode;
    private String[] colorNames;
    
    private ButtonComponent highlightButton;
    
    private HScreen screen;
    private HBackgroundDevice bgDev;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfig;
    private HBackgroundImage bgImg1 = new HBackgroundImage("background5.jpg");
    
    private int wonCounter = 0;
    private int lossCounter = 0;
    
    private ButtonComponent tekstLabelWon;
    private ButtonComponent tekstLabelLoss;
    private ButtonComponent tekstLabelInstr;
    
    private boolean blockInput = false;

    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException
    {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        screen = HScreen.getDefaultHScreen();
        
        bgDev = screen.getDefaultHBackgroundDevice();
        if(bgDev.reserveDevice(this))
        {
            System.out.println("BackgrounImage device has been reserved.");
        }
        else
        {
            System.out.println("Background image device cannot be reserved.");
        }
        
        bgTemplate = new HBackgroundConfigTemplate();
        
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        bgConfig = (HStillImageBackgroundConfiguration) bgDev.getBestConfiguration(bgTemplate);
        
        try
        {
            bgDev.setBackgroundConfiguration(bgConfig);
        }
        catch (java.lang.Exception e)
        {
            System.out.println(e.toString());
        }
        HSceneTemplate sceneTemplate = new HSceneTemplate();
      
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION,new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
    }

    public void startXlet() throws XletStateChangeException
    {
        bgImg1.load(this);
        UserEventRepository mijnRep = new UserEventRepository("User event");
        mijnRep.addAllArrowKeys();
        mijnRep.addKey(HRcEvent.VK_ENTER);
        mijnRep.addKey(HRcEvent.VK_BACK_SPACE);
        
        EventManager mijnMan = EventManager.getInstance();
        mijnMan.addUserEventListener(this,mijnRep);
    
        buttons = new ButtonComponent[numberOfColors];
        lives = new ButtonComponent[4][numberOfColors];
        colors = new Color[numberOfColors];
        feedbacks = new FeedbackComponent[numberOfColors];
        colorNames = new String[8];
        
        colors[0] = Color.RED;
        colors[1] = Color.GREEN;
        colors[2] = Color.BLUE;
        colors[3] = Color.PINK;
        colors[4] = Color.BLACK;
        colors[5] = Color.MAGENTA;
        colors[6] = new DVBColor(255,127,0,255); // Oranje
        colors[7] = Color.YELLOW;
        
        colorNames[0] = "Rood";
        colorNames[1] = "Groen";
        colorNames[2] = "Blauw";
        colorNames[3] = "Roos";
        colorNames[4] = "Zwart";
        colorNames[5] = "Paars";
        colorNames[6] = "Oranje";
        colorNames[7] = "Geel";
        
        makeRandomColors();
        
        // Color pick
        for(int i = 0; i < numberOfColors; i++)
        {
            buttons[i] = new ButtonComponent(colors[i], 40, 10+(70*i), colorNames[i], scene);
        }
        
        // Feedback
        for(int i = 0; i < numberOfColors; i++)
        {
            feedbacks[i] = new FeedbackComponent(425, 10+(70*i), scene);
        }
        
        // Guess buttons
        for(int y = 0; y < 4; y++)
        {
            // Guess button
            for(int i = 0; i < numberOfColors; i++)
            {
               lives[y][i] = new ButtonComponent(60, 150+(y*65), 10+(i*70), scene);
            }
        }
        
        // Highlight
        highlightButton = new ButtonComponent(Color.GRAY, 145, 70, scene);
    
        for(int i = 0; i < buttons.length; i++)
        {
            int previousButton = i - 1;
            int nextButton = i + 1;
            if(i == 0)
            {
                previousButton = buttons.length-1;
            }
            if(nextButton == buttons.length)
            {   
                nextButton = 0;
            }
            buttons[i].getButton().setFocusTraversal(buttons[previousButton].getButton(), buttons[nextButton].getButton(), null, null);
        }
        
        tekstLabelWon = new ButtonComponent(new DVBColor(255,255,255,179), 500, 0, "Gewonnen: "+wonCounter, scene, 200, 30);
        tekstLabelLoss = new ButtonComponent(new DVBColor(255,255,255,179), 500, 30, "Verloren: "+lossCounter, scene, 200, 30);
        tekstLabelInstr = new ButtonComponent(new DVBColor(255,255,255,179), 500, 60, "Backspace voor\r\nnieuw spel", scene, 200, 80);;
        
        scene.validate();
        scene.setVisible(true);
        buttons[0].getButton().requestFocus();
    }
    
    public void makeRandomColors()
    {
        // Make computer generated randomized correct color code
        
        // Make temp array
        Color[] selector = (Color[]) colors.clone();
        String[] selectorNames = (String[]) colorNames.clone();
        computerGeneratedRandomizedCorrectColorCode = new Color[4];
        for(int i = 0; i < 4; i++)
        {
            int newIndex = generateUniqueRandom(selector);
            computerGeneratedRandomizedCorrectColorCode[i] = selector[newIndex];
            System.out.println(selectorNames[newIndex]);
            
            Color[] tempArray = new Color[selector.length-1];
            String[] tempArrayNames = new String[selector.length-1];
            int indexTempArray = 0;
            for(int index = 0; index < selector.length; index++)
            {
                if(index != newIndex)
                {
                    tempArray[indexTempArray] = selector[index];
                    tempArrayNames[indexTempArray] = selectorNames[index];
                    indexTempArray++;
                }
            }
            selector = null;
            selector = (Color[]) tempArray.clone();
            
            selectorNames = null;
            selectorNames = (String[]) tempArrayNames.clone();
        }
    }
    
    public int generateUniqueRandom(Color[] selector)
    {
        Random rand = new Random();
        int newRandom = rand.nextInt(selector.length);
        
        return newRandom;
    }
    
    public void userEventReceived(UserEvent e)
    {
        if(e.getType()==KeyEvent.KEY_PRESSED)
        {
            if(!blockInput)
            {
                if(e.getCode()==HRcEvent.VK_ENTER)
                {
                    boolean sameColor = false;
                
                    for(int i = 0; i < 4; i++)
                    {
                        if(buttons[cursor].getColor() == lives[i][row].getColor())
                        {
                            sameColor = true;
                        }
                    }
                
                    if(!sameColor)
                    {
                        if(lives[guessCursor][row].isWhite())
                        {
                            filledIn++;
                        }
                        lives[guessCursor][row].changeColor(buttons[cursor].getColor(), scene);
                        guessCursor++;
                        if(guessCursor > 4-1)
                        {
                            guessCursor = 0;
                        }
                    }
                
                    if(filledIn > 3)
                    {
                        guessCursor = 0;
                        row++;
                        filledIn = 0;
                        checkCombination();
                    }
                    changeHighlight();
                }
            
                if(e.getCode()== HRcEvent.VK_LEFT)
                {
                    guessCursor--;
                    if(guessCursor < 0)
                    {
                        guessCursor = 3;
                    }
                    changeHighlight();
                }
                if(e.getCode()== HRcEvent.VK_RIGHT)
                {
                    guessCursor++;
                    if(guessCursor > 4-1)
                    {
                        guessCursor = 0;
                    }
                    changeHighlight();
                }
            
                if(e.getCode()== HRcEvent.VK_DOWN)
                {
                    cursor++;
                    if(cursor > numberOfColors-1)
                    {
                        cursor = 0;
                    }
                }
                if(e.getCode()==HRcEvent.VK_UP)
                {
                    cursor--;
                    if(cursor < 0)
                    {
                        cursor = numberOfColors-1;
                    }
                }
            }
            if(e.getCode()==HRcEvent.VK_BACK_SPACE)
            {
                System.out.println("reset");
                cursor = 0;
                row = 0;
                guessCursor = 0;
                filledIn=0;
                changeHighlight();
                for (int i = 0; i < feedbacks.length; i++)
                {
                    feedbacks[i].makeNeutral(scene);
                }
                
                // Guess buttons
                for(int y = 0; y < 4; y++)
               {
                    for(int i = 0; i < numberOfColors; i++)
                    {
                        lives[y][i].changeColor(Color.WHITE, scene);
                    }
               }
                
                //Make new random code
                makeRandomColors();
                
                buttons[0].getButton().requestFocus();
                blockInput = false;
            }
        }
    }
    
    public void changeHighlight(){
        highlightButton.changePos(145+(65*guessCursor), 5+(70*row), scene);
    }
    
    public void checkCombination()
    {
        int correctColors = 0;
        int correctPlaces = 0;
        
        for(int i = 0; i < 4; i++)
        {
            if(computerGeneratedRandomizedCorrectColorCode[i] == lives[i][row-1].getColor())
            {
                correctPlaces++;
            }
            else
            {
                boolean correctColor = false;
                for(int y = 0; y < 4; y++)
                {
                    if(computerGeneratedRandomizedCorrectColorCode[y] == lives[i][row-1].getColor())
                    {
                        correctColor = true;
                    }
                }
                if(correctColor)
                {
                    correctColors++;
                }
            }
        }
        feedbacks[row-1].setFeedback(correctColors, correctPlaces, scene);
        if(correctPlaces == 4)
        {
            wonCounter++;
            tekstLabelWon.changeText("Gewonnen: "+wonCounter, scene);
            blockInput = true;
        }
        else if(row == numberOfColors)
        {
            row = 0;
            changeHighlight();
            lossCounter++;
            tekstLabelLoss.changeText("Verloren: "+lossCounter, scene);
            blockInput = true;
            // Set first rule the correct code
            for(int y = 0; y < 4; y++)
            {
                lives[y][0].changeColor(computerGeneratedRandomizedCorrectColorCode[y],scene);
                feedbacks[0].setFeedback(0, 4, scene);
            }
        }
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void notifyRelease (ResourceProxy proxy) {}
    public void release (ResourceProxy proxy) {}
    public boolean requestRelease (ResourceProxy proxy, Object requestData) { return false;}
    
    public void imageLoaded(HBackgroundImageEvent e) {
        try{
            bgConfig.displayImage(bgImg1);
        }
        catch (Exception s)
        {
            System.out.println(s.toString());
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image kan niet geladen worden.");
    }
    
}
