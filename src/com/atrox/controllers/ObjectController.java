package com.atrox.controllers;

import com.atrox.components.GameObject;
import com.atrox.components.State;
import com.atrox.components.Transform;
import com.atrox.graphics.Renderer;

import java.util.ArrayList;

public class ObjectController {

    private static ArrayList<GameObject> gameObjects;

    private static Renderer renderer;

    //TODO
    /*
    Implement the ablility for each states to have a reference to their own states
     */

    public ObjectController(Renderer renderer){
        gameObjects = new ArrayList<GameObject>();
        this.renderer = renderer;
    }

    public static void addObject(GameObject o){

        gameObjects.add(o);
        renderer.addDrawable(o);

    }

    public static void removeObject(GameObject o){
        gameObjects.remove(o);
        renderer.removeDrawable(o);
    }

    public void update(){
        for(int i =0; i < gameObjects.size(); i++){
            gameObjects.get(i).update();
            for(int j = 0; j < gameObjects.get(i).getComponentsList().size(); j++){
                gameObjects.get(i).getComponentsList().get(j).run();
            }
        }
    }

    public void changeState(State newState){
        for(int i =0; i < gameObjects.size(); i++){
            renderer.removeDrawable(gameObjects.get(i));
        }
        gameObjects = newState.getStateObjects();

        for(int i =0; i < gameObjects.size(); i++){
            renderer.addDrawable(gameObjects.get(i));
        }
    }

    public static GameObject getGameObjectByTag(String tag){
        for(int i = 0; i < gameObjects.size(); i++){
            if(gameObjects.get(i).getTag().equals(tag)){
                return gameObjects.get(i);
            }
        }

        return null;
    }

    public static ArrayList<GameObject> getCurrentListOfGameObjects(){
        return gameObjects;
    }
}
