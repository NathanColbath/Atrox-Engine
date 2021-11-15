package com.atrox.graphics;

import com.atrox.components.GameObject;
import com.atrox.math.Vector2i;

import java.awt.*;

public class Camera extends GameObject {

    public Vector2i viewSize;

    public Camera(Vector2i viewSize) {
        super("Camera");
        this.viewSize = viewSize;
    }

    @Override
    public void update() {

    }


    @Override
    public void renderObject(Graphics2D g) {

    }

}
