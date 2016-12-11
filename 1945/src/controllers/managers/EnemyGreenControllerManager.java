package controllers.managers;

import controllers.EnemyController;
import controllers.EnemyGreenController;

import java.util.Random;

/**
 * Created by minhh on 11/12/2016.
 */
public class EnemyGreenControllerManager extends  ControllerManager{
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
        EnemyGreenController enemyGreenController = EnemyGreenController.createEnemy(rand,0);
        // 2 : Add new enemy to vector
        this.controllerVector.add(enemyGreenController);
    }
}
