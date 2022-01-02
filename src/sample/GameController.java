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
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Timeline;

public class GameController implements Initializable, Serializable {

    private ArrayList<Island> islandsArrayList = new ArrayList<Island>();

    private ArrayList<Orc> orcArrayList = new ArrayList<Orc>();

    private ArrayList<TreasureChest> treasureChestArrayList = new ArrayList<TreasureChest>();
    private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
    private boolean start = true;
    @FXML
    private transient AnchorPane content;

    @FXML
    private transient ImageView heading;
    @FXML
    private transient ImageView play;
    @FXML
    private transient ImageView background;
    @FXML
    private transient ImageView island1;
    @FXML
    private transient ImageView island2;
    @FXML
    private transient ImageView island3;
    @FXML
    private transient ImageView island4;
    @FXML
    private transient ImageView island5;
    @FXML
    private transient ImageView island6;
    @FXML
    private transient ImageView island7;
    @FXML
    private transient ImageView island8;
    @FXML
    private transient ImageView island9;
    @FXML
    private transient ImageView island10;
    @FXML
    private transient ImageView island11;
    @FXML
    private transient ImageView island12;
    @FXML
    private transient ImageView island13;
    @FXML
    private transient ImageView island14;
    @FXML
    private transient ImageView island15;
    @FXML
    private transient ImageView island16;
    @FXML
    private transient ImageView island17;
    @FXML
    private transient ImageView island18;
    @FXML
    private transient ImageView island19;
    @FXML
    private transient ImageView island20;
    @FXML
    private transient ImageView island21;
    @FXML
    private transient ImageView island22;
    @FXML
    private transient ImageView island23;
    @FXML
    private transient ImageView island24;
    @FXML
    private transient ImageView island25;
    @FXML
    private transient ImageView island26;
    @FXML
    private transient ImageView island27;
    @FXML
    private transient ImageView island28;
    @FXML
    private transient ImageView island29;
    @FXML
    private transient ImageView island30;
    @FXML
    private transient ImageView island31;
    @FXML
    private transient ImageView island32;
    @FXML
    private transient ImageView island33;
    @FXML
    private transient ImageView hero;
    @FXML
    private transient ImageView chest;
    @FXML
    private transient ImageView tree;
    @FXML
    private transient ImageView orc;
    @FXML
    private transient ImageView load;
    @FXML
    private transient ImageView pause;
    @FXML
    private transient ImageView coinImage;
    @FXML
    private transient ImageView green_orc;

    @FXML
    private transient Label distance;
    @FXML
    private transient Label coin_count;


    @FXML
    private transient Group group_game;
    @FXML
    private transient Group group_hero;

    @FXML
    private transient ImageView FallingTile1;
    @FXML
    private transient ImageView FallingTile2;
    @FXML
    private transient ImageView FallingTile3;
    @FXML
    private transient ImageView FallingTile4;
    @FXML
    private transient ImageView FallingTile5;
    @FXML
    private transient ImageView FallingTile6;
    @FXML
    private transient ImageView FallingTile7;
    @FXML
    private transient ImageView FallingTile8;
    @FXML
    private transient ImageView FallingTile9;
    @FXML
    private transient ImageView FallingTile10;



    @FXML
    private transient ImageView red_orc1;
    @FXML
    private transient ImageView red_orc2;
    @FXML
    private transient ImageView red_orc3;
    @FXML
    private transient ImageView green_orc3;
    @FXML
    private transient ImageView green_orc2;
    @FXML
    private transient ImageView green_orc1;
    @FXML
    private transient ImageView chest6;
    @FXML
    private transient ImageView chest5;
    @FXML
    private transient ImageView chest4;
    @FXML
    private transient ImageView chest3;
    @FXML
    private transient ImageView boss_orc;
    @FXML
    private transient ImageView chest2;
    @FXML
    private transient ImageView weapon;
    @FXML
    private transient ImageView exit;
    @FXML
    private transient ImageView switch_to_weapon2;
    @FXML
    private transient ImageView switch_to_weapon1;

    private FallingFloor ff1;
    private FallingFloor ff2;
    private Helmet helmet;

    private Coin coin;
    private Weapon1 weapon1;
    private Weapon2 weapon2;
    private Player player;
    private BossOrc boss;

