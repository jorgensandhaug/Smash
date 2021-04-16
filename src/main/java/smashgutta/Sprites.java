package smashgutta;

import javafx.scene.image.Image;

public class Sprites {
    public static Image WARIO(){
        return new Image(Sprites.class.getResource("wario.png").toExternalForm());
    }

    public static Image BOWSER(){
        return new Image(Sprites.class.getResource("bowser.png").toExternalForm());
    }
}
