/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Font;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class ButtonComponent extends HComponent{
    
    private HTextButton button;
    private Color color;
    
    private int grootte = 60;

    public ButtonComponent(Color color, int x, int y, String name, HScene scene)
    {
        this.button=new HTextButton(name, x, y, grootte, grootte);
        this.button.setBackgroundMode(HVisible.BACKGROUND_FILL);
        this.button.setBackground(color);
        this.color = color;
        this.button.setBordersEnabled(false);
        
        scene.add(button);
    }
    public ButtonComponent(Color color, int x, int y, String name, HScene scene, int sizeX, int sizeY)
    {
        this.button=new HTextButton(name, x, y, sizeX, sizeY);
        this.button.setBackgroundMode(HVisible.BACKGROUND_FILL);
        this.button.setBackground(color);
        this.button.setBordersEnabled(false);
        this.button.setForeground(Color.BLACK);
        
        scene.add(button);
    }
    
    public ButtonComponent(int size, int x, int y, HScene scene)
    {
        this.button=new HTextButton("", x, y, size, size);
        this.button.setBackgroundMode(HVisible.BACKGROUND_FILL);
        this.button.setBackground(Color.WHITE);
        this.color = Color.WHITE;
        this.button.setBordersEnabled(false);
        
        scene.add(button);
    }
    
    public ButtonComponent(Color color, int x, int size, HScene scene)
    {
        this.button=new HTextButton("", x, 5, size, size);
        this.button.setBackgroundMode(HVisible.BACKGROUND_FILL);
        this.button.setBackground(color);
        this.button.setBordersEnabled(false);
        this.color = color;
        
        scene.add(button);
    }
    
    public HTextButton getButton()
    {
        return this.button;
    }
    
    public Color getColor()
    {
        return this.color;
    }
    
    public void changeColor (Color color, HScene scene)
    {
        this.button.setBackground(color);
        scene.repaint();
        this.color = color;
    }
    
    public void changeX(int x, HScene scene)
    {
        this.button.setLocation(x, 155);
        scene.repaint();
    }

    public void changePos(int x, int y, HScene scene) {
        this.button.setLocation(x, y);
        scene.repaint();
    }
    
    public void changeText(String newText, HScene scene)
    {
        System.out.println("changed");
        this.button.setTextContent(newText, this.button.NORMAL_STATE);
        scene.repaint();
    }
    
    public boolean isWhite()
    {
        return this.color == Color.WHITE;
    }
}
