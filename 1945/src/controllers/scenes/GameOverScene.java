package controllers.scenes;

import controllers.GameSetting;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by minhh on 30/12/2016.
 */
public class GameOverScene extends GameScene {
    Image background;
    public GameOverScene(){
    background = Utils.loadImage("resources/gameover.png");
    }
    public void update(Graphics g) {
    g.drawImage(background,0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        this.sceneListener.back();
    }
}
