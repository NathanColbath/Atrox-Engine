package com.atrox.tools;

import com.atrox.components.Transform;
import com.atrox.main.GameContainer;
import com.atrox.math.Vector2f;
import com.atrox.math.Vector2i;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class Input {

    private GameContainer gc;

    private static Mouse mouse;
    private static Keyboard keyboard;


    public Input(GameContainer gc) {
        this.gc = gc;

        mouse = new Mouse();
        keyboard = new Keyboard();


    }

    public static int getMouseX() {
        return mouse.getX();
    }

    public static int getMouseY() {
        return mouse.getY();
    }

    public static boolean isMouseLeftPressed() {
        return mouse.isLeftPressed();
    }

    public static boolean isMouseMiddlePressed() {
        return mouse.isMiddlePressed();
    }

    public static boolean isMouseRightPressed() {
        return mouse.isMiddlePressed();
    }

    public static boolean isKeyDown(int code) {
        return keyboard.getSimpleCodes()[code];
    }

    public static boolean isKeyUp(int code) {
        return !keyboard.getSimpleCodes()[code];
    }

    public static boolean isKeyPressed(int code) {
        return keyboard.getSingleCodes()[code];
    }


    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }


    public void update(GameContainer gc) {
        keyboard.update();
        mouse.update(gc);
    }


    public static final int ALT = 18,
            ARROW_DOWN = 40,
            ARROW_LEFT = 37,
            ARROW_RIGHT = 39,
            ARROW_UP = 38,
            BACKSPACE = 8,
            CAPS_LOCK = 20,
            CONTROL = 17,
            DELETE = 46,
            END = 35,
            ENTER = 13,
            ESCAPE = 27,

    F1 = 112,
            F2 = 113,
            F3 = 114,
            F4 = 115,

    PAGE_DOWN = 34,
            PAGE_UP = 33,
            PAUSE = 19,
            PRINT_SCREEN = 44,
            SCROLL_LOCK = 145,
            SHIFT = 16,
            SPACE = 32,
            TAB = 9,

    A = 65,
            B = 66,
            C = 67,
            D = 68,
            E = 69,
            F = 70,
            G = 71,
            H = 72,
            I = 73,
            J = 74,
            K = 75,
            L = 76,
            M = 77,
            N = 78,
            O = 79,
            P = 80,
            Q = 81,
            R = 82,
            S = 83,
            T = 84,
            U = 85,
            V = 86,
            W = 87,
            X = 88,
            Y = 89,
            Z = 90,
            N_0 = 48,
            N_1 = 49,
            N_2 = 50,
            N_3 = 51,
            N_4 = 52,
            N_5 = 53,
            N_6 = 54,
            N_7 = 55,
            N_8 = 56,
            N_9 = 57
                    ;

}

class Mouse extends MouseAdapter {

    private int mouseX,mouseY, mx,my;
    private int mouseWheelValue;

    private boolean leftPressed,rightPressed,middlePressed;

    private void updateMouse(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

    }

    public void mouseClicked(MouseEvent e) {
        updateMouse(e);
    }

    public void mouseDragged(MouseEvent e) {
        updateMouse(e);
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        updateMouse(e);
    }

    public void mousePressed(MouseEvent e) {
        updateMouse(e);

        if(e.getButton() == 0) {
            leftPressed = true;
        }

        if(e.getButton() == 1) {
            middlePressed = true;
        }

        if(e.getButton() == 2) {
            rightPressed = true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        updateMouse(e);

        if(e.getButton() == 0) {
            leftPressed = false;
        }

        if(e.getButton() == 1) {
            middlePressed = false;
        }

        if(e.getButton() == 2) {
            rightPressed = false;
        }
    }

    public void mouseWheelMoved(MouseEvent e) {
        //TODO
    }

    public int getX() {
        return mx;
    }

    public int getY() {
        return my;
    }

    public int getMouseWheelValue() {
        return mouseWheelValue;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isMiddlePressed() {
        return middlePressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void update(GameContainer gc) {


        double scaleX = gc.getRenderer().getScale().x;
        double scaleY = gc.getRenderer().getScale().y;

        AffineTransform transform = AffineTransform.getScaleInstance(scaleX,scaleY); //Create a transform then scale it


        try{
            transform = transform.createInverse(); //Invert the transform
        }catch(Exception e){

        }
        Point2D location = new Point(mouseX,mouseY);


        transform.transform(location,location); //Create the scaled cordnates and push them to the location point

        if(gc.getRenderer().getCamera() != null){
            Vector2i camPos = gc.getRenderer().getCamera().getComponent(Transform.class).position.toVector2i();
            mx = (int)location.getX() + camPos.x;
            my = (int)location.getY() + camPos.y;

        }else {
            mx = (int)location.getX();
            my = (int)location.getY();

        }




    }


}

class Keyboard extends KeyAdapter {

    private boolean simpleCodes[];
    private boolean singleCodes[];

    private int singlePress;
    private int code;

    public Keyboard() {
        simpleCodes = new boolean[256];
        singleCodes = new boolean[256];
        singlePress = 0;
    }

    public void update() {
        if(singlePress == 1) {
            singleCodes[code] = false;
            singlePress = 0;
        }
    }


    public void keyPressed(KeyEvent e) {
        simpleCodes[e.getKeyCode()] = true;
        singleCodes[e.getKeyCode()] = true;
        code = e.getKeyCode();
        singlePress = 1;

    }

    public void keyReleased(KeyEvent e) {
        simpleCodes[e.getKeyCode()] = false;
        singleCodes[e.getKeyCode()] = false;
        singlePress = 0;
    }

    public void keyTyped(KeyEvent e) {

    }

    public boolean[] getSingleCodes() {
        return singleCodes;
    }

    public boolean[] getSimpleCodes() {
        return simpleCodes;
    }




}

