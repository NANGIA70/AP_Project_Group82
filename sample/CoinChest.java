package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class CoinChest extends TreasureChest{
    private Coin chestCoin;

    public CoinChest(ImageView chest) {
        super(chest);
    }

    @Override
    public boolean collision(GameObject obj, Group group_game) {
        return false;
    }

    public Coin getChestCoin() {
        return chestCoin;
    }

    public void setChestCoin(Coin chestCoin) {
        this.chestCoin = chestCoin;
    }
}
