package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by minhh on 07/12/2016.
 */
public class Utils {
    //Utilities
    public static Image loadImage(String url){
        try {
            Image image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }

}
