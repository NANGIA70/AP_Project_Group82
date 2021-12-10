package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class Controller implements Initializable {
    private boolean flag = false;
    private boolean pause_flag = false;
    private boolean chest_open = false;

    private int count = 0;
    private int coinCount = 0;

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
    private ImageView hero;
    @FXML
    private ImageView chest;
    @FXML
    private ImageView tree;
    @FXML
    private ImageView orc;
    @FXML
    private ImageView Menu_background;
    @FXML
    private ImageView quit;
    @FXML
    private ImageView restart;
    @FXML
    private ImageView resume;
    @FXML
    private ImageView save;
    @FXML
    private ImageView load;
    @FXML
    private ImageView pause;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView coin;


    @FXML
    private Group group_menu;

    @FXML
    private Label distance;
    @FXML
    private Label coin_count;

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
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }

//    Function to open menu
    public void move_down_menu(){
        TranslateTransition translate_object = translate_an_object(group_menu, 0, 500, 10);
        translate_object.play();
    }

//    Function to close menu
    public void move_up_menu(){
        TranslateTransition translate_object = translate_an_object(group_menu, 0, -500, 10);
        translate_object.play();
    }

//    Function to remove exit
    public void move_down_exit(){
        TranslateTransition translate_object = translate_an_object(exit, 0, 500000, 10);
        translate_object.play();
    }

//    Function to remove load
    public void move_down_load(){
        TranslateTransition translate_object = translate_an_object(load, 0, 500000, 10);
        translate_object.play();
    }

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

//    Function to close the game
    public  void exit_game() {
        javafx.application.Platform.exit();
    }

//    Function to move hero on mouse click
    public void move_ClickHero() {
        if(flag && !pause_flag) {
//            Move hero forward
            TranslateTransition translate_object = translate_an_object(hero, 100, 0, 500);
            translate_object.play();

//            Update distance
            count+=1;
            distance.setText(String.valueOf(count));

//            Open Chest
            if(hero.getBoundsInParent().intersects(chest.getBoundsInParent()) && !chest_open) {
//               Update chest status
                chest_open = true;

//                Update coinCount(Add coins)
                Random rand = new Random();
                coinCount += (1 + rand.nextInt(6));
                coin_count.setText(String.valueOf(coinCount));


//                Change chest image
                File file = new File("src/sample/ChestOpen.png");
                chest.setImage(new Image(file.toURI().toString()));
            }
        }
    }

//    Function to start the game
    public void startPlay() {
//        Update marker
        flag = true;

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

//        Bring down the pause button
        move_pause_button_down();

//        Remove exit button
        move_down_exit();

//        Remove load button
        move_down_load();

//        Start moving island3 and chest
        move_island(island3);
        move_island(chest);
    }

    public void move_pause_button_down() {
        TranslateTransition translate_object = translate_an_object(pause, 0, 90, 10);
        translate_object.play();
    }

    public void pause_menu() {
        if(!pause_flag) {
            pause_flag = true;
//            Open menu
            move_down_menu();
        }
    }

    public void resume_action() {
//        Close menu
        move_up_menu();
        pause_flag = false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {
//            translate_an_object(gr1, 400, 200, 1500).play();
//        }));
//        timeline.play();
    }
}