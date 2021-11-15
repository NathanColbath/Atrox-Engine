package com.atrox.math;

public class Vector2f {

    public float x,y;
    public Vector2f(float x, float y){
        this.x = x; this.y = y;
    }

    public Vector2f add(Vector2f v2){
        x += v2.x;
        y += v2.y;
        return new Vector2f(x + v2.x, y + v2.y );
    }

    public Vector2f sub(Vector2f v2){
        x -= v2.x;
        y -= v2.y;
        return new Vector2f(x - v2.x,y - v2.y);
    }

    public Vector2f mult(Vector2f v2){
        x *= v2.x;
        y *= v2.y;
        return new Vector2f(x * v2.x, y * v2.y);
    }

    public Vector2f div(Vector2f v2){
        x /= v2.x;
        y /= v2.y;
        return new Vector2f(x / v2.x,y/v2.y);
    }

    public Vector2f copy(){
        return new Vector2f(x,y);
    }

    public Vector2f mult(float scale){
        x *= scale;
        y *= scale;
        return new Vector2f(x,y);
    }

    public float magnatude(){
        return (float)Math.sqrt((Math.pow(x,2) + Math.pow(y,2)));
    }

    public Vector2f normalise(){
        return new Vector2f(x / magnatude(), y / magnatude());
    }

    public Vector2i toVector2i(){
        return new Vector2i((int)x,(int)y);
    }
}
