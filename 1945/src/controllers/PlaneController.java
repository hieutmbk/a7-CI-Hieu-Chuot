package controllers;

import controllers.enemies.EnemyBulletController;
import controllers.manangers.BodyManager;
import controllers.manangers.ControllerManager;
import models.Model;
import utils.Utils;
import views.Animation;
import views.SingleView;
import views.View;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by apple on 12/3/16.
 */
public class PlaneController extends Controller implements Body {

    private static final int SPEED = 5;
    private int hp = 10;
    private int turn = 3;
    private  int timeCount;

    public KeySetting keySetting;

    private ControllerManager bulletManager;

    public static final PlaneController instance =  createPlane(400, 400);

    private PlaneController(Model model, View view) {
        super(model, view);
        bulletManager = new ControllerManager();
        BodyManager.instance.register(this);
    }

    public void keyPressed(KeyEvent e) {
        if(keySetting != null) {
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.keyUp) {
                model.move(0, -SPEED);
            } else if (keyCode == keySetting.keyDown) {
                model.move(0, SPEED);
            } else if (keyCode == keySetting.keyLeft) {
                model.move(-SPEED, 0);
            } else if (keyCode == keySetting.keyRight) {
                model.move(SPEED, 0);
            } else  if(keyCode == keySetting.keyShoot) {
                shoot();
            }
        }
    }

    @Override
    public void run() {
        super.run();
        bulletManager.run();

        if (!this.getModel().isAlive()){
            timeCount++;
            if(turn>0){
               if(timeCount == 200){
                   this.hp = 10;
                   this.getModel().setAlive(true);
                   this.getModel().setX(400);
                   this.getModel().setY(400);
                   BodyManager.instance.register(this);
                   timeCount = 0;
               }
           }
           if(turn <=0){
                System.exit(0 );
           }
        }
    }

    @Override
    public void draw(Graphics g) {
           if(this.getModel().isAlive()) {
               super.draw(g);
               bulletManager.draw(g);
           }
    }

    private void shoot() {
        Utils.playSound("resources/Laser.wav", false);
        BulletController bulletController = BulletController.create(this.model.getMidX() - BulletController.WIDTH/ 2,
                this.model.getY() - BulletController.HEIGHT);
        bulletManager.add(bulletController);
    }

    // Design pattern
    // Factory
    private static PlaneController createPlane(int x, int y) {
        PlaneController planeController = new PlaneController(
                new Model(x, y, 70, 50),
                new SingleView(Utils.loadImage("resources/plane3.png"))
        );
        return planeController;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof EnemyBulletController) {
            this.hp --;
            if(this.hp <= 0){this.model.setAlive(false);
            turn --;
            destroy();
            Utils.playSound("resources/Randomize.wav",false);
            }
        }
    }

    public void destroy() {
        ExplosionController explosionController = new ExplosionController(
                new Model(this.getModel().getX(), this.getModel().getY(), 70, 50),
                new Animation(Utils.loadSheet("resources/explosion.png", 32, 32, 1, 6))
        );
        ControllerManager.explosion.add(explosionController);
    }
}
