import controllers.*;
import controllers.managers.EnemyControllerManager;
import controllers.managers.EnemyGreenControllerManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import java.util.Vector;

//Data abstraction
/**
 * Created by minhh on 30/11/2016.
 */
public class GameWindow extends Frame implements  Runnable{
    Image background;

    PlaneController planeController;

    EnemyControllerManager enemyControllerManager;
    EnemyGreenControllerManager enemyGreenControllerManager;

    Vector<BulletController> bulletVector;
    Vector<EnemyBulletController> enemyBulletVector;

    BufferedImage backBuffer;

    public GameWindow (){
        bulletVector = new Vector<>();
        enemyBulletVector = new Vector<>();

        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT);
        planeController = PlaneController.creatPlane(300,500);
        planeController.keySetting = keySetting;

        enemyControllerManager = new EnemyControllerManager();
        enemyGreenControllerManager = new EnemyGreenControllerManager();

        setVisible(true);
        setSize(800,600);
        background = Utils.loadImage("resources/background.png");
        backBuffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                planeController.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    int bulletX = planeController.getModel().getX() + 35 -6;
                    int bulletY = planeController.getModel().getY() - 30;
                    BulletController bulletController = BulletController.creatBullet(bulletX,bulletY);
                    bulletVector.add(bulletController);
                }
            }

            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });

    }



    public void update(Graphics g) {
        //Prepare backbuffer
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background,0,0,800,600,null);
        planeController.draw(backBufferGraphics);
        enemyControllerManager.draw(backBufferGraphics);
        enemyGreenControllerManager.draw(backBufferGraphics);
        for(BulletController bulletController : bulletVector)
                bulletController.draw(backBufferGraphics);
        for(EnemyBulletController enemyBulletController : enemyBulletVector)
                enemyBulletController.draw(backBufferGraphics);

        //Update window
        g.drawImage(backBuffer,0,0,800,600,null);
    }


    public void run() {
        while (true) {
            try {
                this.repaint();
                Thread.sleep(17);
                enemyControllerManager.run();
               enemyGreenControllerManager.run();
                for (BulletController bulletController : bulletVector)
                    bulletController.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
