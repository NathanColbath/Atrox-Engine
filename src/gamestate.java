import com.atrox.components.Animation;
import com.atrox.components.GameObject;
import com.atrox.components.State;
import com.atrox.components.Transform;
import com.atrox.controllers.ObjectController;
import com.atrox.graphics.Camera;
import com.atrox.graphics.Drawable;
import com.atrox.graphics.RenderString;
import com.atrox.main.GameContainer;
import com.atrox.math.Vector2f;
import com.atrox.math.Vector2i;
import com.atrox.tools.Debug;
import com.atrox.tools.DebugPanel;
import com.atrox.tools.Input;

import java.awt.*;
import java.awt.image.BufferedImage;

public class gamestate extends State {

    private Camera camera;

    @Override
    public void update() {
        if(Input.isKeyDown(Input.D)){
            camera.getComponent(Transform.class).position.add(new Vector2f(1,0));
        }

        if(Input.isKeyDown(Input.A)){
            camera.getComponent(Transform.class).position.add(new Vector2f(-1,0));
        }
    }

    @Override
    public void init(GameContainer gc) {

        camera = gc.getRenderer().getCamera();




        GameObject cursor = new GameObject("cursor") {
            @Override
            public void update() {
                getComponent(Transform.class).position = new Vector2f(Input.getMouseX(),Input.getMouseY());


            }


            @Override
            public void renderObject(Graphics2D g) {
                Vector2i pos = getComponent(Transform.class).position.toVector2i();
                g.setColor(Color.red);
                g.fillRect(pos.x,pos.y,32,32);
            }

            @Override
            public void renderUI(Graphics2D g) {

            }
        };





        ObjectController.addObject(new TestObject("test"));



    }
}
