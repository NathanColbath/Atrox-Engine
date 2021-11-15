package com.atrox.main;

import com.atrox.components.State;
import com.atrox.controllers.FileManager;
import com.atrox.controllers.ObjectController;
import com.atrox.controllers.ResourceManager;
import com.atrox.controllers.StateController;
import com.atrox.graphics.Camera;
import com.atrox.graphics.Renderer;
import com.atrox.graphics.Window;
import com.atrox.math.Vector2i;
import com.atrox.tools.Debug;
import com.atrox.tools.Input;
import com.atrox.tools.Version;

public class GameContainer implements Runnable {


    private static Window window;
    private Renderer renderer;
    private Input input;

    private ObjectController objectController;
    private StateController stateController;
    private FileManager fileManager;
    private ResourceManager resourceManager;

    private int _fps;


    private Thread mainThread;
    private boolean isRunning = false;

    private boolean isCreated = false;



    public GameContainer(){

    }

    public void setWindow(Window window){
        this.window = window;
    }

    public void create(){

        if(window == null){
            Debug.error("No window has been assigned");
            return;
        }

        renderer = new Renderer(this);
        System.setProperty("sun.java2d.opengl", "true");

        renderer.getCanvas().setSize(window.getWidth(),window.getHeight());
        window.addComponent(renderer.getCanvas());

        objectController = new ObjectController(renderer);
        stateController = new StateController(objectController,this);
        fileManager = new FileManager();
        resourceManager = new ResourceManager(this);

        input = new Input(this);
        renderer.getCanvas().addKeyListener(input.getKeyboard());
        renderer.getCanvas().addMouseListener(input.getMouse());
        renderer.getCanvas().addMouseMotionListener(input.getMouse());
        renderer.getCanvas().addMouseWheelListener(input.getMouse());


        Camera camera = new Camera(new Vector2i(window.getWidth(),window.getHeight()));
        renderer.setCamera(camera);
        isCreated = true;
    }

    //Thread
    public void run(){

        if(!isCreated){
            Debug.error("Must call create function");
            return;
        }

        double acc = 0;
        long currentTime,lastUpdate = System.currentTimeMillis();
        double updateRate = 1.0d/120.0d;
        double nextStateTime = System.currentTimeMillis();
        int fps = 0;

        while(isRunning) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            acc += lastRenderTimeInSeconds;
            lastUpdate = currentTime;
            if(acc > updateRate) {
                while(acc > updateRate) {

                    update();

                    acc -= updateRate;
                }
                render();
                fps += 1;
            }


            if(System.currentTimeMillis() > nextStateTime) {
            nextStateTime = System.currentTimeMillis() + 1000;
            _fps = fps;
            fps = 0;
            }
        }
    }

    public synchronized void start(){
        if(!isRunning){
            isRunning = true;
            mainThread = new Thread(this);
            mainThread.start();
        }
    }

    public synchronized void stop(){
        try{
            isRunning = false;
            mainThread.join();
        }catch(Exception e){

        }
    }

    private void update(){
        input.update(this);
        objectController.update();
        stateController.update();
        //Debug.logln("FPS: " + _fps);
    }

    private void render(){
        renderer.render();
    }


    //GETTERS

    public static Window getWindow(){
        return window;
    }

    public Renderer getRenderer(){
        return renderer;
    }

    public ObjectController getObjectController(){
        return objectController;
    }
    public StateController getStateController(){
        return stateController;
    }
    public FileManager getFileManager(){return fileManager;}
    public ResourceManager getResourceManager(){return resourceManager;}
    public int getFPS(){
        return _fps;
    }
}
