package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.control.Label;
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
        if(obj.getGobj().getBoundsInParent().intersects(group_game.localToParent(this.getGobj().getBoundsInParent()))) {
            TranslateTransition translate_object = translate_an_object(this.getGobj(), 250, 0, 500);
            translate_object.play();
            translate_object.setOnFinished(e -> move_orc_down());
        }
        return false;
    }
    public boolean collision_weapon(GameObject obj, Group group_game, Group group_hero) {
        if(obj.getGobj().getBoundsInParent().intersects(group_game.localToParent(this.getGobj().getBoundsInParent()))) {
            return true;
        }
        return false;
    }
    public void move_orc_down() {
        TranslateTransition translate_object = translate_an_object(this.getGobj(), 0, 500, 2000);
        translate_object.play();
    }
    public void die(GameObject obj)
    {
        Player player = (Player) obj;
        player.addCoins(2);
        move_orc_down();
    }
   @Override
    public void move() {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(this.getGobj(), 0, -120, 1000);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
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
