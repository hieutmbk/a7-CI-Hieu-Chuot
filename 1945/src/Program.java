/**
 * Created by minhh on 30/11/2016.
 */
public class Program {
    public static void main(String args[]){
        System.out.println("Hello Android 7");

        GameWindow gameWindow = new GameWindow();
        Thread thread  = new Thread(gameWindow);
        thread.start();
    }
}
