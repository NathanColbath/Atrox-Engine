package com.atrox.components;

import com.atrox.math.Vector2i;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite extends GameComponent {

    private File file;
    public BufferedImage spriteImage;

    public Sprite(File file){
        this.file = file;
        try {
            spriteImage = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Sprite(String path){
        this.file = new File(path);
        try {
            spriteImage = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void draw(Graphics2D g){

        Vector2i objectPos = gameObject.getComponent(Transform.class).position.toVector2i();
        g.drawImage(spriteImage,objectPos.x,objectPos.y,null);
    }

    public void draw(Graphics2D g, Vector2i size){
        Vector2i objectPos = gameObject.getComponent(Transform.class).position.toVector2i();
        g.drawImage(spriteImage,objectPos.x,objectPos.y,size.x,size.y,null);
    }

    public Sprite copy(){
        return new Sprite(file);
    }

    @Override
    public void run() {

    }
}
