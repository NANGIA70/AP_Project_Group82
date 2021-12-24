package sample;

import javafx.scene.image.ImageView;

public class Weapon1 extends Weapon{
    public Weapon1(int damage, int range, int damageRadius, int level, ImageView weapon) {
        super(damage, range, damageRadius, level, weapon);
    }

    @Override
    public void move() {
//        implement move
    }
}
