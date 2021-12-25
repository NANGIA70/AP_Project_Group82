package sample;


import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.util.Random;

public class WeaponChest extends TreasureChest {
    private Weapon chestWeapon;
    private boolean chestOpen = false;
    public static int first_time = 0;
    public WeaponChest(ImageView chest,Weapon chestWeapon) {

        super(chest);
        this.chestWeapon = chestWeapon;
    }

    @Override
    public boolean collision(GameObject obj, Group group_game,Group group_hero) {
        if(group_hero.localToParent(obj.getGobj().getBoundsInParent()).intersects(group_game.localToParent(this.getGobj().getBoundsInParent())) && !chestOpen) {
//            Update chest status
            chestOpen = true;
//            Change chest image
            File file = new File("src/sample/ChestOpen.png");
            this.getGobj().setImage(new Image(file.toURI().toString()));
//            Update Weapons
            Player player = (Player) obj;
            player.getHelmet().getWeaponsList().get(0).setLevel(player.getHelmet().getWeaponsList().get(0).getLevel() + 1);
            if(first_time == 0)
            {
                first_time = 1;
                FadeTransition fade_obj = new FadeTransition();
                fade_obj.setDuration(Duration.millis(1));
                fade_obj.setToValue(1);
                fade_obj.setNode( player.getHelmet().getWeaponsList().get(0).getGobj());
                fade_obj.play();
                player.set_weapon_number(1);
            }
            for(int i =0;i<player.getHelmet().getWeaponsList().size();i++)
            {
                if(player.get_current_weapon_number() == chestWeapon.getWeaponNumber())
                {
                    ;
                }
                else
                {
                    File file1 = new File("src/sample/WeaponShuriken.png");
                    player.getHelmet().getWeaponsList().get(0).getGobj().setImage(new Image(file1.toURI().toString()));
                }
            }
            //(player.getHelmet().getWeaponsList().get(i).getWeaponNumber() == chestWeapon.getWeaponNumber())
            //player.getHelmet().getWeaponsList().get(i).weaponUpgrade();

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
