package sample;

import javafx.scene.image.ImageView;

public class Weapon1 extends Weapon{
    public Weapon1(int damage, int range, int damageRadius, int level, int weaponNumber, ImageView weapon) {
        super(damage, range, damageRadius, level, weaponNumber, weapon);
    }

    @Override
    public void move() {
//        implement move
    }
}
