package sample;

import java.util.ArrayList;

public class Helmet{
    private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
    private Weapon current_weapon;
    private int current_weapon_number;
    public void useWeapon() {
//        implement
    }
    public void equipWeapon(int weapon_number)
    {
        current_weapon = weaponsList.get(weapon_number);
        current_weapon_number = weapon_number;
    }

//    Getters and Setters
    public ArrayList<Weapon> getWeaponsList() {
        return weaponsList;
    }

    public void setWeaponsList(ArrayList<Weapon> weaponsList,int weapon_number)
    {
        this.weaponsList = weaponsList;
        this.equipWeapon(weapon_number);
    }
    public int get_current_weapon_number()
    {

        return current_weapon_number;
    }
    public void upgrade_weapon()
    {
        weaponsList.get(current_weapon_number).weaponUpgrade();
    }
}
