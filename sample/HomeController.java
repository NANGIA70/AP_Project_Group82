package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class HomeController implements Initializable {
    private boolean flag = false;
    private boolean pause_flag = false;
    private boolean chest_open = false;

    private Stage stage;
    private Scene scene;

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
    private ImageView load;
    @FXML
    private ImageView pause;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView coin;


    @FXML
    private Group group_game;

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
    public void startPlay(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 645);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}