    private Game game_obj = new Game(ff1, ff2, helmet, islandsArrayList, orcArrayList, treasureChestArrayList, weaponsList, content, coin, weapon1, weapon2, player, boss);

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
        player.move_ClickHero(distance, coin_count, orcArrayList, treasureChestArrayList, group_game, group_hero, weapon,boss,content);
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
    public void startPlay()  {
//        Remove heading
        TranslateTransition translate_object = translate_an_object(heading, 0, -1000000000, 10);
        translate_object.play();

//        Remove Play
        TranslateTransition translate_object1 = translate_an_object(play, 0, 1000000000, 10);
        translate_object1.play();

//        Start hero jumps
        player.moveHero(content, islandsArrayList, ff1, ff2, group_game, group_hero, exit, coin_count,  orcArrayList,  treasureChestArrayList,boss);

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
        game_obj.serialize();
        Parent root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1200, 645);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(start) {
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

            boss = new BossOrc(boss_orc,4000);

            weapon1 = new Weapon1(0,0,0, weapon);
            weapon2 = new Weapon2(0,0,1, weapon);

            weaponsList.add(weapon1);
            weaponsList.add(weapon2);

            player.setWeaponsList(weaponsList,1);

            coin = new Coin(0, coinImage);

            player = new Player(100, 100, helmet, coin, hero,coin_count);

//        Chests
            treasureChestArrayList.add(new CoinChest(chest));
            treasureChestArrayList.add(new WeaponChest(chest2,weapon1));
            treasureChestArrayList.add(new CoinChest(chest3));
            treasureChestArrayList.add(new WeaponChest(chest4,weapon2));
            treasureChestArrayList.add(new CoinChest(chest5));
            treasureChestArrayList.add(new WeaponChest(chest6,weapon1));
            start = false;
        }
        else {
            try {
                game_obj = game_obj.deserialize();

                helmet = Game.getHelmet();

                islandsArrayList.get(0).setGobj(island1);
                islandsArrayList.get(1).setGobj(island2);
                islandsArrayList.get(3).setGobj(island3);
                islandsArrayList.get(4).setGobj(island4);
                islandsArrayList.get(5).setGobj(island8);
                islandsArrayList.get(6).setGobj(island9);
                islandsArrayList.get(7).setGobj(island10);
                islandsArrayList.get(8).setGobj(island11);
                islandsArrayList.get(9).setGobj(island12);
                islandsArrayList.get(10).setGobj(island13);
                islandsArrayList.get(11).setGobj(island14);
                islandsArrayList.get(12).setGobj(island15);
                islandsArrayList.get(13).setGobj(island16);
                islandsArrayList.get(14).setGobj(island17);
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

                orcArrayList.get(0).setGobj(red_orc1);
                orcArrayList.get(0).setHealth(Game.getOrcArrayList().get(0).getHealth());
                orcArrayList.get(1).setGobj(red_orc2);
                orcArrayList.get(1).setHealth(Game.getOrcArrayList().get(1).getHealth());
                orcArrayList.get(2).setGobj(red_orc3);
                orcArrayList.get(2).setHealth(Game.getOrcArrayList().get(2).getHealth());

                orcArrayList.get(3).setGobj(green_orc);
                orcArrayList.get(3).setHealth(Game.getOrcArrayList().get(3).getHealth());
                orcArrayList.get(4).setGobj(green_orc3);
                orcArrayList.get(4).setHealth(Game.getOrcArrayList().get(4).getHealth());
                orcArrayList.get(5).setGobj(green_orc2);
                orcArrayList.get(5).setHealth(Game.getOrcArrayList().get(5).getHealth());

                boss.setGobj(boss_orc);
                boss.setHealth(Game.getBoss().getHealth());


                ff1.getFalling_tiles().set(0, FallingTile1);
                ff1.getFalling_tiles().set(1, FallingTile2);
                ff1.getFalling_tiles().set(2, FallingTile3);
                ff1.getFalling_tiles().set(3, FallingTile4);
                ff1.getFalling_tiles().set(4, FallingTile5);

                ff1.getFalling_tiles().set(5, FallingTile6);
                ff1.getFalling_tiles().set(6, FallingTile7);
                ff1.getFalling_tiles().set(7, FallingTile8);
                ff1.getFalling_tiles().set(8, FallingTile9);
                ff1.getFalling_tiles().set(9, FallingTile10);


                weapon1.setGobj(weapon);
                weapon1.setDamage(Game.getWeapon1().getDamage());
                weapon1.setLevel(Game.getWeapon1().getLevel());
                weapon1.setWeaponNumber(0);

                weapon2.setGobj(weapon);
                weapon2.setDamage(Game.getWeapon2().getDamage());
                weapon2.setLevel(Game.getWeapon2().getLevel());
                weapon2.setWeaponNumber(1);

                weaponsList.set(0, weapon1);
                weaponsList.set(1, weapon2);

                coin.setGobj(coinImage);
                coin.setCoinCount(Game.getCoin().getCoinCount());

                player.setGobj(hero);
                player.setCoin(Game.getPlayer().getCoin());
                player.setJumpDistance(Game.getPlayer().getJumpDistance());
                player.setJumpHeight(Game.getPlayer().getJumpHeight());
                player.setHelmet(Game.getPlayer().getHelmet());
                player.setCoin_count_2(Game.getPlayer().getCoin_count_2());
                player.setWeaponsList(weaponsList,1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FadeTransition fade_obj = new FadeTransition();
        fade_obj.setDuration(Duration.millis(1));
        fade_obj.setToValue(0);
        fade_obj.setNode(weapon);
        fade_obj.play();
        startPlay();
    }


}
