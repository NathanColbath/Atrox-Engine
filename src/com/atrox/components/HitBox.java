package com.atrox.components;

import com.atrox.controllers.ObjectController;
import com.atrox.math.Vector2f;
import com.atrox.tools.Debug;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class HitBox extends GameComponent{

    public Vector2f size;
    public GameObject other;

    public HitBox(Vector2f size){
        this.size = size;
    }
    @Override
    public void run() {

    }



    public boolean isColliding(String tag){
        ArrayList<GameObject> objs = ObjectController.getCurrentListOfGameObjects();
        Transform transform = gameObject.getComponent(Transform.class);
        Rectangle2D.Float ourRect = new Rectangle2D.Float((int)transform.position.x,(int)transform.position.y,(int)size.x,(int)size.y);

        //AffineTransform ts = AffineTransform.getRotateInstance(gameObject.rotation,gameObject.origin.x,gameObject.origin.y);

        //ourRect = (Rectangle2D.Float) ts.createTransformedShape(ourRect);

        for(int i = 0; i < objs.size(); i++){
            GameObject temp = objs.get(i);


            if(temp.getComponent(HitBox.class) != null && temp != gameObject){
                //TODO Check for collisions

                Transform otherT = temp.getComponent(Transform.class);
                HitBox otherH = temp.getComponent(HitBox.class);


                Rectangle2D.Float rect = new Rectangle2D.Float((int)otherT.position.x,(int)otherT.position.y,(int)otherH.size.x,(int)otherH.size.y);

                //AffineTransform ots = AffineTransform.getRotateInstance(temp.rotation,temp.origin.x,temp.origin.y);

                //rect = (Rectangle2D.Float) ots.createTransformedShape(rect);


                //Debug.logln(rect.getBounds());
                //Debug.logln(ourRect.getBounds());

                boolean isColliding = (rect.getBounds().intersects(ourRect.getBounds()) && temp.getTag().equals(tag));
                if(isColliding){
                    other = temp;
                    return true;
                }

            }

        }
        other = null;
        return false;
    }
}
