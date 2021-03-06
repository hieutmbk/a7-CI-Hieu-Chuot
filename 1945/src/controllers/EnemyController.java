package controllers;

import controllers.managers.BodyManager;
import models.Model;
import utils.Utils;
import view.View;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by minhh on 08/12/2016.
 */
public class EnemyController extends  Controller implements Body{

    private static final int SPEED = 1;
    private static final int WIDTH = 70;
    private static final int HEIGHT = 50;
    private int timeCounter;

    private Vector<EnemyBulletController> enemyBulletVector;

    public EnemyController(Model model, View view) {
        super(model, view);
        enemyBulletVector = new Vector<>();
        timeCounter = 0;
        BodyManager.instance.register(this);

    }

    public void run(){
        this.model.move(0, SPEED);
        timeCounter++;
        if(timeCounter > 50){
            shoot();
            timeCounter = 0;
        }
        for (EnemyBulletController enemyBulletController : enemyBulletVector){
            enemyBulletController.run();
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (EnemyBulletController enemyBulletController : this.enemyBulletVector){
            enemyBulletController.draw(g);
        }
    }

    public void shoot() {
        EnemyBulletController enemyBulletController = EnemyBulletController.create(
                this.model.getMid() - EnemyBulletController.WIDTH/2,
                this.model.getBottom()
        );
                this.enemyBulletVector.add(enemyBulletController);
    }

    public static EnemyController createEnemy(int x, int y){
        EnemyController enemyController = new EnemyController(
          new Model(x,y,WIDTH,HEIGHT,1,2),
          new View(Utils.loadImage("resources/plane1.png"))
        );
        return enemyController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof  BulletController) {
            System.out.println("Trung may bay");
            this.model.setAlive(false);
        }
    }

}
