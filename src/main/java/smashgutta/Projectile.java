package smashgutta;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Projectile implements Circle, GameObject{
    private Vector2 velocity;
    private double[] center;
    private double[] radius;

    @Override
    public double[] getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return 0;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Paint.valueOf("red"));
        gc.fillOval(center[0] - 10, center[1] - 10, 10, 10);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    @Override
    public boolean isInsideCircle(Circle circle) {
        return false;
    }

    @Override
    public boolean isInsideCircle(Square square) {
        return false;
    }

    @Override
    public void doesCollide(Collideable collideable) {

    }

    @Override
    public Collision collision(Player player) {
        return null;
    }
}
