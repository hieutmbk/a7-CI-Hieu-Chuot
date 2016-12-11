package controllers;

import models.Model;
import utils.Utils;
import view.View;

import java.awt.*;
import java.util.Vector;

/**
 * Created by minhh on 11/12/2016.
 */
public class EnemyGreenController extends Controller
{
    private static final int SPEED_Y = 1;
    private static final int WIDTH = 28;
    private static final int HEIGHT = 28;
    private static final int SPEED_X = 1;
    private int timeCounter;

    private Vector<EnemyBulletController> enemyBulletVector;

    public EnemyGreenController(Model model, View view) {
        super(model, view);
        enemyBulletVector = new Vector<>();
    }

    public void run(){
        this.model.move(SPEED_X,SPEED_Y);
        timeCounter++;
        if(timeCounter > 30){
            shoot();
            timeCounter = 0;
        }

        for (EnemyBulletController enemyBulletController : enemyBulletVector){
            enemyBulletController.model.move(5,5);
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
                this.model.getX() + WIDTH,
                this.model.getBottom()
        );
        this.enemyBulletVector.add(enemyBulletController);
    }

    public static EnemyGreenController createEnemy(int x, int y){
        EnemyGreenController enemyGreenController = new EnemyGreenController(
                new Model(x,y,WIDTH,HEIGHT),
                new View(Utils.loadImage("resources/enemy-green-1.png"))
        );
        return enemyGreenController;
    }
}
