package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Weapon extends GameObject{
    private int damage;
    private int range = 0;
    private int damageRadius;
    private int level;

    public Weapon(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed,*/ int damage, int range, int damageRadius, int level, ImageView weapon) {
//        super(x_Coordinate, y_Coordinate, x_Speed, y_Speed);
        super(weapon);
        this.damage = damage;
        this.range = range;
        this.damageRadius = damageRadius;
        this.level = level;
    }

    public void weaponUpgrade() {
        this.level++;
    }

//    Getters and Setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamageRadius() {
        return damageRadius;
    }

    public void setDamageRadius(int damageRadius) {
        this.damageRadius = damageRadius;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
//        implement collision with orc
        return false;
    }
}
