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
import java.util.TreeMap;

import javafx.animation.Timeline;

public class GameController implements Initializable {

    private ArrayList<Island> islandsArrayList = new ArrayList<Island>();

    private ArrayList<Orc> orcArrayList = new ArrayList<Orc>();

    private ArrayList<Coin> coinArrayList = new ArrayList<Coin>();

    private ArrayList<Powerup> powerupArrayList = new ArrayList<Powerup>();
    private double group_X;
    private double group_Y;
    private ArrayList<TreasureChest> treasureChestArrayList = new ArrayList<TreasureChest>();
    private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
    private Stage stage;
    private Scene scene;

    public void setStart()
    {
        GameController.start = true;
    }
    public void setStart_false()
    {
        GameController.start = false;
    }
    private static boolean start = true;
    private static Stage primaryStage;
    @FXML
    private ImageView background;
    @FXML
    private Group group_menu;
    @FXML
    private ImageView reviveBackground;
    @FXML
    private ImageView coinReviveImage;
    @FXML
    private ImageView reviveButton1;
    @FXML
    private ImageView reviveButton2;

    @FXML
    private javafx.scene.control.Label revive;
    @FXML
    private javafx.scene.control.Label noThanks;
    @FXML
    private AnchorPane content;

    @FXML
    private ImageView heading;
    @FXML
    private ImageView play;
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
    private Group pause_menu2;

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
    private int moveforwardcount = 0;
    private FallingFloor ff1;
    private FallingFloor ff2;
    private Helmet helmet;
    private Game game_obj;
    private Coin coin;
    private Weapon1 weapon1;
    private Weapon2 weapon2;
    private Player player;
    private BossOrc boss;
    private boolean game_paused = false;
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

