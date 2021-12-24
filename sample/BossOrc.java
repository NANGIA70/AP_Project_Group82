package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class BossOrc extends GameObject{
    public BossOrc(ImageView orc) {
        super(orc);
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
        return false;
    }

    @Override
    public void move() {

    }
}
