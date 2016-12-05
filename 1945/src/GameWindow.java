import controllers.BulletController;
import controllers.KeySetting;
import controllers.PlaneController;
import models.BulletModel;
import models.PlaneModel;
import view.BulletView;
import view.PlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

//Data abstraction
/**
 * Created by minhh on 30/11/2016.
 */
public class GameWindow extends Frame implements  Runnable{
    Image background;

    PlaneController planeController;

    Vector<BulletController> bulletVector;

    BufferedImage backBuffer;

    public GameWindow (){
        bulletVector = new Vector<>();

        PlaneModel planeModel = new PlaneModel(300,300);
        PlaneView planeView = new PlaneView(loadImage("resources/plane3.png"));
        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT);
        planeController = new PlaneController(planeModel,planeView);
        planeController.keySetting = keySetting;

        setVisible(true);
        setSize(800,600);
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
        background = loadImage("resources/background.png");

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
                    BulletModel bulletModel = new BulletModel(planeModel.getX(),planeModel.getY());
                    BulletView bulletView = new BulletView(loadImage("resources/bullet.png"));

                    BulletController bulletController = new BulletController(bulletModel,bulletView);
                    bulletVector.add(bulletController);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });

    }

    private Image loadImage(String url){
        try {
            Image image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public void update(Graphics g) {
        //Prepare backbuffer
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background,0,0,800,600,null);
        planeController.draw(backBufferGraphics);

       for(BulletController bulletController : bulletVector)
        bulletController.draw(backBufferGraphics);

        //Update window
        g.drawImage(backBuffer,0,0,800,600,null);
    }

    @Override
    public void run() {
        while (true) {
            this.repaint();
            try {
                Thread.sleep(17);
                for (BulletController bulletController : bulletVector)
                    bulletController.move(0,-5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
