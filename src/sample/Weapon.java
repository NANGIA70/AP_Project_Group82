package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Weapon extends GameObject{
    private int damage;
    private int level;
    private int weaponNumber;

    public Weapon(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed,*/ int damage, int level, int weaponNumber, ImageView weapon) {
//        super(x_Coordinate, y_Coordinate, x_Speed, y_Speed);
        super(weapon);
        this.damage = damage;
        this.weaponNumber = weaponNumber;
        this.level = level;
    }

    public void weaponUpgrade()
    {
        this.level+=1;
        this.damage += 200;
//        System.out.println("Weapon number ");
//        System.out.println(weaponNumber);
//        System.out.println(damage);
    }

//    Getters and Setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWeaponNumber() {
        return weaponNumber;
    }

    public void setWeaponNumber(int weaponNumber) {
        this.weaponNumber = weaponNumber;
    }

    public boolean collision(GameObject obj, Group group_game,Group group_hero) {
//        implement collision with orc
        return false;
    }
}
