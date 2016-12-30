package controllers.scenes;

import controllers.BaseController;
import controllers.GameSetting;
import controllers.PlaneController;
import controllers.manangers.BodyManager;
import controllers.manangers.ControllerManager;
import controllers.manangers.EnemyControllerManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by minhh on 28/12/2016.
 */
public class PlayGameScene extends  GameScene{
    Image background;
    Vector<BaseController> controllers;


    public PlayGameScene(){
        controllers = new Vector<>();
        controllers.add(ControllerManager.explosion);
        controllers.add(new EnemyControllerManager());
        controllers.add(PlaneController.instance);
        controllers.add(BodyManager.instance);
        controllers.add(ControllerManager.enemyBullet);
        controllers.add(ControllerManager.instance);
        background = loadImage("resources/background.png");
        setGameOver();
    }
    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);

        for (BaseController baseController : this.controllers) {
            baseController.draw(g);
        }

    }

    @Override
    public void run() {
        for(BaseController baseController: controllers) {
            baseController.run();
        }
        setGameOver();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        PlaneController.instance.keyPressed(e);

    }
    public void setGameOver(){
        if(!PlaneController.instance.getModel().isAlive()){
            this.sceneListener.replaceScene(
                    new GameOverScene(),
                    true
            );
        }
    }
}
