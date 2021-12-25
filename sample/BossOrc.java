package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class BossOrc extends GameObject{
    public BossOrc(ImageView orc) {
        super(orc);
    }
    @Override
    public void move() {

    }

    @Override
    public boolean collision(GameObject obj, Group group_game, Group group_hero) {
        return false;
    }
}
