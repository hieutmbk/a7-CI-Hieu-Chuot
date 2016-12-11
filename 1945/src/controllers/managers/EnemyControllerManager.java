package controllers.managers;

import controllers.EnemyController;
import controllers.EnemyGreenController;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * Created by minhh on 10/12/2016.
 */
public class EnemyControllerManager extends  ControllerManager{
    private int timeCounter;

    public  void run(){
        super.run();
        timeCounter++;
        if(timeCounter > 50){
            spawn();
            timeCounter = 0;
        }
    }

    private void spawn() {
        Random rd = new Random();
        int rand = rd.nextInt(800);
        EnemyController enemyController = EnemyController.createEnemy(rand,0);
        // 2 : Add new enemy to vector
        this.controllerVector.add(enemyController);
    }
}
