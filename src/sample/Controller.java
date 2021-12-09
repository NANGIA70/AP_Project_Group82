package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class Controller implements Initializable {
    private boolean flag = false;
    private int count = 0;
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
    private Group gr1;
    @FXML
    private Group gr2;
    @FXML
    private Group gr3;

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
        Duration animation_time = Duration.millis(1000);
        TranslateTransition translate_object = new TranslateTransition();
        translate_object.setDuration(animation_time);
        translate_object.setNode(hero);
        translate_object.setByX(0);
        translate_object.setByY(-100);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }



    public void move_ClickHero() {
        if(flag) {
            Duration animation_time = Duration.millis(500);
            TranslateTransition translate_object = new TranslateTransition();
            translate_object.setDuration(animation_time);
            translate_object.setNode(hero);
            translate_object.setByX(100);
            translate_object.setByY(0);
            translate_object.play();
            count += 1;
            if(count == 4) {
                TranslateTransition translate_object1 = new TranslateTransition();
                translate_object1.setDuration(animation_time);
                translate_object1.setNode(chest);
                translate_object1.setByX(1000000000);
                translate_object1.setByY(0);
                translate_object1.play();
//                Image myImage = new Image(getClass().getResourceAsStream("ChestOpen.png"));
//                chest.setImage(myImage);
            }
//            if(hero.getLayoutX() == chest.getLayoutX()) {
//                //open chest
//                TranslateTransition translate_object1 = new TranslateTransition();
//                translate_object1.setDuration(animation_time);
//                translate_object1.setNode(chest);
//                translate_object1.setByX(1000000000);
//                translate_object1.setByY(0);
//                translate_object1.play();
//            }
        }
    }

    public void startPlay() {
        flag = true;
        Duration animation_time = Duration.millis(10);
        TranslateTransition translate_object = new TranslateTransition();
        translate_object.setDuration(animation_time);
        translate_object.setNode(heading);
        translate_object.setByX(0);
        translate_object.setByY(-1000000000);
        translate_object.play();
//        TranslateTransition translate_object1 = new TranslateTransition();
//        translate_object1.setDuration(animation_time);
//        translate_object1.setNode(chest);
//        translate_object1.setByX(1000000000);
//        translate_object1.setByY(0);
//        translate_object1.play();
        TranslateTransition translate_object3 = new TranslateTransition();
        translate_object3.setDuration(animation_time);
        translate_object3.setNode(play);
        translate_object3.setByX(0);
        translate_object3.setByY(1000000000);
        translate_object3.play();
        move_hero();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {
//            translate_an_object(gr1, 400, 200, 1500).play();
//        }));
//        timeline.play();
    }
}