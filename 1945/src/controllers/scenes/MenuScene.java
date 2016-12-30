package controllers.scenes;

import controllers.GameSetting;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by minhh on 28/12/2016.
 */
public class MenuScene extends GameScene {
    Image background;
    public MenuScene(){
    background = Utils.loadImage("resources/1945-logo.png");
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            this.sceneListener.replaceScene(
                    new PlayGameScene(),
                    true
            );
    }
}
