package sample;

import java.util.ArrayList;

public class Helmet{
    private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();

    public void useWeapon() {
//        implement
    }

    public void equipWeapon() {
//        implement
    }

//    Getters and Setters
    public ArrayList<Weapon> getWeaponsList() {
        return weaponsList;
    }

    public void setWeaponsList(ArrayList<Weapon> weaponsList) {
        this.weaponsList = weaponsList;
    }
}
