package smashgutta;

public interface GravityAffected {
    default void applyGravity(Gravity gravity){
        addSpeed(new Vector2(0, gravity.getAx()));
    };

    default void addSpeed(Vector2 v){
        getSpeed().add(v);
    }

    Vector2 getSpeed();
}
