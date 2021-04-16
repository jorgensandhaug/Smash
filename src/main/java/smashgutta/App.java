package smashgutta;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX Application which handles the layout of the GUI
 */
public class App extends Application {
    private GraphicsContext graphicsContext;
    private List<GameObject> gameObjects = new ArrayList<>();
    private Player p1;
    private Player p2;
    private long deltaTime;
    private long oldTime;
    private long startNanoTime = 0;
    private double t;
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        var canvas = new CanvasPane(800, 336);

        graphicsContext = canvas.getCanvas().getGraphicsContext2D();



        root.setCenter(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(keyPressedHandler);
        scene.setOnKeyReleased(keyReleasedHandler);


        p1 = new Player("Shrek");
        p2 = new Player("Wario", p1);
        gameObjects.add(p1);
        gameObjects.add(p2);


        final long nanoTime = System.nanoTime();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                t = (l-startNanoTime)/1e9;
                if(t>2) {
                    t = 0.016;
                }

                startNanoTime = l;

                double t2 = (l-nanoTime)/(1000000000.0);

                //System.out.println(Math.round(1/t)+" FPS");



                deltaTime = l - oldTime;
                oldTime = l;

               //System.out.println("FPS: " + 1000000000d / deltaTime);

                graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                for (GameObject gameObject : gameObjects) {
                    gameObject.render(graphicsContext);
                }
            }
        };
        timer.start();

    }
    /**
     * Stops the javafx application and terminates gui
     */
    @Override
    public void stop(){
        System.exit(0);
    }
/**
     * Launches the program
     */
    public static void main(String[] args) {
        launch();
    }


    private EventHandler<KeyEvent> keyPressedHandler = keyEvent ->{
        System.out.println(keyEvent.getCode());
        if(keyEvent.getCode() == KeyCode.A)
            p1.setLEFT(true);
        else if(keyEvent.getCode() == KeyCode.D)
            p1.setRIGHT(true);
        else if(keyEvent.getCode() == KeyCode.W)
            p1.jump();
        else if(keyEvent.getCode() == KeyCode.E)
            p1.basicAttack();

        if(keyEvent.getCode() == KeyCode.LEFT)
            p2.setLEFT(true);
        else if(keyEvent.getCode() == KeyCode.RIGHT)
            p2.setRIGHT(true);
        else if(keyEvent.getCode() == KeyCode.UP)
            p2.jump();
        else if(keyEvent.getCode() == KeyCode.CONTROL)
            p2.basicAttack();
    };
    private EventHandler<KeyEvent> keyReleasedHandler = keyEvent ->{
        if(keyEvent.getCode() == KeyCode.A)
            p1.setLEFT(false);
        else if(keyEvent.getCode() == KeyCode.D)
            p1.setRIGHT(false);
        else if(keyEvent.getCode() == KeyCode.E){
            p1.resetSprite();
        }

        if(keyEvent.getCode() == KeyCode.LEFT)
            p2.setLEFT(false);
        else if(keyEvent.getCode() == KeyCode.RIGHT)
            p2.setRIGHT(false);
    };
}
