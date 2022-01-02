package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Helmet implements Serializable {
    private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
    private Weapon current_weapon;
    private int current_weapon_number;
    private boolean has_weapon = false;
    public void useWeapon() {
//        implement
    }
    public void equipWeapon(int weapon_number)
    {
        has_weapon = true;
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
    public int get_current_weapon_level()
    {
        return weaponsList.get(current_weapon_number).getLevel();
    }
    public int get_current_weapon_level1()
    {
        return weaponsList.get(0).getLevel();
    }
    public int get_current_weapon_level2()
    {
        return weaponsList.get(1).getLevel();
    }

    public boolean isHas_weapon() {
        return has_weapon;
    }

    public void setHas_weapon(boolean has_weapon) {
        this.has_weapon = has_weapon;
    }
}
