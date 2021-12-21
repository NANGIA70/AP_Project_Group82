package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;

public class Moving_Island extends Island{
//    Constructor
    public Moving_Island(ImageView isle) {
        super(isle);
    }

    @Override
    public void move() {
        final Timeline timeline = new Timeline();
        TranslateTransition translate_object = translate_an_object(this.Gobj, 0, 10, 1000);
        translate_object.setAutoReverse(true);
        translate_object.setCycleCount(Timeline.INDEFINITE);
        translate_object.play();
    }
}
