package controllers;

import controllers.managers.BodyManager;
import models.Model;
import utils.Utils;
import view.View;

import java.awt.*;

/**
 * Created by minhh on 05/12/2016.
 */
public class BulletController extends Controller implements Body  {

    public BulletController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public  void run(){
        this.model.move(0,-5);
    }

    public static BulletController creatBullet(int x,int y){
        BulletController bulletController = new BulletController(
                new Model(x,y,12,30,1,2),
                new View(Utils.loadImage("resources/bullet.png"))
        );
        return  bulletController;
    }
    @Override
    public void onContact(Body other) {
        if(other instanceof EnemyController) {
            System.out.println("Trung dan");
            this.model.setAlive(false);
        }
    }
}
