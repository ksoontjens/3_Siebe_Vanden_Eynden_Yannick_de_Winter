package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet 
{

    HScene scene;
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
      scene=HSceneFactory.getInstance().getDefaultHScene();
      MijnComponent mc=new MijnComponent(200,0,200,200);
      MijnComponent mc2=new MijnComponent(200,200,200,200);
        
      
      scene.add(mc);
      scene.add(mc2);
      scene.validate();
      scene.setVisible(true);
    }

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startXlet() throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
