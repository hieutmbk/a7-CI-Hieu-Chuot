package controllers;

import models.Model;
import utils.Utils;
import view.View;

import java.awt.*;

/**
 * Created by minhh on 05/12/2016.
 */
public class BulletController extends Controller  {

    public BulletController(Model model, View view) {
        super(model, view);
    }

    public  void run(){
        this.model.move(0,-5);
    }

    public static BulletController creatBullet(int x,int y){
        BulletController bulletController = new BulletController(
                new Model(x,y,12,30),
                new View(Utils.loadImage("resources/bullet.png"))
        );
        return  bulletController;
    }

}
