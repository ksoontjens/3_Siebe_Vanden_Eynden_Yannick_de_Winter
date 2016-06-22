/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import org.dvb.ui.DVBColor;
import java.awt.Color;
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
        g.setColor(new DVBColor(0,0,127,179));
        g.fillRoundRect(10, 10, 190, 100, 15, 15);
        //g.drawLine(0, 0, 300, 300);//relatief ten opzichte van de positie van de component
        //g.drawLine(200, 0, 0, 200);
        g.setColor(new DVBColor(0,0,255,179));
        g.fillRoundRect(0, 0, 190, 100, 15, 15);
        //2de fillRoundRect voor schaduw
        
        
        g.setColor(Color.YELLOW);
        g.drawString("Hello world", 20, 40);
    }
}
