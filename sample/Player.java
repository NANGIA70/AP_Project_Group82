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
    private int current_weapon_number;
    private boolean move_click_hero_in_use = false;
    private boolean hasweapon = false;
    private boolean revive = false;


    public Player(int jumpHeight, int jumpDistance, Helmet helmet, Coin coin ,ImageView hero) {
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
            coin_count.setText(String.valueOf(this.getCoin().getCoinCount()));
        }
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

    public void setWeaponsList(ArrayList<Weapon> weaponsList)
    {
        helmet.setWeaponsList(weaponsList);
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

    public void move_ClickHero(Label distance, Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, Group group_game, Group group_hero, ImageView weapon) {
        if(!move_click_hero_in_use) {
//            Update distance
            this.increaseScore();
            distance.setText(String.valueOf(this.getScore()));

//            Move hero forward
            move_click_hero_in_use = true;

//            Weapon
            TranslateTransition translate_object = translate_an_object(weapon, 1, 0, 1);
            translate_object.setOnFinished(e -> move_weapon_forward(100, group_hero, weapon,orcArrayList,group_game,coin_count));
            translate_object.play();

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
        Parent root;
        if (this.getCoin().getCoinCount() < 5 || revive) {
            root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        }
        else {
            revive = true;
            root = FXMLLoader.load(getClass().getResource("RevivePage.fxml"));
        }
        content.getChildren().setAll(root);
    }

    public void Kill() {

    }

    //    Getters and Setters
    public void set_weapon_number(int weapon_number)
    {
        this.current_weapon_number = weapon_number;
    }
    public int get_current_weapon_number(){
        return current_weapon_number;
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

//    Weapon functions
    public void move_weapon_forward(int number, Group group_hero, ImageView weapon, ArrayList<Orc> orcArrayList,Group group_game,Label coin_count) {
        for (Orc orc : orcArrayList)
        {
            if(orc.collision_weapon(helmet.getWeaponsList().get(current_weapon_number), group_game,group_hero) && hasweapon)
            {
                orc.die(this);
                coin_count.setText(String.valueOf(this.getCoin().getCoinCount()));
                return;
            }
        }
        if(number < 1) {
            return;
        }
        else {
            TranslateTransition translate_object1 = translate_an_object(weapon, 1,0 , 1);
            if(number == 2) {
                translate_object1.setOnFinished(e -> move_weapon_backward(group_hero, weapon));
            }
            else {
                translate_object1.setOnFinished(e -> move_weapon_forward(number -1, group_hero, weapon, orcArrayList,group_game,coin_count));
            }
            translate_object1.play();
        }
    }
    public void move_weapon_backward(Group group_hero, ImageView weapon) {
        if(group_hero.localToParent(this.getGobj().getBoundsInParent()).intersects(group_hero.localToParent(weapon.getBoundsInParent()))) {
            return;
        }
        else {
            TranslateTransition translate_object1 = translate_an_object(weapon, -1,0 , 1);
            translate_object1.setOnFinished(e -> move_weapon_backward(group_hero, weapon));
            translate_object1.play();
        }
    }
    public boolean gethasweapon() {
        return hasweapon;
    }
    public void sethasweapon()
    {
        this.hasweapon = true;
    }
}
