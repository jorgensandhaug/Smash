package smashgutta;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;

public class Player implements Circle, GameObject{
    private int stacks;
    private int percent;
    private String name;
    private boolean DOWN;
    private boolean RIGHT;
    private boolean LEFT;
    private boolean isFalling = false;
    private Vector2 pos;
    private Vector2 vel;
    private Vector2 acc;
    private float gravity = 0.0003f;
    private float strengthOfJump = 0.3f;
    private Image sprite;
    private Player opponent;
    private double radius;

    private int spriteIndex = 0;

    Image bowserImage = FetchImage.fetchImageURL("src/main/resources/smashgutta/bowser.jpg");
    Image shrekImage = FetchImage.fetchImageURL("src/main/resources/smashgutta/shrek.png");
    Image warioImage = FetchImage.fetchImageURL("src/main/resources/smashgutta/wario2.png");


    Image[] shrekAttackSprites = new Image[4];

    private double horizontalMovementSpeed = 0.1;


    public Player(String name){
        if(name.equals("Bowser"))
            sprite = bowserImage;
        else if(name.equals("Wario"))
            sprite = warioImage;
        else if(name.equals("Shrek")) {
            sprite = shrekImage;
            shrekAttackSprites[0] = FetchImage.fetchImageURL("src/main/resources/smashgutta/shrekHit1.png");
            shrekAttackSprites[1] = FetchImage.fetchImageURL("src/main/resources/smashgutta/shrekHit2.png");
            shrekAttackSprites[2] = FetchImage.fetchImageURL("src/main/resources/smashgutta/shrekHit3.png");
            shrekAttackSprites[3] = FetchImage.fetchImageURL("src/main/resources/smashgutta/shrekHit4.png");
        }

        this.radius = sprite.getWidth() * 1.41;


        this.name = name;
        stacks = 3;
        this.pos = new Vector2(100, 100);
        this.vel = new Vector2(0, 0);
        this.acc = new Vector2(0, 0);
    }

    public Player(String name, Player opponent){
        this(name);
        this.opponent = opponent;
        System.out.println("e");
        opponent.opponent = this;
        System.out.println("hie");
    }
    @Override
    public void render(GraphicsContext gc) {
        update(gc.getCanvas());
        gc.drawImage(sprite, pos.getX()-sprite.getWidth()/2, pos.getY()-sprite.getHeight()/2);

        gc.fillText("Stacks: " + stacks, pos.getX(), pos.getY() - sprite.getHeight()/2 - 10);
        gc.fillText("" +percent+"%", pos.getX() - 30, pos.getY() - sprite.getHeight()/2 - 10);
    }


    public void update(Canvas canvas){
        acc = new Vector2(0, gravity);
        //acc = new Vector2(0, 0);
        if(RIGHT)
            vel.setX(horizontalMovementSpeed);
        else if(LEFT)
            vel.setX(-horizontalMovementSpeed);
        else
            vel.setX(0);

        vel.add(acc);
        pos.add(vel);





        if(pos.getY() >= canvas.getHeight()-100) {
            vel.setY(0);
            pos.setY(canvas.getHeight()-100);
            isFalling = false;
        }
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public void setStrengthOfJump(float strengthOfJump) {
        this.strengthOfJump = strengthOfJump;
    }

    @Override
    public void doesCollide(Collideable collideable) {

    }

    @Override
    public Collision collision(Player player) {
        return null;
    }

    public void jump(){
        if(name.equals("Shrek"))
            sprite = shrekImage;

        System.out.println(isFalling);
        if(!isFalling) {
            vel.setY(-strengthOfJump);
            isFalling = true;
        }
    }

    public void basicAttack(){
        if(name.equals("Shrek")) {
            spriteIndex++;
            if (spriteIndex == 4)
                spriteIndex = 0;

            sprite = shrekAttackSprites[spriteIndex];
        }

        if(pos.distance(opponent.pos) < radius + opponent.radius){
            opponent.percent += 10;

            if(Math.random() * opponent.percent > 100) {
                opponent.stacks -= 1;
                opponent.percent = 0;
            }
        }
    }

    @Override
    public boolean isInsideCircle(Square square) {
        return false;
    }

    @Override
    public boolean isInsideCircle(Circle circle) {
        return false;
    }

    @Override
    public double[] getCenter() {
        return new double[2];
    }

    @Override
    public double getRadius() {
        return radius;
    }


    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
    }

    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
    }

    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    public void resetSprite(){
        if(name.equals("Shrek"))
            sprite = shrekImage;
    }


}
