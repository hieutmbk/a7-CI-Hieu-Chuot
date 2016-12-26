package controllers.manangers;

import controllers.enemies.EnemyController;
import controllers.enemies.EnemyType;

import java.util.Random;

/**
 * Created by apple on 12/10/16.
 */
public class EnemyControllerManager extends ControllerManager {

    int counter;
    @Override
    public void run() {
        super.run();
        counter++;
        if (counter == 50) {
            spawn();
            counter = 0;
        }
    }

    private int enemyCount;

    private void spawn() {
        //1: Create enemy
        Random rd = new Random();
        int rand = rd.nextInt(800);
        enemyCount++;
        EnemyController enemyController = null;
        if(enemyCount%2 == 0) {
            enemyController = EnemyController.create(rand, 0, EnemyType.WHITE);
        }else {
            enemyController = EnemyController.create(rand, 0, EnemyType.BROWN);
        }
            //2: Add new enemy to vector
        this.controllers.add(enemyController);
    }
}
