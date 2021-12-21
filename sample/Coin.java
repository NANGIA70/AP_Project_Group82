package sample;

import javafx.scene.Group;

public class Coin extends GameObject{
    private int coinCount;

    public Coin(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed,*/ int coinCount) {
//        super(x_Coordinate, y_Coordinate, x_Speed, y_Speed);
        this.coinCount = coinCount;
    }

    public void useCoins() {
        this.coinCount -= 5;
    }

    public void addCoins(int coinNum) {
        coinCount += coinNum;
    }

//    Getters and Setters
    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

//    Interface Methods
    @Override
    public boolean collision(GameObject obj, Group group_game) {
//        Implement collision with player
        return false;
    }

    @Override
    public void move() {
//        empty
    }
}
