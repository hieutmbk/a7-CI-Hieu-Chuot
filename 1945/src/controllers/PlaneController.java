package controllers;

import controllers.managers.BodyManager;
import models.Model;
import utils.Utils;
import view.View;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by minhh on 03/12/2016.
 */
public class PlaneController extends Controller implements Body {

    private static final int SPEED = 5;

    public KeySetting keySetting;

    public PlaneController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void keyPressed(KeyEvent e){
        if (keySetting != null){
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyUp()){
                model.move(0,-SPEED);
            }else if(keyCode == keySetting.getKeyDown()){
                model.move(0,SPEED);
            }else if(keyCode == keySetting.getKeyLeft()){
                model.move(-SPEED,0);
            }else if(keyCode == keySetting.getKeyRight()){
                model.move(+SPEED,0);
            }
        }
    }
    //Design parttern : Factory
    public static PlaneController creatPlane(int x,int y){
        PlaneController planeController = new PlaneController(
                new Model(x,y,70,50,2,10),
                new View(Utils.loadImage("resources/plane3.png")));
        return planeController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof EnemyBulletController){
            System.out.println("Trung dan dich");
            
            this.model.setAlive(false);
        }
    }
}
