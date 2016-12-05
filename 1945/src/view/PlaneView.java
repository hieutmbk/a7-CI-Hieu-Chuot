package view;

import models.PlaneModel;

import java.awt.*;

/**
 * Created by minhh on 03/12/2016.
 */
public class PlaneView {
    private Image image;

    public PlaneView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, PlaneModel planeModel){
        g.drawImage(image,planeModel.getX(),planeModel.getY(),70,50,null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
