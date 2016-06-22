package hellotvxlet;

import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, UserEventListener 
{

    HScene scene;
    int schipx = 350;
    MijnComponent mc;
            
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
      scene=HSceneFactory.getInstance().getDefaultHScene();
      mc=new MijnComponent(0,0,720,576);
   
        
      
      scene.add(mc);
      scene.validate();
      scene.setVisible(true);
      
    }

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void callback()
    {
       // stery++;
       // mc.movesterren(stery);
        //if(stery>570) stery=570;
    }
    
    public void startXlet() throws XletStateChangeException {
        /*MijnTimerTask objTimerTask = new MijnTimerTask(this);
        Timer timer1= new Timer();
        timer1.scheduleAtFixedRate(objTimerTask,0,10);*/
        
        
        UserEventRepository userEvents=new UserEventRepository("naam");
      userEvents.addAllArrowKeys();
      EventManager ev=EventManager.getInstance();
      ev.addUserEventListener(this,userEvents);
    }
    
    public void userEventReceived(UserEvent e) {
        System.out.println(e.toString());
        //schipx++;
        //mc.moveship(schipx);
        
        if(e.getType()==KeyEvent.KEY_PRESSED) {
            
            if(e.getCode()==HRcEvent.VK_RIGHT) {
            schipx--; 
         mc.moveship(schipx);
        }
            if(e.getCode()==HRcEvent.VK_LEFT) {
             schipx++; 
         mc.moveship(schipx);
        }
        }
    }

  
   
}
