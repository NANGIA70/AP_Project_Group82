package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Orc extends GameObject{
    private int jumpHeight;
    private int jumpDistance;
    private int health;

    public Orc(ImageView orc) {
        super(orc);
    }

    @Override
    public boolean collision(GameObject obj, Group group_game, Group group_hero) {
        return false;
    }

    public void move_orc_down() {
        TranslateTransition translate_object = translate_an_object(this.getGobj(), 0, 400, 2000);
        translate_object.play();
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
