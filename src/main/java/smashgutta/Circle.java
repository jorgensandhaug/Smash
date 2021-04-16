package smashgutta;

public interface Circle extends Collideable{
    public boolean isInsideCircle(Square square);
    public boolean isInsideCircle(Circle circle);
    public double[] getCenter();
    public double getRadius();
}
