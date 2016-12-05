package controllers;

import models.BulletModel;
import view.BulletView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by minhh on 05/12/2016.
 */
public class BulletController {
    public BulletModel bulletModel;
    public BulletView buleltView;

    public BulletController(BulletModel bulletModel, BulletView buleltView) {
        this.bulletModel = bulletModel;
        this.buleltView = buleltView;
    }
    public void move(int dx,int dy){
        bulletModel.move(dx,dy);
    }
    public void draw(Graphics g){buleltView.draw(g,bulletModel);}
    public  void run(){

    }
}
