package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FallingFloor extends GameObject{
    private float rateOfFalling;
    private int numOfTiles = 5;
    private ArrayList<ImageView> falling_tiles = new ArrayList<ImageView>(numOfTiles);

    public FallingFloor(ImageView fallTile) {
        super(fallTile);
        falling_tiles.add(fallTile);
    }

    public void addTiles(ImageView tile) {
        falling_tiles.add(tile);
    }

    public void fallStart(int number) {
        if(number >= numOfTiles) {
            return;
        }

        TranslateTransition translate_object1 = translate_an_object(falling_tiles.get(number), 0,500 , 2500);
        translate_object1.setOnFinished(e -> fallStart(number + 1));
        translate_object1.play();
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
        return false;
    }

    @Override
    public void move() {

    }

    public float getRateOfFalling() {
        return rateOfFalling;
    }

    public void setRateOfFalling(float rateOfFalling) {
        this.rateOfFalling = rateOfFalling;
    }
}
