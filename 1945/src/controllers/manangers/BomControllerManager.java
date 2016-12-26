package controllers.manangers;

import controllers.enemies.BomController;

import java.util.Random;

/**
 * Created by minhh on 26/12/2016.
 */
public class BomControllerManager extends ControllerManager {

    private  int counter;
    public void run() {
        super.run();
        counter++;
        if (counter == 400) {
            spawn();
            counter = 0;
        }
    }

    private void spawn() {
        //1: Create enemy
        Random rd = new Random();
        int rand = rd.nextInt(800);
        BomController bomController = BomController.createBom(rand,0);
        this.controllers.add(bomController);
    }
}
