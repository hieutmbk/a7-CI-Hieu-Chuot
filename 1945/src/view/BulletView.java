package view;

import models.BulletModel;

import java.awt.*;

/**
 * Created by minhh on 05/12/2016.
 */
public class BulletView {
    private Image image;

    public BulletView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g,BulletModel bulletModel){
        g.drawImage(image,bulletModel.getX()+35-6,bulletModel.getY()-30,12,30,null);
    }
}
