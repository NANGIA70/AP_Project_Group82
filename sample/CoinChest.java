package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class CoinChest extends TreasureChest{
    private Coin chestCoin;
    private boolean chestOpen = false;

    public CoinChest(ImageView chest) {
        super(chest);
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
        if(obj.getGobj().getBoundsInParent().intersects(group_game.localToParent(this.getGobj().getBoundsInParent())) && !chestOpen) {
//            Update chest status
            chestOpen = true;

//                Change chest image
            File file = new File("src/sample/ChestOpen.png");
            this.getGobj().setImage(new Image(file.toURI().toString()));

//            Update coinCount(Add coins)
            Random rand = new Random();
            Player player = (Player) obj;
            player.addCoins(1 + rand.nextInt(6));
            return true;
        }
        return false;
    }

    public Coin getChestCoin() {
        return chestCoin;
    }

    public void setChestCoin(Coin chestCoin) {
        this.chestCoin = chestCoin;
    }
}
