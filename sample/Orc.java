package sample;

import javafx.scene.image.ImageView;

public abstract class Orc extends GameObject{
    private int jumpHeight;
    private int jumpDistance;
    private int health;

    public Orc(ImageView orc) {
        super(orc);
    }

    public void Die() {

    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public int getJumpDistance() {
        return jumpDistance;
    }

    public void setJumpDistance(int jumpDistance) {
        this.jumpDistance = jumpDistance;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
