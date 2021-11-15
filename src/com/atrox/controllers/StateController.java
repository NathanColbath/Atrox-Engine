package com.atrox.controllers;

import com.atrox.components.State;
import com.atrox.main.GameContainer;
import com.atrox.tools.Debug;

import java.util.HashMap;

public class StateController {

    private static HashMap<String,State> stateMap;
    private static State currentState;

    private static ObjectController controller;
    private static GameContainer gc;

    public StateController(ObjectController controller, GameContainer gc){
        stateMap = new HashMap<String, State>();
        currentState = null;
        this.controller = controller;
        this.gc = gc;
    }

    public void addState(String tag, State state){
        if(state == null){
            Debug.log("Attempting to add a null state with tag: " + tag);
        }
        stateMap.put(tag,state);
    }

    public void removeState(String tag){
        stateMap.remove(tag);
    }

    public static void setCurrentState(String tag){
        //TODO Make it so that each state will change the objects to render
        currentState = stateMap.get(tag);

        if(currentState == null){
            Debug.error("No state found: " + tag);
            return;
        }

        controller.changeState(currentState);
        if(currentState.created == false){
            currentState.init(gc);
            currentState.created = true;
        }



    }

    public void update(){

        if(currentState != null){
            //TODO updateState
            currentState.update();
        }


    }
}
