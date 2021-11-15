package com.atrox.components;

import com.atrox.controllers.ObjectController;
import com.atrox.graphics.Drawable;
import com.atrox.math.Vector2f;
import com.atrox.math.Vector2i;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public abstract class GameObject extends Drawable {

    private ArrayList<GameComponent> components;
    private String tag;
    public Transform transform;

    public GameObject(String tag){
        components = new ArrayList<GameComponent>();
        this.tag = tag;

        addComponent(new Transform());
        transform = getComponent(Transform.class);
    }

    public abstract void update();

    public void addComponent(GameComponent c){
        c.gameObject = this;
        components.add(c);

        if(c.getClass().getName().equals(Animation.class.getName())){
            Animation temp = getComponent(Animation.class);

            for(int i = 0; i < temp.getAllFrames().length; i++){
                temp.getAllFrames()[i].gameObject = this;
            }
        }
    }

    @Override
    public final void render(Graphics2D g) {

        Vector2i renderLocation = origin.toVector2i();
        Vector2i pos = transform.position.toVector2i();

        AffineTransform old = g.getTransform();
        g.rotate(Math.toRadians(rotation),pos.x + renderLocation.x,pos.y + renderLocation.y);

        renderObject(g);
        g.setTransform(old);

    }

    public abstract void renderObject(Graphics2D g);

    public void removeComponent(GameComponent c){
        components.remove(c);
    }

    public <T extends GameComponent> T getComponent(Class<T> cClass){


        for(GameComponent c: components){
            if(cClass.isAssignableFrom(c.getClass())){
                return cClass.cast(c);
            }
        }

        return null;
    }


    public void instantiate(GameObject toCreate, Vector2f position){
        toCreate.transform.position = position.copy();
        ObjectController.addObject(toCreate);
    }

    public void instantiate(GameObject toCreate, Vector2f position, float rotation){
        toCreate.transform.position = position.copy();
        toCreate.rotation = rotation;
        ObjectController.addObject(toCreate);
    }

    public void destroy(GameObject toDestroy){
        ObjectController.removeObject(toDestroy);
    }


    public ArrayList<GameComponent> getComponentsList(){
        return components;
    }

    public String getTag(){
        return tag;
    }
}
