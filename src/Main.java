import com.atrox.components.Transform;
import com.atrox.controllers.ResourceManager;
import com.atrox.controllers.StateController;
import com.atrox.graphics.Camera;
import com.atrox.graphics.Drawable;
import com.atrox.graphics.Window;
import com.atrox.main.GameContainer;
import com.atrox.math.Vector2f;
import com.atrox.math.Vector2i;
import com.atrox.tools.Debug;
import com.atrox.tools.Version;

import java.awt.*;

public class Main {

    public static void main(String[] args){
        Window window = new Window(720,480,"Atrox: " + Version.getVersion);
        GameContainer gc = new GameContainer();
        gc.setWindow(window);
        //gc.create();
        gc.start();


        gc.getFileManager().setWorkingDirectory("./Assets");
        ResourceManager.addSprite("test.png");
        ResourceManager.addAnimationPackage("testAnimation");


        gc.getStateController().addState("gamestate",new gamestate());
        StateController.setCurrentState("gamestate");


    }

}
