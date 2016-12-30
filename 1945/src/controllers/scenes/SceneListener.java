package controllers.scenes;

/**
 * Created by minhh on 28/12/2016.
 */
public interface SceneListener {
    void replaceScene(GameScene newScene,boolean addToBackStack);
}
