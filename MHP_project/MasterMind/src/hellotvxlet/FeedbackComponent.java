/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import org.havi.ui.HScene;

/**
 *
 * @author student
 */
public class FeedbackComponent
{
    private ButtonComponent[] buttons;
    
    private Color neutralColor = Color.GRAY;
    private Color colorCorrectColor = Color.WHITE;
    private Color fullCorrectColor = Color.BLACK;

    public FeedbackComponent(int x, int y, HScene scene)
    {
        this.buttons = new ButtonComponent[4];
        
        this.buttons[0] = new ButtonComponent(28, x, y, scene);
        this.buttons[1] = new ButtonComponent(28, x+32, y, scene);
        this.buttons[2] = new ButtonComponent(28, x, y+32, scene);
        this.buttons[3] = new ButtonComponent(28, x+32, y+32, scene);
        
        this.makeNeutral(scene);
    }
    
    public void setFeedback(int colorCorrect, int fullCorrect, HScene scene)
    {
        for(int button = 0; button < colorCorrect; button++)
        {
            this.buttons[button].changeColor(colorCorrectColor ,scene);
        }
        
        for(int button = colorCorrect; button < (fullCorrect+colorCorrect); button++)
        {
            this.buttons[button].changeColor(fullCorrectColor ,scene);
        }
    }
    
    public void makeNeutral(HScene scene)
    {
        for(int button = 0; button < 4; button++)
        {
            this.buttons[button].changeColor(neutralColor ,scene);
        }
    }

}
