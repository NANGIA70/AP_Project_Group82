package sample;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Timeline;

public class Controller implements Initializable {
    private boolean flag = false;
    private boolean pause_flag = false;
    private boolean chest_open = false;

    private int count = 0;
    private int coinCount = 0;
    private ArrayList<Node> islands = new ArrayList<>();
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
    private ImageView green_orc;
    @FXML
    private Group group_menu;
    @FXML
    private Group group_game;
    @FXML
    private Label distance;
    @FXML
    private Label coin_count;
    private TranslateTransition hero_up_down_translate_object;
    private boolean move_click_hero_in_use = false;

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
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }
    public void stop_hero()
    {
        hero_up_down_translate_object.stop();
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
    public boolean check_island_collision()
    {
        for(int i = 0;i<27;i++)
        {
            if(hero.getBoundsInParent().intersects(group_game.localToParent(islands.get(i).getBoundsInParent())))
            {
                return true;
            }
        }
        return false;
    }
    public void check_collision()
    {
        if(hero.getBoundsInParent().intersects(group_game.localToParent(chest.getBoundsInParent())) && !chest_open) {
//           Update chest status
            chest_open = true;
//                Update coinCount(Add coins)
            Random rand = new Random();
            coinCount += (1 + rand.nextInt(6));
            coin_count.setText(String.valueOf(coinCount));


//                Change chest image
            File file = new File("src/sample/ChestOpen.png");
            chest.setImage(new Image(file.toURI().toString()));
        }
        if(hero.getBoundsInParent().intersects(group_game.localToParent(island3.getBoundsInParent())) || hero.getBoundsInParent().intersects(group_game.localToParent(island2.getBoundsInParent())))
        {
            //stop_hero();
        }
        if(check_island_collision())
        {
            //stop_hero();
        }
        if(hero.getBoundsInParent().intersects(group_game.localToParent(green_orc.getBoundsInParent())))
        {
            TranslateTransition translate_object = translate_an_object(green_orc, 250, 0, 500);
            translate_object.play();
            translate_object.setOnFinished(e -> move_orc_down());
        }
    }
    public void move_orc_down()
    {
       TranslateTransition translate_object = translate_an_object(green_orc, 0, 400, 2000);
       translate_object.play();
   }
//    Function to move hero on mouse click
    public void move_hero_small(int number)
    {
        if(number < 1)
        {
            move_click_hero_in_use = false;
            return;
        }
        else
        {
            check_collision();
            TranslateTransition translate_object1 = translate_an_object(group_game, -1,0 , 5);
            translate_object1.setOnFinished(e -> move_hero_small(number -1));
            translate_object1.play();
        }

    }
    public void move_ClickHero()
    {
        if(flag && !pause_flag && !move_click_hero_in_use)
        {
            //            Update distance
            count+=1;
            distance.setText(String.valueOf(count));
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
       // add_to_group();
    }
    public void add_to_group()
    {
        File file = new File("src/sample/islands7.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageview = new ImageView(image);
        imageview.setLayoutX(495);
        imageview.setLayoutY(385);
        imageview.setFitHeight(150);
        imageview.setFitWidth(200);

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
        islands.add(island1);
        islands.add(island2);
        islands.add(island3);
        islands.add(island4);
        islands.add(island5);
        islands.add(island6);
        islands.add(island7);
        islands.add(island8);
        islands.add(island9);
        islands.add(island10);
        islands.add(island11);
        islands.add(island12);
        islands.add(island13);
        islands.add(island14);
        islands.add(island15);
        islands.add(island16);
        islands.add(island17);
        islands.add(island18);
        islands.add(island19);
        islands.add(island20);
        islands.add(island21);
        islands.add(island22);
        islands.add(island23);
        islands.add(island24);
        islands.add(island25);
        islands.add(island26);
        islands.add(island27);
    }

}