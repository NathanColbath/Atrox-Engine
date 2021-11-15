package com.atrox.graphics;

import com.atrox.components.Transform;
import com.atrox.main.GameContainer;
import com.atrox.math.Vector2f;
import com.atrox.math.Vector2i;
import com.atrox.tools.Debug;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Renderer {

    private Graphics2D g2d;
    private Canvas canvas;
    private static Camera renderCam;

    private ArrayList<Drawable> renderObjects;
    private Vector2f scale;
    private GameContainer gc;

    public Renderer(GameContainer gc){
        canvas = new Canvas();
        renderObjects = new ArrayList<Drawable>();
        this.gc = gc;
        scale = new Vector2f(1,1);
    }

    public void addDrawable(Drawable d){
        renderObjects.add(d);
    }

    public void removeDrawable(Drawable d){
        renderObjects.remove(d);
    }

    public void render(){
        BufferStrategy bs = canvas.getBufferStrategy();
        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }

        g2d = (Graphics2D) bs.getDrawGraphics();

        //RENDER
            if(renderCam != null){
                renderCam.update();
                Vector2i camPos = renderCam.getComponent(Transform.class).position.toVector2i();


                Window window = gc.getWindow();


                scale = new Vector2f((float)window.getFrame().getWidth() / renderCam.viewSize.x, (float)window.getFrame().getHeight() / renderCam.viewSize.y);

                g2d.scale(scale.x,scale.y);
                g2d.setColor(Color.black);
                g2d.fillRect(0,0,renderCam.viewSize.x,renderCam.viewSize.y);


                g2d.translate(-camPos.x,-camPos.y);

            }



            for(int i = 0; i < renderObjects.size(); i++){

                renderObjects.get(i).render(g2d);
            }

            g2d.translate(0,0);
        for(int i = 0; i < renderObjects.size(); i++){
            renderObjects.get(i).renderUI(g2d);
        }
        //

        bs.show();
        g2d.dispose();
    }

    public Graphics2D getGraphics(){
        return g2d;
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public int getNumberOfRenderObjects(){
        return renderObjects.size();
    }

    public void setCamera(Camera cam){
        this.renderCam = cam;
    }

    public static Camera getCamera(){
        return renderCam;
    }

    public Vector2f getScale(){
        return scale;
    }
}
