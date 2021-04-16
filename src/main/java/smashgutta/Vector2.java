package smashgutta;

public class Vector2 {
    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 other){
        this.x += other.x;
        this.y += other.y;
    }

    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void scale(double scalar){
        this.x *= scalar;
        this.y *= scalar;
    }

    public double distance(Vector2 other){
        return Math.sqrt(Math.pow(y-other.y, 2) + Math.pow(x-other.x, 2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
