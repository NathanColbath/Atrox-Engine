package com.atrox.graphics;

import com.atrox.math.Vector2f;

import java.awt.*;

public abstract class Drawable {

    public float rotation = 0;
    public Vector2f origin = new Vector2f(0,0);
    public abstract void render(Graphics2D g);

    public void renderUI(Graphics2D g){

    }

    public int layerIndex = 0;
}
