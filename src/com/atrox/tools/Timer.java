package com.atrox.tools;

public class Timer {

    private float timer;
    private float time;


    public Timer(float time){
        this.timer = time;
        this.time = timer;
    }

    public void tick(){
        timer -= 1;
    }

    public boolean isTriggered(){
        if(timer <= 0){
            timer = time;
            return true;
        }

        return false;
    }
}
