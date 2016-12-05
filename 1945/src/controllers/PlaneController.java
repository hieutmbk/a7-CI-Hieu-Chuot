package controllers;

import models.PlaneModel;
import view.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by minhh on 03/12/2016.
 */
public class PlaneController {
    public PlaneModel planeModel;
    public PlaneView planeView;

    public KeySetting keySetting;

    public PlaneController(PlaneModel planeModel, PlaneView planeView) {
        this.planeModel = planeModel;
        this.planeView = planeView;
    }

    public void keyPressed(KeyEvent e){
        if (keySetting != null){
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyUp()){
                planeModel.move(0,-5);
            }else if(keyCode == keySetting.getKeyDown()){
                planeModel.move(0,+5);
            }else if(keyCode == keySetting.getKeyLeft()){
                planeModel.move(-5,0);
            }else if(keyCode == keySetting.getKeyRight()){
                planeModel.move(+5,0);
            }
        }
    }
    public void draw(Graphics g){
        planeView.draw(g,planeModel);
    }

    public void run(){

    }
}
