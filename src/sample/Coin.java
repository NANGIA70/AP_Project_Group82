package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Coin extends GameObject{
    private int coinCount;

    public boolean isCollision_done() {
        return collision_done;
    }

    public void setCollision_done(boolean collision_done) {
        this.collision_done = collision_done;
    }

    private boolean collision_done = false;
    public Coin(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed,*/ int coinCount, ImageView coin) {
//        super(x_Coordinate, y_Coordinate, x_Speed, y_Speed);
        super(coin);
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
    public void move() {
//        empty
    }

    @Override
    public boolean collision(GameObject obj, Group group_game, Group group_hero)
    {
        if(collision_done == false)
        {
            if(group_hero.localToParent(obj.getGobj().getBoundsInParent()).intersects(group_game.localToParent(this.getGobj().getBoundsInParent())))
            {
                collision_done = true;
                FadeTransition fade_obj = new FadeTransition();
                fade_obj.setDuration(Duration.millis(1));
                fade_obj.setToValue(0);
                fade_obj.setNode(this.getGobj());
                fade_obj.play();
                return true;
            }
        }
        return false;
    }
}
