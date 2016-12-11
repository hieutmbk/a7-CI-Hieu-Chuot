package models;

/**
 * Created by minhh on 07/12/2016.
 */
public class Model {
    private int x;
    private int y;
    private int width;
    private int height;

    public Model(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Model(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(int dx , int dy){
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public int getBottom(){
        return  this.y + this.getHeight();
    }
    public int getMid(){
        return this.x + this.getWidth()/2;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
