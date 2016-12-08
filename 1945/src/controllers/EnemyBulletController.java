package controllers;

import models.Model;
import utils.Utils;
import view.View;

/**
 * Created by minhh on 08/12/2016.
 */
public class EnemyBulletController extends Controller {
    public EnemyBulletController(Model model, View view) {
        super(model, view);
    }
    public  void run(){
        this.model.move(0,+5);
    }

    public static EnemyBulletController createComtBullet(int x, int y){
        EnemyBulletController enemyBulletController =new EnemyBulletController(
                new Model(x,y,12,30),
                new View(Utils.loadImage("resources/enemy_bullet.png"))
        );
        return enemyBulletController;
    }

}
