package com.atrox.graphics;

import javax.swing.*;
import java.awt.*;

public class Window {

    private int width,height;
    private  String title;

    private JFrame frame;


    public Window(int width, int height, String title){
        this.title = title;
        this.width = width;
        this.height = height;
        create();
    }

    private void create(){
        frame = new JFrame(title);
        Dimension dim = new Dimension(width,height);
        frame.setSize(dim);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public void addComponent(Component c){
        frame.add(c);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setSize(int width, int height){
        this.height = height;
        this.width = width;
    }

    public JFrame getFrame(){
        return frame;
    }


}
