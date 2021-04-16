package smashgutta;

import java.io.FileInputStream;

import javafx.scene.image.Image;

public abstract class FetchImage {

    public static Image fetchImageURL(String url) {
        FileInputStream URL = null;
        try {
            URL = new FileInputStream(url);
            Image picture = new Image(URL);
            return picture;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

