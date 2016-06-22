/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import org.havi.ui.HComponent;
/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {

    public MijnComponent (int x, int y, int w, int h) 
    {
        this.setBounds(x, y, w, h);//x,y,Breedte,Hoogte
    }
     
    public void paint(Graphics g)
    {
        g.drawLine(0, 0, 300, 300);//relatief ten opzichte van de positie van de component
        g.drawLine(200, 0, 0, 200);
    }
}
