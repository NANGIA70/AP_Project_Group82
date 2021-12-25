package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class Player extends GameObject{
    private int jumpHeight;
    private int jumpDistance;
    private Helmet helmet;
    private Coin coin;
    private int score = 0;
    private boolean move_click_hero_in_use = false;


    public Player(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed,*/ int jumpHeight, int jumpDistance, Helmet helmet, Coin coin ,ImageView hero) {
//        super(x_Coordinate, y_Coordinate, x_Speed, y_Speed);
        super(hero);
        this.jumpHeight = jumpHeight;
        this.jumpDistance = jumpDistance;
        this.helmet = helmet;
        this.coin = coin;
    }

    @Override
    public boolean collision(GameObject obj, Group group_game, Group group_hero) {
//        implement collision with everyone
        return false;
    }

    public void check_collision(Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, Group group_game, Group group_hero) {
//        Chests
        for (TreasureChest tc : treasureChestArrayList) {
            tc.collision(this, group_game,group_hero);

//            update coin count
            coin_count.setText(String.valueOf(this.getCoin().getCoinCount()));
        }

        for (Orc orc : orcArrayList) {
            orc.collision(this, group_game,group_hero);
        }
//        if(this.getGobj().getBoundsInParent().intersects(group_game.localToParent(green_orc.getBoundsInParent()))) {
//            TranslateTransition translate_object = translate_an_object(green_orc, 250, 0, 500);
//            translate_object.play();
//            translate_object.setOnFinished(e -> move_orc_down());
//        }
    }

//    Collision Functions Start
    public boolean check_island_collision(ArrayList<Island> islands, Group group_game, Group group_hero) {
        for (Island island : islands) {
            if (island.collision(this, group_game,group_hero)) {
                return true;
            }
        }
        return false;
    }

    public boolean check_falling_floor_collision(FallingFloor ff1, Group group_game, Group group_hero) {
        for (ImageView fallTile : ff1.getFalling_tiles()) {
            if(group_hero.localToParent(this.getGobj().getBoundsInParent()).intersects(group_game.localToParent(fallTile.getBoundsInParent()))) {
                return true;
            }
        }
        return false;
    }

//    Collision Functions End

//    Movement Functions Start
    @Override
    public void move() {
//
    }

    public void moveHero(AnchorPane content, ArrayList<Island> islandsArrayList, FallingFloor ff1, FallingFloor ff2, Group group_game, Group group_hero, ImageView exit) {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(group_hero, 0, -100, 1000);
        translate_object.setOnFinished(e -> hero_fall_down(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit));
        translate_object.play();
    }

    public void move_hero_under_gravity(AnchorPane content, ArrayList<Island> islandsArrayList, FallingFloor ff1, FallingFloor ff2, Group group_game, Group group_hero, ImageView exit) throws IOException {
        TranslateTransition translate_object1 = translate_an_object(group_hero, 0,1 , 10);

        if(group_hero.localToParent(this.getGobj().getBoundsInParent()).intersects(group_game.localToParent(exit.getBoundsInParent()))) {
            this.Revive(content);
        }

        if(check_island_collision(islandsArrayList, group_game, group_hero) || check_falling_floor_collision(ff1, group_game, group_hero) || check_falling_floor_collision(ff2, group_game, group_hero)) {
            if(!ff1.get_fall_floor_boolean() && check_falling_floor_collision(ff1, group_game, group_hero)) {
                ff1.fallStart(0);
                ff1.set_fall_floor_boolean();
            }

            if(!ff2.get_fall_floor_boolean() && check_falling_floor_collision(ff2, group_game, group_hero)) {
                ff2.fallStart(0);
                ff2.set_fall_floor_boolean();
            }
            translate_object1.setOnFinished(e -> moveHero(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit));
        }
        else {
            translate_object1.setOnFinished(e -> {
                try {
                    this.move_hero_under_gravity(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }
        translate_object1.play();
    }

    private void hero_fall_down(AnchorPane content, ArrayList<Island> islandsArrayList, FallingFloor ff1, FallingFloor ff2, Group group_game, Group group_hero, ImageView exit) {
        //TranslateTransition translate_object1 = translate_an_object(hero, 0,100 , 1000);
        TranslateTransition translate_object1 = translate_an_object(Gobj, 0,1 , 10);
        translate_object1.setOnFinished(e -> {
            try {
                move_hero_under_gravity(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        translate_object1.play();
    }
//
    //    Function to move hero on mouse click
    public void move_hero_small(int number, Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, Group group_game, Group group_hero) {
        if(number < 1) {
            move_click_hero_in_use = false;
            return;
        }
        else {
            check_collision(coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero);
            TranslateTransition translate_object1 = translate_an_object(group_game, -1,0 , 5);
            translate_object1.setOnFinished(e -> move_hero_small(number - 1, coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero));
            translate_object1.play();
        }
    }

    public void move_ClickHero(Label distance, Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, Group group_game, Group group_hero) {
        if(!move_click_hero_in_use) {
//            Update distance
            this.increaseScore();
            distance.setText(String.valueOf(this.getScore()));

//            Move hero forward
            move_click_hero_in_use = true;
            TranslateTransition translate_object1 = translate_an_object(group_game, -1,0 , 5);
            translate_object1.setOnFinished(e -> move_hero_small(100, coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero));
            translate_object1.play();
            check_collision(coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero);
        }
    }
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

    public void Revive(AnchorPane content) throws IOException {
        if (this.getCoin().getCoinCount() < 5) {
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            content.getChildren().setAll(root);
        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("RevivePage.fxml"));
            content.getChildren().setAll(root);
        }
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
}
