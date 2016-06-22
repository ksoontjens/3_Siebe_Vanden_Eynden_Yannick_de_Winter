/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import org.dvb.ui.DVBColor;
import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HComponent;
/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
Image schip;
Image sterren;
    int sx=350,sy=450;
    public MijnComponent (int x, int y, int w, int h)
    {
        
        this.setBounds(x, y, w, h);//x,y,Breedte,Hoogte
        schip=this.getToolkit().getImage("schip.png");
        sterren=this.getToolkit().getImage("sterren.png");
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(schip,0);
        mt.addImage(sterren, 1);
        try {
         mt.waitForAll();   
        } catch (InterruptedException ex)
        {
        ex.printStackTrace();
        }
       
    }
     //public void movesterren (int y){
      //sterren=y;
    //this.repaint();
    //}
    public void moveship (int x){
     sx=x;
     
    this.repaint();
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
        g.drawImage(schip, sx, sy, null);
    }
}
