package sample;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class WeaponChest extends TreasureChest {
    private Weapon chestWeapon;
    private boolean chestOpen = false;
    private boolean weapon = true;

    public WeaponChest(ImageView chest) {
        super(chest);
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
        if(obj.getGobj().getBoundsInParent().intersects(group_game.localToParent(this.getGobj().getBoundsInParent())) && !chestOpen) {
//            Update chest status
            chestOpen = true;

//            Change chest image
            File file = new File("src/sample/ChestOpen.png");
            this.getGobj().setImage(new Image(file.toURI().toString()));

//            Update Weapons
            Player player = (Player) obj;
            for (int i = 0; i < player.getHelmet().getWeaponsList().size(); i++) {
                if (player.getHelmet().getWeaponsList().get(i).getWeaponNumber() == chestWeapon.getWeaponNumber()) {
                    weapon = false;
                    player.getHelmet().getWeaponsList().get(i).weaponUpgrade();
                }
            }
            if(weapon) {
                player.getHelmet().getWeaponsList().add(chestWeapon);
            }
            return true;
        }
        return false;
    }

    public Weapon getChestWeapon() {
        return chestWeapon;
    }

    public void setChestWeapon(Weapon chestWeapon) {
        this.chestWeapon = chestWeapon;
    }
}
