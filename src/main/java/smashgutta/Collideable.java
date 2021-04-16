package smashgutta;

public interface Collideable {
    public void doesCollide(Collideable collideable);
    public Collision collision(Player player);
}
