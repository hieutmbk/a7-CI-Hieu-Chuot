package controllers;

import controllers.managers.BodyManager;
import models.Model;
import utils.Utils;
import view.View;

/**
 * Created by minhh on 08/12/2016.
 */
public class EnemyBulletController extends Controller implements Body {


    public static final int SPEED = 5;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    public EnemyBulletController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }
    public  void run(){
        this.model.move(0, SPEED);
    }

    public static EnemyBulletController create(int x, int y){
        EnemyBulletController enemyBulletController =new EnemyBulletController(
                new Model(x,y,WIDTH,HEIGHT,2,15),
                new View(Utils.loadImage("resources/bullet-round.png"))
        );
        return enemyBulletController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneController){
            this.model.setAlive(false);
        }
    }
}
