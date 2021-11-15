package com.atrox.components;

import com.atrox.main.GameContainer;

import java.util.ArrayList;

public  abstract class State {

    private ArrayList<GameObject> stateObjects;
    public boolean created = false;
    public State(){
        stateObjects = new ArrayList<GameObject>();
    }

    public ArrayList<GameObject> getStateObjects(){
        return stateObjects;
    }

    public abstract void update();
    public abstract void init(GameContainer gc);
}
