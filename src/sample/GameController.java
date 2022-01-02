package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Timeline;

public class GameController implements Initializable {

    private ArrayList<Island> islandsArrayList = new ArrayList<Island>();

    private ArrayList<Orc> orcArrayList = new ArrayList<Orc>();

    private ArrayList<Coin> coinArrayList = new ArrayList<Coin>();

    private ArrayList<Powerup> powerupArrayList = new ArrayList<Powerup>();

    private ArrayList<TreasureChest> treasureChestArrayList = new ArrayList<TreasureChest>();
    private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
    @FXML
    private AnchorPane content;

    @FXML
    private ImageView heading;
    @FXML
    private ImageView play;
    @FXML
    private ImageView background;
    @FXML
    private ImageView island1;
    @FXML
    private ImageView island2;
    @FXML
    private ImageView island3;
    @FXML
    private ImageView island4;
    @FXML
    private ImageView island5;
    @FXML
    private ImageView island6;
    @FXML
    private ImageView island7;
    @FXML
    private ImageView island8;
    @FXML
    private ImageView island9;
    @FXML
    private ImageView island10;
    @FXML
    private ImageView island11;
    @FXML
    private ImageView island12;
    @FXML
    private ImageView island13;
    @FXML
    private ImageView island14;
    @FXML
    private ImageView island15;
    @FXML
    private ImageView island16;
    @FXML
    private ImageView island17;
    @FXML
    private ImageView island18;
    @FXML
    private ImageView island19;
    @FXML
    private ImageView island20;
    @FXML
    private ImageView island21;
    @FXML
    private ImageView island22;
    @FXML
    private ImageView island23;
    @FXML
    private ImageView island24;
    @FXML
    private ImageView island25;
    @FXML
    private ImageView island26;
    @FXML
    private ImageView island27;
    @FXML
    private ImageView island28;
    @FXML
    private ImageView island29;
    @FXML
    private ImageView island30;
    @FXML
    private ImageView island31;
    @FXML
    private ImageView island32;
    @FXML
    private ImageView island33;
    @FXML
    private ImageView hero;
    @FXML
    private ImageView chest;
    @FXML
    private ImageView tree;
    @FXML
    private ImageView orc;
    @FXML
    private ImageView load;
    @FXML
    private ImageView pause;
    @FXML
    private ImageView coinImage;
    @FXML
    private ImageView green_orc;

    @FXML
    private Label distance;
    @FXML
    private Label coin_count;
    @FXML
    private Label weapon_level_label2;
    @FXML
    private Label weapon_level_label1;

    @FXML
    private Group group_game;
    @FXML
    private Group group_hero;

    @FXML
    private ImageView FallingTile1;
    @FXML
    private ImageView FallingTile2;
    @FXML
    private ImageView FallingTile3;
    @FXML
    private ImageView FallingTile4;
    @FXML
    private ImageView FallingTile5;
    @FXML
    private ImageView FallingTile6;
    @FXML
    private ImageView FallingTile7;
    @FXML
    private ImageView FallingTile8;
    @FXML
    private ImageView FallingTile9;
    @FXML
    private ImageView FallingTile10;



    @FXML
    private ImageView red_orc1;
    @FXML
    private ImageView red_orc2;
    @FXML
    private ImageView red_orc3;
    @FXML
    private ImageView green_orc3;
    @FXML
    private ImageView green_orc2;
    @FXML
    private ImageView green_orc1;
    @FXML
    private ImageView chest6;
    @FXML
    private ImageView chest5;
    @FXML
    private ImageView chest4;
    @FXML
    private ImageView chest3;
    @FXML
    private ImageView boss_orc;
    @FXML
    private ImageView chest2;
    @FXML
    private ImageView weapon;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView switch_to_weapon2;
    @FXML
    private ImageView coin1;
    @FXML
    private ImageView coin2;
    @FXML
    private ImageView coin3;
    @FXML
    private ImageView coin4;
    @FXML
    private ImageView switch_to_weapon1;
    @FXML
    private ImageView powerup1;
    @FXML
    private ImageView powerup2;
    private FallingFloor ff1;
    private FallingFloor ff2;
    private Helmet helmet;

    private Coin coin;
    private Weapon1 weapon1;
    private Weapon2 weapon2;
    private Player player;
    private BossOrc boss;

    //    Function to create required translate transition object
    public static TranslateTransition translate_an_object(Node obj, double x_cord, double y_cord, int duration_set) {
        Duration animation_time = Duration.millis(duration_set);
        TranslateTransition translate_object = new TranslateTransition();
        translate_object.setDuration(animation_time);
        translate_object.setNode(obj);
        translate_object.setByX(x_cord);
        translate_object.setByY(y_cord);
        return translate_object;
    }
    //    Function to start indefinite island movement