    public void pause_menu(javafx.scene.input.MouseEvent event) throws IOException
    {
        group_X = player.getGroup_X();
        group_Y = player.getGroup_Y();
        game_obj = new Game(coinArrayList,powerupArrayList,group_X, group_Y, ff1, ff2, helmet, islandsArrayList, orcArrayList, treasureChestArrayList, weaponsList, content, coin, weapon1, weapon2, player, boss);

        Game.serialize(game_obj);

        Parent root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1200, 645);
        stage.setScene(scene);
        stage.show();
    }
    public void reviveAction()
    {
        TranslateTransition translate_object = translate_an_object(group_menu, 0, 600, 10);
        translate_object.play();
        TranslateTransition translate_object2 = translate_an_object(group_hero, 0, -350, 10);
        translate_object2.setOnFinished(e -> check_for_island());
        translate_object2.play();
        game_paused = false;
    }
    public void check_for_island()
    {
        if(check_island_collision())
        {
            for(int i = 0;i<moveforwardcount;i++)
            {
                player.increaseScore();
            }
            distance.setText(String.valueOf(player.getScore()));
            return;
        }
        TranslateTransition translate_object2 = translate_an_object(group_game, -100, 0, 10);
        moveforwardcount+=1;
        translate_object2.setOnFinished(e -> check_for_island());
        translate_object2.play();
    }
    public boolean check_island_collision()
    {
        for (Island island : islandsArrayList) {
            if (island.collision(player,group_game,group_hero))
            {
                player.set_player_dead();
                player.set_player_to_be_revived();
                player.moveHero(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count,  orcArrayList,  treasureChestArrayList,boss,coinArrayList,powerupArrayList);
                return true;
            }
        }
        for (ImageView fallTile : ff1.getFalling_tiles()) {
            if(group_hero.localToParent(player.getGobj().getBoundsInParent()).intersects(group_game.localToParent(fallTile.getBoundsInParent())))
            {
                player.set_player_dead();
                player.set_player_to_be_revived();
                player.moveHero(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count,  orcArrayList,  treasureChestArrayList,boss,coinArrayList,powerupArrayList);
                return true;
            }
        }
        for (ImageView fallTile : ff2.getFalling_tiles()) {
            if(group_hero.localToParent(player.getGobj().getBoundsInParent()).intersects(group_game.localToParent(fallTile.getBoundsInParent())))
            {
                player.set_player_dead();
                player.set_player_to_be_revived();
                player.moveHero(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count,  orcArrayList,  treasureChestArrayList,boss,coinArrayList,powerupArrayList);
                return true;
            }
        }
        return false;
    }
    public void get_revive_page()
    {
        TranslateTransition translate_object = translate_an_object(group_menu, 0, -600, 10);
        translate_object.play();
        game_paused = true;
    }
    public void load_home_page() throws IOException {
        start = true;
        Parent root = FXMLLoader.load(getClass().getResource("OverPage.fxml"));
        content.getChildren().setAll(root);
    }
    public void noAction(javafx.scene.input.MouseEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 645);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(start);
        if(start)
        {
            ff1 = new FallingFloor(FallingTile1);
            ff2 = new FallingFloor(FallingTile6);
            helmet = new Helmet();

            coin = new Coin(0, coinImage);

            player = new Player(100, 100, helmet, coin, hero,coin_count,this);

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

            boss = new BossOrc(boss_orc,4000,this);

            weapon1 = new Weapon1(0,0,0, weapon);
            weapon2 = new Weapon2(0,0,1, weapon);

            weaponsList.add(weapon1);
            weaponsList.add(weapon2);

            player.setWeaponsList(weaponsList,1);

            coinArrayList.add(new Coin(1,coin1));
            coinArrayList.add(new Coin(1,coin2));
            coinArrayList.add(new Coin(1,coin3));
            coinArrayList.add(new Coin(1,coin4));

            //powerups
            powerupArrayList.add(new Powerup(powerup1,0,2,1,10));
            powerupArrayList.add(new Powerup(powerup2,1,1,2,10));


//        Chests
            treasureChestArrayList.add(new CoinChest(chest));
            treasureChestArrayList.add(new WeaponChest(chest2,weapon1,weapon_level_label1,weapon_level_label2,0));
            treasureChestArrayList.add(new CoinChest(chest3));
            treasureChestArrayList.add(new WeaponChest(chest4,weapon2,weapon_level_label1,weapon_level_label2,1));
            treasureChestArrayList.add(new CoinChest(chest5));
            treasureChestArrayList.add(new WeaponChest(chest6,weapon1,weapon_level_label1,weapon_level_label2,1));
//            game_obj = new Game(ff1, ff2, helmet, islandsArrayList, orcArrayList, treasureChestArrayList, weaponsList, content, coin, weapon1, weapon2, player, boss);
            //System.out.println(start);
            start = false;
            FadeTransition fade_obj = new FadeTransition();
            fade_obj.setDuration(Duration.millis(1));
            fade_obj.setToValue(0);
            fade_obj.setNode(weapon);
            fade_obj.play();
        }
        else {
            try {
                game_obj = Game.deserialize();
//                System.out.println(game_obj);
                helmet = game_obj.getHelmet();
                player = game_obj.getPlayer();
                player.setX_Coordinate(game_obj.getPlayer().getX_Coordinate());
                player.setY_Coordinate(game_obj.getPlayer().getY_Coordinate());
                player.setGobj(hero);
                player.setCoin_count_2(coin_count);
                player.setController(this);

                islandsArrayList.add(game_obj.getIslandsArrayList().get(0));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(1));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(2));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(3));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(4));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(5));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(6));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(7));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(8));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(9));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(10));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(11));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(12));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(13));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(14));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(15));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(16));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(17));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(18));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(19));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(20));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(21));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(22));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(23));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(24));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(25));
                islandsArrayList.add(game_obj.getIslandsArrayList().get(26));

