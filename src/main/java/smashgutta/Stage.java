package smashgutta;


import javafx.scene.canvas.GraphicsContext;

public class Stage implements Square, GameObject {
    private double top;
    private double bottom;
    private double left;
    private double right;
    private String name;

    public Stage(String name, int top, int bottom, int left, int right){
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.name = name;
    }


    @Override
    public void doesCollide(Collideable collideable) {

    }

    @Override
    public Collision collision(Player player) {
        return null;
    }

    @Override
    public boolean isInsideSquare(Circle circle) {
        return (circle.getCenter()[1]+circle.getRadius()>=top && circle.getCenter()[1]-circle.getRadius()<=bottom) && (circle.getCenter()[0]+circle.getRadius()>=left && circle.getCenter()[0]-circle.getRadius()<=right);
    }

    @Override
    public boolean isInsideSquare(Square square) {
        return (square.getBottom()>=top && square.getTop() <= bottom) && (square.getRight() >=left && square.getLeft() <= right);
    }

    @Override
    public double getBottom() {
        return bottom;
    }

    @Override
    public double getTop() {
        return top;
    }

    @Override
    public double getRight() {
        return right;
    }

    @Override
    public double getLeft() {
        return left;
    }

    @Override
    public void render(GraphicsContext gc) {
        //TODO skriv render kode her
    }
}
