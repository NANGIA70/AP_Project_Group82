package sample;

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

    private boolean chest_open = false;

    private ArrayList<Island> islandsArrayList = new ArrayList<Island>();

    private ArrayList<FallingFloor> falling_tiles = new ArrayList<FallingFloor>();

    private boolean fall_floor = false;
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
    private Group group_game;

    @FXML
    private Label distance;
    @FXML
    private Label coin_count;

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

    private TranslateTransition hero_up_down_translate_object;

    private boolean move_click_hero_in_use = false;

    FallingFloor ff;

    Helmet helmet;

    Coin coin;

    Player player;


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

    //    Function to start indefinite hero jumps
    public  void move_hero() {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(hero, 0, -100, 1000);
        hero_up_down_translate_object = translate_object;
        translate_object.setOnFinished(e -> hero_fall_down());
        translate_object.play();
    }

    public void move_hero_under_gravity() {
        TranslateTransition translate_object1 = translate_an_object(hero, 0,1 , 10);
        if(check_island_collision() || check_falling_floor_collision()) {
            if(!fall_floor && check_falling_floor_collision()) {
                fall_floor = true;
                fall_start();
            }
            translate_object1.setOnFinished(e -> move_hero());
        }
        else {
            translate_object1.setOnFinished(e -> move_hero_under_gravity());
        }
        translate_object1.play();
    }

    private void hero_fall_down() {
        //TranslateTransition translate_object1 = translate_an_object(hero, 0,100 , 1000);
        TranslateTransition translate_object1 = translate_an_object(hero, 0,1 , 10);
        translate_object1.setOnFinished(e -> move_hero_under_gravity());
        translate_object1.play();
    }

    private void fall_start() {
        ff.fallStart(0);
//        if(number > 4) {
//            return;
//        }
//
//        TranslateTransition translate_object1 = translate_an_object(falling_tiles.get(number).getGobj(), 0,500 , 2500);
//        translate_object1.setOnFinished(e -> fall_start(number + 1));
//        translate_object1.play();
    }


//    public void stop_hero() {
//        hero_up_down_translate_object.stop();
//    }

    //    Function to start indefinite orc jumps
    public  void move_orc() {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(orc, 0, -120, 1000);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }

    //    Function to start indefinite island movement
    public  void move_island(ImageView island) {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(island, 0, 10, 1000);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }

    public boolean check_island_collision() {
        return player.check_island_collision(islandsArrayList, group_game);
    }

    public boolean check_falling_floor_collision() {
        for(int i = 0; i < 5; i++) {
            if(hero.getBoundsInParent().intersects(group_game.localToParent(falling_tiles.get(i).getGobj().getBoundsInParent()))) {
                return true;
            }
        }
        return false;
    }

    public void check_collision() {
        if(hero.getBoundsInParent().intersects(group_game.localToParent(chest.getBoundsInParent())) && !chest_open) {
//           Update chest status
            chest_open = true;
//                Update coinCount(Add coins)
            Random rand = new Random();
            player.addCoins(1 + rand.nextInt(6));
            coin_count.setText(String.valueOf(player.getCoin().getCoinCount()));


//                Change chest image
            File file = new File("src/sample/ChestOpen.png");
            chest.setImage(new Image(file.toURI().toString()));
        }
        if(hero.getBoundsInParent().intersects(group_game.localToParent(green_orc.getBoundsInParent()))) {
            TranslateTransition translate_object = translate_an_object(green_orc, 250, 0, 500);
            translate_object.play();
            translate_object.setOnFinished(e -> move_orc_down());
        }
    }

    public void move_orc_down() {
        TranslateTransition translate_object = translate_an_object(green_orc, 0, 400, 2000);
        translate_object.play();
    }

    //    Function to move hero on mouse click
    public void move_hero_small(int number) {
        if(number < 1) {
            move_click_hero_in_use = false;
            return;
        }
        else {
            check_collision();
            TranslateTransition translate_object1 = translate_an_object(group_game, -1,0 , 5);
            translate_object1.setOnFinished(e -> move_hero_small(number -1));
            translate_object1.play();
        }

    }

    public void move_ClickHero() {
        if(!move_click_hero_in_use) {
//            Update distance
            player.increaseScore();
            distance.setText(String.valueOf(player.getScore()));

//            Move hero forward
            move_click_hero_in_use = true;
            TranslateTransition translate_object = translate_an_object(orc, -100, 0, 500);
            translate_object.play();
            TranslateTransition translate_object1 = translate_an_object(group_game, -1,0 , 5);
            translate_object1.setOnFinished(e -> move_hero_small(100));
            translate_object1.play();
            check_collision();
        }
    }

    //    Function to start the game
    public void startPlay() {
//        Remove heading
        TranslateTransition translate_object = translate_an_object(heading, 0, -1000000000, 10);
        translate_object.play();

//        Remove Play
        TranslateTransition translate_object1 = translate_an_object(play, 0, 1000000000, 10);
        translate_object1.play();

//        Start hero jumps
        move_hero();

//        Start orc jumps
        move_orc();

//        Start moving island3 and chest
        for (Island island : islandsArrayList) {
            island.move();
        }

        move_island(chest);
        // add_to_group();
    }

//    public void add_to_group() {
//        File file = new File("src/sample/islands7.png");
//        Image image = new Image(file.toURI().toString());
//        ImageView imageview = new ImageView(image);
//        imageview.setLayoutX(495);
//        imageview.setLayoutY(385);
//        imageview.setFitHeight(150);
//        imageview.setFitWidth(200);
//    }

    public void pause_menu(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1200, 645);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {
//            translate_an_object(gr1, 400, 200, 1500).play();
//        }));
//        timeline.play();
        ff = new FallingFloor(FallingTile1);

        helmet = new Helmet();

        coin = new Coin(0, coinImage);

        player = new Player(100, 100, helmet, coin, hero);

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
        islandsArrayList.add(new Static_Island(island19));
        islandsArrayList.add(new Static_Island(island20));
        islandsArrayList.add(new Static_Island(island21));
        islandsArrayList.add(new Static_Island(island22));
        islandsArrayList.add(new Static_Island(island23));
        islandsArrayList.add(new Static_Island(island24));
        islandsArrayList.add(new Static_Island(island25));
        islandsArrayList.add(new Static_Island(island26));
        islandsArrayList.add(new Static_Island(island27));

        ff.addTiles(FallingTile2);
        ff.addTiles(FallingTile3);
        ff.addTiles(FallingTile4);
        ff.addTiles(FallingTile5);

        startPlay();
    }
}