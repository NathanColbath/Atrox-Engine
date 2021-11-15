package com.atrox.graphics;

import com.atrox.main.GameContainer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderString{

    private String string;
    private int x, y;



    public RenderString(String string, int x, int y, Graphics2D g){
        this.x = x;
        this.y = y;
        this.string = string;

        BufferedImage testString = new BufferedImage(GameContainer.getWindow().getWidth(), GameContainer.getWindow().getHeight(), BufferedImage.TRANSLUCENT);
        testString.getGraphics().setColor(Color.white);
        testString.getGraphics().drawString(string,x,y);
        testString.getGraphics().dispose();

        g.drawImage(testString,10,10,null);
    }

    public RenderString(String string, int x, int y, Color color, Graphics2D g){
        this.x = x;
        this.y = y;
        this.string = string;

        BufferedImage testString = new BufferedImage(GameContainer.getWindow().getWidth(), GameContainer.getWindow().getHeight(), BufferedImage.TRANSLUCENT);
        testString.getGraphics().setColor(color);
        testString.getGraphics().drawString(string,x,y);
        testString.getGraphics().dispose();

        g.drawImage(testString,10,10,null);
    }


}
