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
    private Group gr1;
    @FXML
    private Group gr2;
    @FXML
    private Group gr3;
    @FXML
    private Group group_menu;

    @FXML
    private Label distance;
    @FXML
    private Label coin_count;

    public static TranslateTransition translate_an_object(Node obj, double x_cord, double y_cord, int duration_set) {
        Duration animation_time = Duration.millis(duration_set);
        TranslateTransition translate_object = new TranslateTransition();
        translate_object.setDuration(animation_time);
        translate_object.setNode(obj);
        translate_object.setByX(x_cord);
        translate_object.setByY(y_cord);
        return translate_object;
    }

    public  void move_hero() {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(hero, 0, -100, 1000);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }

    public void move_down_menu(){
        TranslateTransition translate_object = translate_an_object(group_menu, 0, 500, 10);
        translate_object.play();
    }

    public void move_up_menu(){
        TranslateTransition translate_object = translate_an_object(group_menu, 0, -500, 10);
        translate_object.play();
    }

    public void move_down_exit(){
        TranslateTransition translate_object = translate_an_object(exit, 0, 500000, 10);
        translate_object.play();
    }

    public void move_down_load(){
        TranslateTransition translate_object = translate_an_object(load, 0, 500000, 10);
        translate_object.play();
    }

    public  void move_orc() {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(orc, 0, -120, 1000);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }

    public  void move_island(ImageView island) {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(island, 0, 10, 1000);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }

    public  void exit_game() {
        javafx.application.Platform.exit();
    }

    public void move_ClickHero() {
        if(flag && !pause_flag) {
            TranslateTransition translate_object = translate_an_object(hero, 100, 0, 500);
            translate_object.play();

            count+=1;
            distance.setText(String.valueOf(count));

//            Open Chest
            if(hero.getBoundsInParent().intersects(chest.getBoundsInParent())) {
//                Update coinCount
                Random rand = new Random();
                coinCount += (1 + rand.nextInt(6));
                coin_count.setText(String.valueOf(coinCount));

//                Change chest image
                File file = new File("src/sample/ChestOpen.png");
                chest.setImage(new Image(file.toURI().toString()));
            }
        }
    }

    public void startPlay() {
        flag = true;

        TranslateTransition translate_object = translate_an_object(heading, 0, -1000000000, 10);
        translate_object.play();

        TranslateTransition translate_object1 = translate_an_object(play, 0, 1000000000, 10);
        translate_object1.play();

        move_hero();
        move_orc();
        move_pause_button_down();
        move_down_exit();
        move_down_load();
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
            move_down_menu();
        }
    }

    public void resume_action() {
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