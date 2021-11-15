package com.atrox.math;

public class Vector2i {

    public int x,y;
    public Vector2i(int x, int y){
        this.x = x; this.y = y;
    }

    public Vector2i add(Vector2i v2){
        return new Vector2i(x + v2.x, y + v2.y );
    }

    public Vector2i sub(Vector2i v2){
        return new Vector2i(x - v2.x,y - v2.y);
    }

    public Vector2i mult(Vector2i v2){
        return new Vector2i(x * v2.x, y * v2.y);
    }

    public Vector2i div(Vector2i v2){
        return new Vector2i(x / v2.x,y/v2.y);
    }
    public Vector2i copy(){
        return new Vector2i(x,y);
    }

    public float magnatude(){
        return (float)Math.sqrt((Math.pow(x,2) + Math.pow(y,2)));
    }

    public Vector2i normalise(){
        return new Vector2i((int)(x / magnatude()), (int)(y / magnatude()));
    }
}
