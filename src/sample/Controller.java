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
import javafx.util.Duration;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
public class Controller implements Initializable {
    private int count;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image2;
    @FXML
    private Group gr1;
    public static TranslateTransition translate_an_object(Node obj, double x_cord, double y_cord, int duration_set) {
        Duration animation_time = Duration.millis(duration_set);
        TranslateTransition translate_object = new TranslateTransition();
        translate_object.setDuration(animation_time);
        translate_object.setNode(obj);
        translate_object.setByX(x_cord);
        translate_object.setByY(y_cord);
        return translate_object;
    }
    public  void move_object()
    {
        final Timeline timeline = new Timeline();
        Duration animation_time = Duration.millis(2000);
        TranslateTransition translate_object = new TranslateTransition();
        translate_object.setDuration(animation_time);
        translate_object.setNode(gr1);
        translate_object.setByX(0);
        translate_object.setByY(100);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }
    public  void move_object1()
    {
        Duration animation_time = Duration.millis(2000);
        TranslateTransition translate_object = new TranslateTransition();
        translate_object.setDuration(animation_time);
        translate_object.setNode(gr1);
        translate_object.setByX(100000);
        translate_object.setByY(0);
        translate_object.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            translate_an_object(gr1, 400, 200, 1500).play();
        }));
        timeline.play();
    }
}
