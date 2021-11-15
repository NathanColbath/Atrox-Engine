import com.atrox.components.Animation;
import com.atrox.components.GameObject;
import com.atrox.components.Sprite;
import com.atrox.components.Transform;
import com.atrox.controllers.ResourceManager;
import com.atrox.math.Mathf;
import com.atrox.math.Vector2f;
import com.atrox.math.Vector2i;
import com.atrox.tools.Input;

import java.awt.*;

public class TestObject extends GameObject {

    private Sprite sprite;
    private Animation animation = new Animation(ResourceManager.getAnimationPackage("testAnimation"));
    public TestObject(String tag) {
        super(tag);

        addComponent(animation);


        getComponent(Transform.class).position = new Vector2f(100,100);


        //origin = new Vector2f(16,16);

    }

    @Override
    public void update() {
        rotation = Mathf.getAngle(getComponent(Transform.class).position,new Vector2f(Input.getMouseX(),Input.getMouseY()));
    }

    @Override
    public void renderObject(Graphics2D g) {
        animation.getCurrentImage().draw(g,new Vector2i(32,32));
    }


}
