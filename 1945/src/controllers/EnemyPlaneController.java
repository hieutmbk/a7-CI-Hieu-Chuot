package controllers;

import models.Model;
import utils.Utils;
import view.View;

/**
 * Created by minhh on 08/12/2016.
 */
public class EnemyPlaneController extends  Controller{

    public EnemyPlaneController(Model model, View view) {
        super(model, view);
    }
    public  void run(){
        this.model.move(0,1);
    };
    public static EnemyPlaneController createPlaneCom(int x, int y){
        EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
          new Model(x,y,70,50),
          new View(Utils.loadImage("resources/plane1.png"))
        );
        return enemyPlaneController;
    }
}