//                islandsArrayList = game_obj.getIslandsArrayList();
////                System.out.println("Hello");
                islandsArrayList.get(0).setGobj(island1);
                System.out.println(islandsArrayList.get(0).getGobj());
                islandsArrayList.get(1).setGobj(island2);
                islandsArrayList.get(2).setGobj(island3);
                islandsArrayList.get(3).setGobj(island4);
                islandsArrayList.get(4).setGobj(island8);
                islandsArrayList.get(5).setGobj(island9);
                islandsArrayList.get(6).setGobj(island10);
                islandsArrayList.get(7).setGobj(island11);
                islandsArrayList.get(8).setGobj(island12);
                islandsArrayList.get(9).setGobj(island13);
                islandsArrayList.get(10).setGobj(island14);
                islandsArrayList.get(11).setGobj(island15);
                islandsArrayList.get(12).setGobj(island16);
                islandsArrayList.get(13).setGobj(island17);
                islandsArrayList.get(14).setGobj(island18);
                islandsArrayList.get(15).setGobj(island22);
                islandsArrayList.get(16).setGobj(island23);
                islandsArrayList.get(17).setGobj(island24);
                islandsArrayList.get(18).setGobj(island25);
                islandsArrayList.get(19).setGobj(island26);
                islandsArrayList.get(20).setGobj(island27);
                islandsArrayList.get(21).setGobj(island28);
                islandsArrayList.get(22).setGobj(island29);
                islandsArrayList.get(23).setGobj(island30);
                islandsArrayList.get(24).setGobj(island31);
                islandsArrayList.get(25).setGobj(island32);
                islandsArrayList.get(26).setGobj(island33);

                orcArrayList = game_obj.getOrcArrayList();
                orcArrayList.get(0).setGobj(red_orc1);
//                orcArrayList.get(0).setHealth(game_obj.getOrcArrayList().get(0).getHealth());
                orcArrayList.get(1).setGobj(red_orc2);
//                orcArrayList.get(1).setHealth(game_obj.getOrcArrayList().get(1).getHealth());
                orcArrayList.get(2).setGobj(red_orc3);
//                orcArrayList.get(2).setHealth(game_obj.getOrcArrayList().get(2).getHealth());

                orcArrayList.get(3).setGobj(green_orc);
//                orcArrayList.get(3).setHealth(game_obj.getOrcArrayList().get(3).getHealth());
                orcArrayList.get(4).setGobj(green_orc3);
//                orcArrayList.get(4).setHealth(game_obj.getOrcArrayList().get(4).getHealth());
                orcArrayList.get(5).setGobj(green_orc2);
