package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Game {
    @FXML
    private ImageView hero;

    Helmet helmet = new Helmet();

    Coin coin = new Coin(0);

    Player player = new Player(100, 100, helmet, coin, hero);

    ArrayList<Weapon> weaponArrayList= new ArrayList<Weapon>();

    ArrayList<Island> islandArrayList = new ArrayList<Island>();

}
