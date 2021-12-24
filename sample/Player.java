package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Player extends GameObject{
    private int jumpHeight;
    private int jumpDistance;
    private Helmet helmet;
    private Coin coin;
    private int score = 0;
    private ImageView hero;

    public Player(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed,*/ int jumpHeight, int jumpDistance, Helmet helmet, Coin coin ,ImageView hero) {
//        super(x_Coordinate, y_Coordinate, x_Speed, y_Speed);
        super(hero);
        this.jumpHeight = jumpHeight;
        this.jumpDistance = jumpDistance;
        this.helmet = helmet;
        this.coin = coin;
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
//        implement collison with everyone
        return false;
    }

//    Collision Functions Start
    public boolean check_island_collision(ArrayList<Island> islands, Group group_game) {
        for(int i = 0; i < 24; i++) {
            if(islands.get(i).collision(this, group_game)) {
                return true;
            }
        }
        return false;
    }

//    Collision Functions End

//    Movement Functions Start
    @Override
    public void move() {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(Gobj, 0, -100, 1000);
        translate_object.setOnFinished(e -> hero_fall_down());
        translate_object.play();
    }

//    public void move_hero_under_gravity() {
//        TranslateTransition translate_object1 = translate_an_object(hero, 0,1 , 10);
//        if(check_island_collision() || check_falling_floor_collision()) {
//            if(!fall_floor && check_falling_floor_collision()) {
//                fall_floor = true;
//                fall_start(0);
//            }
//            translate_object1.setOnFinished(e -> this.move());
//        }
//        else {
//            translate_object1.setOnFinished(e -> move_hero_under_gravity());
//        }
//        translate_object1.play();
//    }

    private void hero_fall_down() {
        //TranslateTransition translate_object1 = translate_an_object(hero, 0,100 , 1000);
        TranslateTransition translate_object1 = translate_an_object(hero, 0,1 , 10);
//        translate_object1.setOnFinished(e -> move_hero_under_gravity());
        translate_object1.play();
    }
//
//    //    Function to move hero on mouse click
//    public void move_hero_small(int number) {
//        if(number < 1) {
//            move_click_hero_in_use = false;
//            return;
//        }
//        else {
//            check_collision();
//            TranslateTransition translate_object1 = translate_an_object(group_game, -1,0 , 5);
//            translate_object1.setOnFinished(e -> move_hero_small(number -1));
//            translate_object1.play();
//        }
//
//    }
//
//    public void move_ClickHero() {
//        if(!move_click_hero_in_use) {
//            //            Update distance
//            count+=1;
//            distance.setText(String.valueOf(count));
////            Move hero forward
//            move_click_hero_in_use = true;
//            TranslateTransition translate_object = translate_an_object(orc, -100, 0, 500);
//            translate_object.play();
//            TranslateTransition translate_object1 = translate_an_object(group_game, -1,0 , 5);
//            translate_object1.setOnFinished(e -> move_hero_small(100));
//            translate_object1.play();
//            check_collision();
//        }
//    }
//    Movement Functions End

    public void Die() {

    }

    public void useWeapon() {
        helmet.useWeapon();
    }

    public void increaseScore() {
        score++;
    }

    public void addCoins(int coinNum) {
        coin.addCoins(coinNum);
    }

    public void Revive() {

    }

    public void Kill() {

    }

    //    Getters and Setters
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

    public Helmet getHelmet() {
        return helmet;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

//    public ImageView getHero() {
//        return hero;
//    }
//
//    public void setHero(ImageView hero) {
//        this.hero = hero;
//    }
}
