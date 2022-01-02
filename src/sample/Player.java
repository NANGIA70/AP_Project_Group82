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
    private Label coin_count_2;
    private boolean move_click_hero_in_use = false;
    private boolean hasweapon = false;
    private boolean revive = false;
    private boolean has_reached_boss = false;
    private boolean has_weapon1 = false;
    private boolean has_weapon2 = false;
    private GameController  controller;
    private int xmultiplier = 1;
    private int ymultiplier = 1;
    private int tracker_for_powerup_duration = 0;
    private boolean x_power_up_in_use = false;
    private boolean player_dead = false;
    private TranslateTransition translate_object_player;
    private boolean player_to_be_revived = false;
    private boolean player_can_be_moved = true;
    public boolean get_has_weapon1()
    {
        return has_weapon1;
    }
    public boolean get_has_weapon2()
    {
        return has_weapon2;
    }
    public void set_has_weapon1()
    {
        has_weapon1 = true;
    }
    public void set_has_weapon2()
    {
        has_weapon2 = true;
    }
    public Player(int jumpHeight, int jumpDistance, Helmet helmet, Coin coin ,ImageView hero,Label coin_count_2,GameController contoller) {
        super(hero);
        this.jumpHeight = jumpHeight;
        this.jumpDistance = jumpDistance;
        this.helmet = helmet;
        this.coin = coin;
        this.controller = contoller;
        this.coin_count_2 = coin_count_2;
    }

    @Override
    public boolean collision(GameObject obj, Group group_game, Group group_hero) {
//        implement collision with everyone
        return false;
    }

    public void check_collision(Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, Group group_game, Group group_hero,ArrayList<Coin> coinArrayList,ArrayList<Powerup> powerupArrayList) {
//        Chests
        for (TreasureChest tc : treasureChestArrayList) {
            tc.collision(this, group_game,group_hero);

//            update coin count
            coin_count.setText(String.valueOf(this.getCoin().getCoinCount()));
        }

        for (Orc orc : orcArrayList)
        {
            orc.collision(this, group_game,group_hero);
        }
        for(Coin coin : coinArrayList)
        {
            if(coin.collision(this,group_game,group_hero))
            {
                addCoins(coin.getCoinCount());
                coin_count.setText(String.valueOf(this.getCoin().getCoinCount()));
            }
        }
        for(Powerup powerup : powerupArrayList)
        {
            if(powerup.collision(this,group_game,group_hero))
            {
                xmultiplier = powerup.getIncrease_horizontal_jump();
                if(xmultiplier == 2)
                {
                    x_power_up_in_use = true;
                }
                ymultiplier = powerup.getIncrease_vertical_jump();
                tracker_for_powerup_duration = 1;
            }
        }
    }
    public void addmyCoins(int num_coins)
    {
        this.addCoins(num_coins);
        coin_count_2.setText(String.valueOf(this.getCoin().getCoinCount()));
    }

//    Collision Functions Start
    public boolean check_island_collision(ArrayList<Island> islands, Group group_game, Group group_hero) {
        for (Island island : islands) {
            if (island.collision(this, group_game,group_hero))
            {
                player_to_be_revived = false;
                return true;
            }
        }
        return false;
    }

    public void setWeaponsList(ArrayList<Weapon> weaponsList,int weapon_number)
    {
        helmet.setWeaponsList(weaponsList,weapon_number);
    }
    public boolean check_falling_floor_collision(FallingFloor ff1, Group group_game, Group group_hero) {
        for (ImageView fallTile : ff1.getFalling_tiles()) {
            if(group_hero.localToParent(this.getGobj().getBoundsInParent()).intersects(group_game.localToParent(fallTile.getBoundsInParent())))
            {
                player_to_be_revived = false;
                return true;
            }
        }
        return false;
    }

//    Collision Functions End