    public void move_ClickHero() {
        player.move_ClickHero(distance, coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero, weapon,boss,content,coinArrayList,powerupArrayList);
    }
    public void switch_to_weapon1()
    {
        if(player.get_has_weapon1())
        {
            File file = new File("src/sample/WeaponAxe.png");
            weapon.setImage(new Image(file.toURI().toString()));
            player.getHelmet().equipWeapon(0);
        }
    }
    public void switch_to_weapon2()
    {
        if(player.get_has_weapon2())
        {
            File file = new File("src/sample/WeaponShuriken.png");
            weapon.setImage(new Image(file.toURI().toString()));
            player.getHelmet().equipWeapon(1);
        }
    }
    public void startPlay() {
//        Remove heading
        TranslateTransition translate_object = translate_an_object(heading, 0, -1000000000, 10);
        translate_object.play();

//        Remove Play
        TranslateTransition translate_object1 = translate_an_object(play, 0, 1000000000, 10);
        translate_object1.play();

//        Start hero jumps
        player.moveHero(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count,  orcArrayList,  treasureChestArrayList,boss,coinArrayList,powerupArrayList);

//        Start orc jumps
        for (Orc orc : orcArrayList) {
            orc.move_orc(content,islandsArrayList,group_game,group_hero,exit,player);
        }

//        Start moving island3 and chest
        for (Island island : islandsArrayList) {
            island.move();
        }
        treasureChestArrayList.get(0).move();
    }

    public void pause_menu(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1200, 645);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ff1 = new FallingFloor(FallingTile1);
        ff2 = new FallingFloor(FallingTile6);
        helmet = new Helmet();

        coin = new Coin(0, coinImage);

        player = new Player(100, 100, helmet, coin, hero,coin_count);

        islandsArrayList.add(new Static_Island(island1));
        islandsArrayList.add(new Static_Island(island2));
        islandsArrayList.add(new Moving_Island(island3));
        islandsArrayList.add(new Static_Island(island4));
        islandsArrayList.add(new Static_Island(island8));
        islandsArrayList.add(new Static_Island(island9));
        islandsArrayList.add(new Static_Island(island10));
        islandsArrayList.add(new Static_Island(island11));
        islandsArrayList.add(new Static_Island(island12));
        islandsArrayList.add(new Moving_Island(island13));
        islandsArrayList.add(new Static_Island(island14));
        islandsArrayList.add(new Static_Island(island15));
        islandsArrayList.add(new Static_Island(island16));
        islandsArrayList.add(new Static_Island(island17));
        islandsArrayList.add(new Static_Island(island18));
        islandsArrayList.add(new Static_Island(island22));
        islandsArrayList.add(new Static_Island(island23));
        islandsArrayList.add(new Static_Island(island24));
        islandsArrayList.add(new Static_Island(island25));
        islandsArrayList.add(new Static_Island(island26));
        islandsArrayList.add(new Static_Island(island27));
        islandsArrayList.add(new Static_Island(island28));
        islandsArrayList.add(new Static_Island(island29));
        islandsArrayList.add(new Static_Island(island30));
        islandsArrayList.add(new Static_Island(island31));
        islandsArrayList.add(new Static_Island(island32));
        islandsArrayList.add(new Static_Island(island33));
//        Falling tiles 1
        ff1.addTiles(FallingTile2);
        ff1.addTiles(FallingTile3);
        ff1.addTiles(FallingTile4);
        ff1.addTiles(FallingTile5);

//        Falling tiles 2
        ff2.addTiles(FallingTile7);
        ff2.addTiles(FallingTile8);
        ff2.addTiles(FallingTile9);
        ff2.addTiles(FallingTile10);

//        Red Orcs
        orcArrayList.add(new RedOrc(red_orc1,100));
        orcArrayList.add(new RedOrc(red_orc2,100));
        orcArrayList.add(new RedOrc(red_orc3,100));

//        Green Orcs
        orcArrayList.add(new GreenOrc(green_orc,100));
        orcArrayList.add(new GreenOrc(green_orc3,100));
        orcArrayList.add(new GreenOrc(green_orc2,100));
//boss
        boss = new BossOrc(boss_orc,4000);

        //weapons
        weapon1 = new Weapon1(0,0,0, weapon);
        weapon2 = new Weapon2(0,0,1, weapon);
        weaponsList.add(weapon1);
        weaponsList.add(weapon2);
        player.setWeaponsList(weaponsList,1);
        //coins
        coinArrayList.add(new Coin(1,coin1));
        coinArrayList.add(new Coin(1,coin2));
        coinArrayList.add(new Coin(1,coin3));
        coinArrayList.add(new Coin(1,coin4));

        //powerups
        powerupArrayList.add(new Powerup(powerup1,0,2,1,10));
        powerupArrayList.add(new Powerup(powerup2,1,1,2,10));


//        Chests
        treasureChestArrayList.add(new CoinChest(chest));
        treasureChestArrayList.add(new WeaponChest(chest2,weapon1,weapon_level_label1,weapon_level_label2));
        treasureChestArrayList.add(new CoinChest(chest3));
        treasureChestArrayList.add(new WeaponChest(chest4,weapon2,weapon_level_label1,weapon_level_label2));
        treasureChestArrayList.add(new CoinChest(chest5));
        treasureChestArrayList.add(new WeaponChest(chest6,weapon1,weapon_level_label1,weapon_level_label2));
        FadeTransition fade_obj = new FadeTransition();
        fade_obj.setDuration(Duration.millis(1));
        fade_obj.setToValue(0);
        fade_obj.setNode(weapon);
        fade_obj.play();
        startPlay();
    }


}
