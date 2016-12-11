package controllers.managers;

import controllers.Controller;

import java.awt.*;
import java.util.Vector;

/**
 * Created by minhh on 10/12/2016.
 */
public class ControllerManager {
    protected Vector<Controller> controllerVector;

    public ControllerManager(){
        controllerVector = new Vector<>();
    }

    public void draw(Graphics g){
        for (Controller controller : controllerVector)
            controller.draw(g);
    }

    public void run(){
        for (Controller controller : controllerVector)
            controller.run();
    }
    public void add(Controller controller){
        this.controllerVector.add(controller);
    }
    public void remove(Controller controller){
        this.controllerVector.remove(controller);
    }
}
