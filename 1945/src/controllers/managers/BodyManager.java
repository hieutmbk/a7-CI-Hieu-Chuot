package controllers.managers;

import controllers.Body;
import models.Model;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by minhh on 14/12/2016.
 */
public class BodyManager {
    private Vector<Body> bodies;
    public static final BodyManager instance = new BodyManager();

    public BodyManager(){
        bodies = new Vector<>();
    }
    public void register(Body body){
        this.bodies.add(body);
    }
    public void checkContact(){
        for (int i = 0 ; i < bodies.size() - 1 ;i++){
            for(int j = i+ 1; j < bodies.size();j++){
                Body bodyi = bodies.get(i);
                Body bodyj = bodies.get(j);

                Model modeli = bodyi.getModel();
                Model modelj = bodyj.getModel();

                if(modeli.intersects(modelj)){
                    bodyi.onContact(bodyj);
                    bodyj.onContact(bodyi);
                }
            }
        }
        Iterator<Body> iterator = bodies.iterator();
        while (iterator.hasNext()) {
            Body body = iterator.next();
            if (!body.getModel().isAlive()) {
                iterator.remove();
            }
        }
    }
}
