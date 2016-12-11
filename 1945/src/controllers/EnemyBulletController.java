package controllers;

import models.Model;
import utils.Utils;
import view.View;

/**
 * Created by minhh on 08/12/2016.
 */
public class EnemyBulletController extends Controller {


    public static final int SPEED = 5;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private  int x;


    public EnemyBulletController(Model model, View view) {
        super(model, view);
    }
    public  void run(){
        x++;
        this.model.move(x, (int) (10+Math.sin(x)));
    }

    public static EnemyBulletController create(int x, int y){
        EnemyBulletController enemyBulletController =new EnemyBulletController(
                new Model(x,y,WIDTH,HEIGHT),
                new View(Utils.loadImage("resources/bullet-round.png"))
        );
        return enemyBulletController;
    }

}