//    Movement Functions Start
    @Override
    public void move()
    {
//
    }
    public boolean check_for_boss_islands(ArrayList<Island> islands, Group group_game, Group group_hero)
    {
        for (int i = 20;i< islands.size();i++) {
            if (islands.get(i).collision(this, group_game,group_hero))
            {
                return true;
            }
        }
        return false;
    }
    public void moveHero(AnchorPane content, ArrayList<Island> islandsArrayList, FallingFloor ff1, FallingFloor ff2, Group group_game, Group group_hero, ImageView exit,Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList,BossOrc boss,ArrayList<Coin> coinArrayList,ArrayList<Powerup> powerupArrayList) {
        if(player_to_be_revived == true)
        {
            return;
        }
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(group_hero, 0, -100 * ymultiplier, 1000);
        translate_object_player = translate_object;
        this.setY_Coordinate(this.getY_Coordinate() + 100);
        translate_object.setOnFinished(e -> hero_fall_down(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count,  orcArrayList,  treasureChestArrayList,boss,coinArrayList,powerupArrayList));
        translate_object.play();
    }

    public void move_hero_under_gravity(AnchorPane content, ArrayList<Island> islandsArrayList, FallingFloor ff1, FallingFloor ff2, Group group_game, Group group_hero, ImageView exit,Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList,BossOrc boss,ArrayList<Coin> coinArrayList,ArrayList<Powerup> powerupArrayList) throws IOException {
        if(player_to_be_revived == true)
        {
            return;
        }
        TranslateTransition translate_object1 = translate_an_object(group_hero, 0,1 * ymultiplier , 10);
        this.setY_Coordinate(this.getY_Coordinate() - 1);
        check_collision(coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero,coinArrayList,powerupArrayList);
        if(group_hero.localToParent(this.getGobj().getBoundsInParent()).intersects(group_game.localToParent(exit.getBoundsInParent())))
        {
            if(player_dead == false)
            {
                player_can_be_moved = false;
                player_to_be_revived = true;
                player_dead = true;
                boss.player_dead();
                //translate_object_player.stop();
                this.Revive();
            }
        }
        if(check_for_boss_islands(islandsArrayList,group_game,group_hero) && !has_reached_boss)
        {
            has_reached_boss = true;
            boss.moveBoss(content,islandsArrayList,group_game,group_hero,this,exit);
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
            translate_object1.setOnFinished(e -> moveHero(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count,  orcArrayList,  treasureChestArrayList,boss,coinArrayList,powerupArrayList));
        }
        else {
            translate_object1.setOnFinished(e -> {
                try {
                    this.move_hero_under_gravity(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count,  orcArrayList,  treasureChestArrayList,boss,coinArrayList,powerupArrayList);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }
        translate_object1.play();
    }

    private void hero_fall_down(AnchorPane content, ArrayList<Island> islandsArrayList, FallingFloor ff1, FallingFloor ff2, Group group_game, Group group_hero, ImageView exit,Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList,BossOrc boss,ArrayList<Coin> coinArrayList,ArrayList<Powerup> powerupArrayList) {
        if(player_to_be_revived == true)
        {
            return;
        }
        TranslateTransition translate_object1 = translate_an_object(group_hero, 0,1 * ymultiplier , 10);
        this.setY_Coordinate(this.getY_Coordinate() - 1);
        translate_object1.setOnFinished(e -> {
            try {
                move_hero_under_gravity(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count, orcArrayList, treasureChestArrayList,boss, coinArrayList,powerupArrayList);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        translate_object1.play();
    }
//
    //    Function to move hero on mouse click
    public void move_hero_small(int number, Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, Group group_game, Group group_hero,BossOrc boss,ArrayList<Coin> coinArrayList,ArrayList<Powerup> powerupArrayList) {
        if(player_to_be_revived == true)
        {
            return;
        }
        if(number < 1) {
            move_click_hero_in_use = false;
            return;
        }
        else {
            check_collision(coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero,coinArrayList,powerupArrayList);
            if(check_collision_with_boss(boss,group_game,group_hero) == true)
            {
                boss.move_();
            }
            TranslateTransition translate_object1 = translate_an_object(group_game, -1 * xmultiplier,0 , 5);
            this.setX_Coordinate(this.getX_Coordinate() + 1);
            translate_object1.setOnFinished(e -> move_hero_small(number - 1, coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero,boss,coinArrayList,powerupArrayList));
            translate_object1.play();
        }
    }
    public boolean check_collision_with_boss(BossOrc boss,Group group_game, Group group_hero)
    {
        return boss.check_collision_with_player(this,group_game,group_hero);
    }
    public void move_ClickHero(Label distance, Label coin_count, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, Group group_game, Group group_hero, ImageView weapon, BossOrc boss,AnchorPane content,ArrayList<Coin> coinArrayList,ArrayList<Powerup> powerupArrayList) {
        if(player_to_be_revived == true)
        {
            return;
        }
        if(!move_click_hero_in_use) {
//            Update distance
            if(tracker_for_powerup_duration %10 == 0)
            {
                xmultiplier = 1;
                ymultiplier = 1;
                x_power_up_in_use = false;
            }
            if(x_power_up_in_use == true)
            {
                this.increaseScore();
            }
            tracker_for_powerup_duration +=1;
            this.increaseScore();
            distance.setText(String.valueOf(this.getScore()));

//            Move hero forward
            move_click_hero_in_use = true;

//            Weapon
            TranslateTransition translate_object = translate_an_object(weapon, 1, 0, 1);
            translate_object.setOnFinished(e -> move_weapon_forward(100, group_hero, weapon,orcArrayList,group_game,coin_count,boss,content));
            translate_object.play();

            TranslateTransition translate_object1 = translate_an_object(group_game, -1 * xmultiplier,0 , 5);
            this.setX_Coordinate(this.getX_Coordinate() + 1);
            translate_object1.setOnFinished(e -> move_hero_small(100, coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero,boss,coinArrayList,powerupArrayList));
            translate_object1.play();

            check_collision(coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero,coinArrayList,powerupArrayList);
            if(check_collision_with_boss(boss,group_hero,group_hero) == true ) {
                boss.move_();
            }
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

    public void Revive() throws IOException {
        if (this.getCoin().getCoinCount() < 15 || revive)
        {
            controller.load_home_page();
        }
        else
        {
            revive = true;
            controller.get_revive_page();
            this.getCoin().addCoins(-15);
        }
    }

    //    Getters and Setters
    public int get_current_weapon_number()
    {
        return helmet.get_current_weapon_number();
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
    public void move_weapon_forward(int number, Group group_hero, ImageView weapon, ArrayList<Orc> orcArrayList,Group group_game,Label coin_count,BossOrc boss,AnchorPane content) {
        if(player_to_be_revived == true)
        {
            return;
        }
        int check = 1;
        for (Orc orc : orcArrayList)
        {
            if(orc.collision_weapon(helmet.getWeaponsList().get(get_current_weapon_number()), group_game,group_hero) && hasweapon)
            {
                orc.die(this);
                coin_count.setText(String.valueOf(this.getCoin().getCoinCount()));
                TranslateTransition translate_object2 = translate_an_object(weapon, 0,0 , 0);
                translate_object2.setOnFinished(e -> move_weapon_backward(group_hero, weapon));
                translate_object2.play();
                check = 0;
            }
        }
        if(boss.collision_weapon(helmet.getWeaponsList().get(get_current_weapon_number()), group_game,group_hero) && hasweapon)
        {
            boss.setHealth(boss.getHealth() - helmet.getWeaponsList().get(get_current_weapon_number()).getDamage());
            if(boss.getHealth() < 0)
            {
                boss.death(content,player_dead);
            }
            TranslateTransition translate_object4 = translate_an_object(weapon, 0,0 , 0);
            translate_object4.setOnFinished(e -> move_weapon_backward(group_hero, weapon));
            translate_object4.play();
            check = 0;
        }
        if(number < 1 || check == 0) {
            return;
        }
        else {
            TranslateTransition translate_object1 = translate_an_object(weapon, 1,0 , 1);
            if(number == 2) {
                translate_object1.setOnFinished(e -> move_weapon_backward(group_hero, weapon));
            }
            else {
                translate_object1.setOnFinished(e -> move_weapon_forward(number -1, group_hero, weapon, orcArrayList,group_game,coin_count,boss,content));
            }
            translate_object1.play();
        }
    }
    public void move_weapon_backward(Group group_hero, ImageView weapon) {
        if(player_to_be_revived == true)
        {
            return;
        }
        if(group_hero.localToParent(this.getGobj().getBoundsInParent()).intersects(group_hero.localToParent(weapon.getBoundsInParent())))
        {
            return;
        }
        else {
            TranslateTransition translate_object1 = translate_an_object(weapon, -1,0 , 1);
            translate_object1.setOnFinished(e -> move_weapon_backward(group_hero, weapon));
            translate_object1.play();
        }
    }
    public boolean get_move_click_hero_in_use()
    {
        return move_click_hero_in_use;
    }
    public boolean gethasweapon() {
        return hasweapon;
    }
    public void sethasweapon()
    {
        this.hasweapon = true;
    }
    public void set_player_dead()
    {
        player_dead = false;
    }
    public void set_player_to_be_revived()
    {
        player_to_be_revived = false;
    }
    public void set_player_can_be_moved()
    {
        player_can_be_moved = true;
    }

}
