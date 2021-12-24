package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class FallingFloor extends GameObject{
    private float rateOfFalling;
    private float numOfTiles;

    public FallingFloor(ImageView fallFloor) {
        super(fallFloor);
    }

    public void fallStart() {

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
