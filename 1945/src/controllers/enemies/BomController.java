package controllers.enemies;

import controllers.Body;
import controllers.Controller;
import controllers.PlaneController;
import controllers.manangers.BodyManager;
import models.Model;
import utils.Utils;
import views.SingleView;
import views.View;

/**
 * Created by minhh on 26/12/2016.
 */
public class BomController extends Controller implements Body {
    private static final double R = 300.0;

    public BomController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    @Override
    public void run() {
        this.getModel().move(0,1);

    }
    public static BomController createBom(int x,int y){
        BomController bomController = new BomController(
                new Model(x,y,50,50),
                new SingleView(Utils.loadImage("resources/bomb.png"))
        );
        return bomController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneController){
            this.getModel().setAlive(false);
            for(int i = 0; i < BodyManager.instance.getBodies().size(); i++){
                Body enemyPlane = BodyManager.instance.getBodies().get(i);
                if(enemyPlane instanceof EnemyController) {
                    double x = enemyPlane.getModel().getX() - this.getModel().getX();
                    double y = enemyPlane.getModel().getY() - this.getModel().getY();
                    double r = Math.sqrt((x*x)+(y*y));
                    if(r < R) {
                        enemyPlane.getModel().setAlive(false);
                        ((EnemyController) enemyPlane).destroy();
                    }
                }
            }
        }
    }
}
