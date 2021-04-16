package smashgutta;

public interface Square extends Collideable{
    public boolean isInsideSquare(Square square);
    public boolean isInsideSquare(Circle circle);
    public double getTop();
    public double getBottom();
    public double getLeft();
    public double getRight();
}
