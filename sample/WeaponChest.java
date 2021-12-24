package sample;


import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class WeaponChest extends TreasureChest {
    private Weapon chestWeapon;

    public WeaponChest(ImageView chest) {
        super(chest);
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
        return false;
    }

    public Weapon getChestWeapon() {
        return chestWeapon;
    }

    public void setChestWeapon(Weapon chestWeapon) {
        this.chestWeapon = chestWeapon;
    }
}
