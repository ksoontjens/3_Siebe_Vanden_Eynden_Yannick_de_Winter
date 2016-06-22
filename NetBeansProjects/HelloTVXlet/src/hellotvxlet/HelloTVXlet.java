package hellotvxlet;


import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;

import org.havi.ui.*;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {
XletContext actueleXletContext;
    
    
  HScene scene;
  HTextButton button1;
  HTextButton button2;
  HTextButton button3;
  HTextButton button4;
  HTextButton hulplijn;
  
  boolean debug=true;
  HStaticText tekstlabel;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException{
     scene= HSceneFactory.getInstance().getDefaultHScene(); 
     
    }

    public void startXlet() throws XletStateChangeException{
    HStaticText hst=new HStaticText("Wie was de eerste president\n van de Verenigde Staten", 40, 350, 640, 50);
    hst.setBackground(Color.BLACK);
    hst.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button1=new HTextButton("Washington", 40, 470, 300, 50);
    //x1, x2, breedte, hoogte
    button2=new HTextButton("Clinton", 40, 520, 300, 50);
    button3=new HTextButton("Obama", 380, 470, 300, 50);
    button4=new HTextButton("Lincon", 380, 520, 300, 50);
    hulplijn= new HTextButton("Hulplijn",380,250,300,50);
    
    
    button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
    hulplijn.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button1.setBackground(Color.BLUE);
    button2.setBackground(Color.BLUE);
    button3.setBackground(Color.BLUE);
    button4.setBackground(Color.BLUE);
    hulplijn.setBackground(Color.BLUE);
    button1.setFocusTraversal(null, button2, null, button3);
    button2.setFocusTraversal(button1, null, null, button4);
    button3.setFocusTraversal(null, button4, button1, null);
    button4.setFocusTraversal(button3, null, button2, null);
    hulplijn.setFocusTraversal(button1, button2, button3, button4);
    
    
    
    button1.setActionCommand("Knop1");
    button1.addHActionListener(this);
    
    button2.setActionCommand("Knop2");
    button2.addHActionListener(this);
    
    button3.setActionCommand("Knop3");
    button3.addHActionListener(this);
    
    button4.setActionCommand("Knop4");
    button4.addHActionListener(this);
    
    hulplijn.setActionCommand("Hulplijn");
    hulplijn.addHActionListener(this);
    
    
    scene.add(hst);
    scene.add(button1);
    scene.add(button2);
    scene.add(button3);
    scene.add(button4);
    scene.add(hulplijn);
    scene.validate();
    scene.setVisible(true);
    button1.requestFocus();
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getActionCommand().equals("Hulplijn"))
        {
            scene.remove(button3);scene.remove(button4);
            scene.repaint();
            button1.requestFocus();
            button1.setFocusTraversal(null, button2, null, null);
            button3.setFocusTraversal(button1, null, null, null);
            
            return; //exit methode
        }
        
        
        if (arg0.getActionCommand().equals("Knop1")) {
         //System.out.println("JUIST!");
         HStaticText antwoord=new HStaticText("JUIST!", 300, 200, 120 , 50);
         scene.add(antwoord);
         antwoord.setBackground(Color.GREEN);
         antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
         scene.repaint();
        
        }else{
            HStaticText antwoord=new HStaticText("FOUT", 300, 200, 120 , 50);
            antwoord.setBackground(Color.RED);
         antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
         scene.add(antwoord);
         scene.repaint();
         scene.popToFront(antwoord);
         
        }
        
        
        System.out.println(arg0.getActionCommand());
    }
    
}
