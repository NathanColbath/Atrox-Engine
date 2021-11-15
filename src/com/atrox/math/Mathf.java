package com.atrox.math;

import java.awt.*;

public class Mathf {
	
	public static Vector2f angleToVector(float angle) {
		float vx = (float)Math.cos(Math.toRadians(angle));
        float vy = (float)Math.sin(Math.toRadians(angle));
        
        Vector2f vec = new Vector2f(vx,vy);
        return vec;
	}
	
	public static float getAngle(Vector2f start, Vector2f stop){
        double hyp = getDistance(start.x,start.y,stop.x,stop.y);
  
        
        //double angle = Math.toDegrees(Math.asin(ops/hyp));
        
        double angle = (float) Math.toDegrees(Math.atan2(stop.y - start.y, stop.x - start.x));
        
        angle = angle + Math.ceil( -angle / 360 ) * 360;
        
        
        return (float)angle;
        
    }
	
	public static double getDistance(float x1, float y1, float x2, float y2){
        double xx = Math.pow((x1-x2),2);
        double yy = Math.pow((y1-y2),2);
        
        return Math.sqrt(xx + yy);
    }


    public static float lerp(float start, float end, float t){
        return start * (1-t) + end * t;
    }

    public static Vector2f vectorLerp(Vector2f start, Vector2f end, float t){
        return new Vector2f(lerp(start.x,end.x,t),lerp(start.y,end.y,t));
    }

    public static int getStringLength(String string, Graphics2D g){
        return g.getFontMetrics().stringWidth(string);

    }

    public static int gtStringHeight(Graphics2D g){
        return g.getFontMetrics().getHeight();
    }



}
