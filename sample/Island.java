package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Island extends GameObject{
    public Island(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed,*/ ImageView isle) {
        super(isle);
//        super(x_Coordinate, y_Coordinate, x_Speed, y_Speed);
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
        return obj.getGobj().getBoundsInParent().intersects(group_game.localToParent(this.getGobj().getBoundsInParent()));
    }
}
