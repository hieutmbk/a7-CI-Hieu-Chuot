package models;

import java.awt.*;

/**
 * Created by minhh on 07/12/2016.
 */
public class Model {
    private int x;
    private int y;
    private int width;
    private int height;
    private int atk;
    private int hp;
    private boolean isAlive = true;

    public Model(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Model(int x, int y, int width, int height, int atk, int hp) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.atk = atk;
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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

    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }

    public boolean intersects(Model other){
        Rectangle rect1 = this.getRec();
        Rectangle rect2 = other.getRec();
        return rect1.intersects(rect2);
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int attack(Model other) {
        this.hp = this.hp - other.atk;
        return this.hp;
    }

}
