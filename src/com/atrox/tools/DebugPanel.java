package com.atrox.tools;

import com.atrox.controllers.ObjectController;
import com.atrox.graphics.Drawable;
import com.atrox.main.GameContainer;
import com.atrox.math.Vector2i;

import java.awt.*;

public class DebugPanel extends Drawable {

    private Vector2i pos;
    private GameContainer gc;
    public DebugPanel(GameContainer gc, Vector2i position){
        pos = position;
        this.gc = gc;
    }
    @Override
    public void render(Graphics2D g) {

        Color white = new Color(Color.white.getRed(),Color.white.getGreen(),Color.white.getBlue(),100);
        Color black = new Color(Color.black.getRed(),Color.black.getGreen(),Color.black.getBlue(),100);

        g.setColor(white);
        g.fillRect(pos.x,pos.y,125,155);
        Font old = g.getFont();
        Font f = new Font("Arial",Font.BOLD,10);
        g.setFont(f);
        g.setColor(black);
        g.drawString("Object Count: " + ObjectController.getCurrentListOfGameObjects().size(),pos.x + 5,pos.y + 15);
        g.drawString("Drawables Count: " + gc.getRenderer().getNumberOfRenderObjects(),pos.x + 5,pos.y + 30);
        g.drawString("FPS: " + gc.getFPS(),pos.x + 5, pos.y + 45);

        g.setColor(black);
        g.drawRect(pos.x,pos.y,125,155);

        g.setFont(old);
    }
}
