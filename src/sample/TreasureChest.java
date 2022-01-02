package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class TreasureChest extends GameObject{
    protected boolean chestOpen = false;
    public TreasureChest(ImageView chest) {
        super(chest);
    }

    @Override
    public void move() {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(this.getGobj(), 0, 10, 1000);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }

    public boolean isChestOpen() {
        return chestOpen;
    }

    public void setChestOpen(boolean chestOpen) {
        this.chestOpen = chestOpen;
    }
}
