package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Orc extends GameObject{
    private int jumpHeight;
    private int jumpDistance;
    private int healthpoints;
    private  TranslateTransition orc_translate_object ;
    public Orc(ImageView orc,int healthpoints)
    {
        super(orc);
        this.healthpoints = healthpoints;
    }

    @Override
    public boolean collision(GameObject obj, Group group_game, Group group_hero) {

        if(group_hero.localToParent(obj.getGobj().getBoundsInParent()).intersects(group_game.localToParent(this.getGobj().getBoundsInParent())))
        {
            TranslateTransition translate_object = translate_an_object(this.getGobj(), 250, 0, 500);
            translate_object.play();
            translate_object.setOnFinished(e -> move_orc_down());
            return true;
        }
        return false;
    }

    public boolean collision_weapon(GameObject obj, Group group_game, Group group_hero) {
        return group_hero.localToParent(obj.getGobj().getBoundsInParent()).intersects(group_game.localToParent(this.getGobj().getBoundsInParent()));
    }

    public void move_orc_down() {
        TranslateTransition translate_object = translate_an_object(this.getGobj(), 0, 1000, 2000);
        translate_object.play();
        orc_translate_object.stop();
    }

    public void die(GameObject obj) {
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
        orc_translate_object = translate_object;
        translate_object.play();
    }
    public void move_orc(AnchorPane content, ArrayList<Island> islandsArrayList, Group group_game, Group group_hero) {
        TranslateTransition translate_object = translate_an_object(this.getGobj(), 0, -120, 500);
        translate_object.setOnFinished(e -> orc_fall_down(content, islandsArrayList, group_game, group_hero));
        translate_object.play();
    }
    public void move_orc_under_gravity(AnchorPane content, ArrayList<Island> islandsArrayList, Group group_game, Group group_hero) throws IOException {
        TranslateTransition translate_object1 = translate_an_object(this.getGobj(), 0,1 , 10);
        if(check_island_collision(islandsArrayList, group_game, group_hero)) {
            translate_object1.setOnFinished(e -> move_orc(content, islandsArrayList, group_game, group_hero));
        }
        else {
            translate_object1.setOnFinished(e -> {
                try {
                    this.move_orc_under_gravity(content, islandsArrayList, group_game, group_hero);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }
        translate_object1.play();
    }
    public boolean check_island_collision(ArrayList<Island> islands, Group group_game, Group group_hero) {
        for(int i =0;i<islands.size();i++)
        {
            if (islands.get(i).check_orc_collision(this, group_game)) {
                return true;
            }
        }
        return false;
    }
    private void orc_fall_down(AnchorPane content, ArrayList<Island> islandsArrayList, Group group_game, Group group_hero) {
        TranslateTransition translate_object1 = translate_an_object(this.getGobj(), 0,1 , 10);
        translate_object1.setOnFinished(e -> {
            try {
                move_orc_under_gravity(content, islandsArrayList, group_game, group_hero);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        translate_object1.play();
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
        return healthpoints;
    }

    public void setHealth(int health)
    {
        this.healthpoints = health;
    }
}
