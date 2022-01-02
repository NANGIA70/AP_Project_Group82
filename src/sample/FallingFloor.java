package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FallingFloor extends GameObject{
    private float rateOfFalling;
    private int numOfTiles = 5;

    public void setFalling_tiles(ArrayList<ImageView> falling_tiles) {
        this.falling_tiles = falling_tiles;
    }
    private int fall_tile_which_tile_should_fall  = 0;
    private transient ArrayList<ImageView> falling_tiles = new ArrayList<ImageView>(numOfTiles);
    private boolean fall_floor_start = false;
    private int number_of_tiles_fallen = 0;
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
        number_of_tiles_fallen+=1;
        TranslateTransition translate_object1 = translate_an_object(falling_tiles.get(number), 0,500 , 2500);
        translate_object1.setOnFinished(e -> fallStart(number + 1));
        translate_object1.play();
    }
    public  ArrayList<ImageView> getFalling_tiles()
    {
        return falling_tiles;
    }

    @Override
    public void move() {

    }
    public void set_fall_floor_boolean()
    {
        fall_floor_start = false;
    }
    public boolean get_fall_floor_boolean()
    {
        return fall_floor_start;
    }
    public float getRateOfFalling() {
        return rateOfFalling;
    }

    public void setRateOfFalling(float rateOfFalling) {
        this.rateOfFalling = rateOfFalling;
    }

    @Override
    public boolean collision(GameObject obj, Group group_game, Group group_hero) {
        return false;
    }

    public int getNumber_of_tiles_fallen() {
        return number_of_tiles_fallen;
    }

    public void setNumber_of_tiles_fallen(int number_of_tiles_fallen) {
        this.number_of_tiles_fallen = number_of_tiles_fallen;
    }

    public int getFall_tile_which_tile_should_fall() {
        return fall_tile_which_tile_should_fall;
    }

    public void setFall_tile_which_tile_should_fall(int fall_tile_which_tile_should_fall) {
        this.fall_tile_which_tile_should_fall = fall_tile_which_tile_should_fall;
    }
}