//                orcArrayList.get(5).setHealth(game_obj.getOrcArrayList().get(5).getHealth());

                for (Orc value : orcArrayList) {
                    if (value.isOrc_dead()) {
                        TranslateTransition translate_object1 = translate_an_object(value.getGobj(), 0, 1000, 5);
                        translate_object1.play();
                    }
                }
                treasureChestArrayList = game_obj.getTreasureChestArrayList();
                treasureChestArrayList.get(0).setGobj(chest);
                treasureChestArrayList.get(1).setGobj(chest2);
                WeaponChest wc1 = (WeaponChest) treasureChestArrayList.get(1);
                wc1.setWeapon1_label(weapon_level_label1);
                wc1.setWeapon2_label(weapon_level_label2);
                if(wc1.getFirst_time() == 1)
                {
                    FadeTransition fade_obj = new FadeTransition();
                    fade_obj.setDuration(Duration.millis(1));
                    fade_obj.setToValue(1);
                    fade_obj.setNode(weapon);
                    fade_obj.play();
                }
                treasureChestArrayList.get(2).setGobj(chest3);
                treasureChestArrayList.get(3).setGobj(chest4);
                WeaponChest wc2 = (WeaponChest) treasureChestArrayList.get(3);
                wc2.setWeapon1_label(weapon_level_label1);
                wc2.setWeapon2_label(weapon_level_label2);
                treasureChestArrayList.get(4).setGobj(chest5);
                treasureChestArrayList.get(5).setGobj(chest6);
                WeaponChest wc3 = (WeaponChest) treasureChestArrayList.get(5);
                wc3.setWeapon1_label(weapon_level_label1);
                wc3.setWeapon2_label(weapon_level_label2);
                weapon_level_label1.setText(String.valueOf(player.getHelmet().get_current_weapon_level1()));
                weapon_level_label2.setText(String.valueOf(player.getHelmet().get_current_weapon_level2()));
                for (TreasureChest treasureChest : treasureChestArrayList)
                {
                    if(treasureChest.isChestOpen())
                    {
                        File file = new File("src/sample/ChestOpen.png");
                        treasureChest.getGobj().setImage(new Image(file.toURI().toString()));
                    }
                }
                if(!treasureChestArrayList.get(1).isChestOpen())
                {
                    FadeTransition fade_obj = new FadeTransition();
                    fade_obj.setDuration(Duration.millis(1));
                    fade_obj.setToValue(0);
                    fade_obj.setNode(weapon);
                    fade_obj.play();
                }
                coinArrayList = game_obj.getCoinArrayList();
                coinArrayList.get(0).setGobj(coin1);
                coinArrayList.get(1).setGobj(coin2);
                coinArrayList.get(2).setGobj(coin3);
                coinArrayList.get(3).setGobj(coin4);

                for (Coin coin1 : coinArrayList)
                {
                    if(coin1.isCollision_done())
                    {
                        FadeTransition fade_obj = new FadeTransition();
                        fade_obj.setDuration(Duration.millis(1));
                        fade_obj.setToValue(0);
                        fade_obj.setNode(coin1.getGobj());
                        fade_obj.play();;
                    }
                }
                //powerups
                powerupArrayList = game_obj.getPowerupArrayList();
                powerupArrayList.get(0).setGobj(powerup1);
                powerupArrayList.get(1).setGobj(powerup2);
                for (Powerup powerup : powerupArrayList)
                {
                    if(powerup.isCollision_done())
                    {
                        FadeTransition fade_obj = new FadeTransition();
                        fade_obj.setDuration(Duration.millis(1));
                        fade_obj.setToValue(0);
                        fade_obj.setNode(powerup.getGobj());
                        fade_obj.play();;
                    }
                }
                boss = game_obj.getBoss();
                boss.setGobj(boss_orc);
                boss.setHealth(game_obj.getBoss().getHealth());
                boss.setController(this);

                ff1 = game_obj.getFf1();
                ff1.setFalling_tiles(new ArrayList<ImageView>(5));
                ff1.getFalling_tiles().add(FallingTile1);
                ff1.getFalling_tiles().add(FallingTile2);
                ff1.getFalling_tiles().add(FallingTile3);
                ff1.getFalling_tiles().add(FallingTile4);
                ff1.getFalling_tiles().add(FallingTile5);
                ff1.set_fall_floor_boolean();

                ff2 = game_obj.getFf2();
                ff2.setFalling_tiles(new ArrayList<ImageView>(5));
                ff2.getFalling_tiles().add(FallingTile6);
                ff2.getFalling_tiles().add(FallingTile7);
                ff2.getFalling_tiles().add(FallingTile8);
                ff2.getFalling_tiles().add(FallingTile9);
                ff2.getFalling_tiles().add(FallingTile10);
                ff2.set_fall_floor_boolean();

                if(ff1.getNumber_of_tiles_fallen() == 1)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile1, 0,500 , 10);
                    translate_object1.play();
                }
                if(ff1.getNumber_of_tiles_fallen() == 2)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile1, 0,500 , 10);
                    translate_object1.play();
                    TranslateTransition translate_object2 = translate_an_object(FallingTile2, 0,500 , 10);
                    translate_object2.play();
                }
                if(ff1.getNumber_of_tiles_fallen() == 3)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile1, 0,500 , 10);
                    translate_object1.play();
                    TranslateTransition translate_object2 = translate_an_object(FallingTile2, 0,500 , 10);
                    translate_object2.play();
                    TranslateTransition translate_object3 = translate_an_object(FallingTile3, 0,500 , 10);
                    translate_object3.play();
                }
                if(ff1.getNumber_of_tiles_fallen() == 4)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile1, 0,500 , 10);
                    translate_object1.play();
                    TranslateTransition translate_object2 = translate_an_object(FallingTile2, 0,500 , 10);
                    translate_object2.play();
                    TranslateTransition translate_object3 = translate_an_object(FallingTile3, 0,500 , 10);
                    translate_object3.play();
                    TranslateTransition translate_object4 = translate_an_object(FallingTile4, 0,500 , 10);
                    translate_object4.play();
                }
                if(ff1.getNumber_of_tiles_fallen() == 5)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile1, 0,500 , 10);
                    translate_object1.play();
                    TranslateTransition translate_object2 = translate_an_object(FallingTile2, 0,500 , 10);
                    translate_object2.play();
                    TranslateTransition translate_object3 = translate_an_object(FallingTile3, 0,500 , 10);
                    translate_object3.play();
                    TranslateTransition translate_object4 = translate_an_object(FallingTile4, 0,500 , 10);
                    translate_object4.play();
                    TranslateTransition translate_object5 = translate_an_object(FallingTile5, 0,500 , 10);
                    translate_object5.play();
                }
                if(ff2.getNumber_of_tiles_fallen() == 1)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile6, 0,500 , 10);
                    translate_object1.play();
                }
                if(ff2.getNumber_of_tiles_fallen() == 2)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile6, 0,500 , 10);
                    translate_object1.play();
                    TranslateTransition translate_object2 = translate_an_object(FallingTile7, 0,500 , 10);
                    translate_object2.play();
                }
                if(ff2.getNumber_of_tiles_fallen() == 3)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile6, 0,500 , 10);
                    translate_object1.play();
                    TranslateTransition translate_object2 = translate_an_object(FallingTile7, 0,500 , 10);
                    translate_object2.play();
                    TranslateTransition translate_object3 = translate_an_object(FallingTile8, 0,500 , 10);
                    translate_object3.play();
                }
                if(ff2.getNumber_of_tiles_fallen() == 4)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile6, 0,500 , 10);
                    translate_object1.play();
                    TranslateTransition translate_object2 = translate_an_object(FallingTile7, 0,500 , 10);
                    translate_object2.play();
                    TranslateTransition translate_object3 = translate_an_object(FallingTile8, 0,500 , 10);
                    translate_object3.play();
                    TranslateTransition translate_object4 = translate_an_object(FallingTile9, 0,500 , 10);
                    translate_object4.play();
                }
                if(ff2.getNumber_of_tiles_fallen() == 5)
                {
                    TranslateTransition translate_object1 = translate_an_object(FallingTile6, 0,500 , 10);
                    translate_object1.play();
                    TranslateTransition translate_object2 = translate_an_object(FallingTile7, 0,500 , 10);
                    translate_object2.play();
                    TranslateTransition translate_object3 = translate_an_object(FallingTile8, 0,500 , 10);
                    translate_object3.play();
                    TranslateTransition translate_object4 = translate_an_object(FallingTile9, 0,500 , 10);
                    translate_object4.play();
                    TranslateTransition translate_object5 = translate_an_object(FallingTile10, 0,500 , 10);
                    translate_object5.play();
                }

                weapon1 = game_obj.getWeapon1();
                weapon1.setGobj(weapon);
                weapon1.setDamage(game_obj.getWeapon1().getDamage());
                weapon1.setLevel(game_obj.getWeapon1().getLevel());
                weapon1.setWeaponNumber(0);

                weapon2 = game_obj.getWeapon2();
                weapon2.setGobj(weapon);
                weapon2.setDamage(game_obj.getWeapon2().getDamage());
                weapon2.setLevel(game_obj.getWeapon2().getLevel());
                weapon2.setWeaponNumber(1);

                weaponsList = game_obj.getWeaponsList();
                weaponsList.add(weapon1);
                weaponsList.add(weapon2);

                coin = game_obj.getCoin();
                coin.setGobj(coinImage);
                coin.setCoinCount(game_obj.getCoin().getCoinCount());
                coin_count.setText(String.valueOf(coin.getCoinCount()));

//                player.setCoin(game_obj.getPlayer().getCoin());
//                player.setJumpDistance(game_obj.getPlayer().getJumpDistance());
//                player.setJumpHeight(game_obj.getPlayer().getJumpHeight());
//                player.setHelmet(game_obj.getPlayer().getHelmet());
//                player.setWeaponsList(weaponsList,1);

                System.out.println(group_X);
                group_X = game_obj.getGroup_X();
                TranslateTransition translate_object1 = translate_an_object(group_game, group_X,0 , 5);
                translate_object1.play();
                distance.setText(String.valueOf(player.getScore()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        startPlay();
    }
}
