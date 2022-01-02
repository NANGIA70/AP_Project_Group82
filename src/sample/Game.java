package sample;

import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.ArrayList;

public class Game implements Serializable {
    private static Coin coin;
    private static Weapon1 weapon1;
    private static  Weapon2 weapon2;
    private static Player player;
    private static BossOrc boss;
    private static ArrayList<Island> islandsArrayList = new ArrayList<Island>();
    private static ArrayList<Orc> orcArrayList = new ArrayList<Orc>();
    private static ArrayList<TreasureChest> treasureChestArrayList = new ArrayList<TreasureChest>();
    private static ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
    private static FallingFloor ff1;
    private static FallingFloor ff2;
    private static Helmet helmet;
    private static transient AnchorPane content;

    public Game(FallingFloor ff1, FallingFloor ff2, Helmet helmet, ArrayList<Island> islandsArrayList, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, ArrayList<Weapon> weaponsList,AnchorPane content, Coin coin, Weapon1 weapon1, Weapon2 weapon2, Player player, BossOrc boss) {
        Game.content = content;
        Game.coin = coin;
        Game.weapon1 = weapon1;
        Game.weapon2 = weapon2;
        Game.player = player;
        Game.boss = boss;
    }

    public void serialize() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("GameObject.txt"));
            out.writeObject(this);
        }
        catch (Exception e) {
//
        }
        finally {
            out.close();
        }
    }

    public Game deserialize() throws IOException {
        ObjectInputStream in = null;
        Game gameOld = null;
        try {
            in = new ObjectInputStream(new FileInputStream("GameObject.txt"));
            gameOld = (Game) in.readObject();
        }
        catch (Exception e) {
//
        }
        finally {
            in.close();
        }
        return gameOld;
    }

    public static Coin getCoin() {
        return coin;
    }

    public static void setCoin(Coin coin) {
        Game.coin = coin;
    }

    public static Weapon1 getWeapon1() {
        return weapon1;
    }

    public static void setWeapon1(Weapon1 weapon1) {
        Game.weapon1 = weapon1;
    }

    public static Weapon2 getWeapon2() {
        return weapon2;
    }

    public static void setWeapon2(Weapon2 weapon2) {
        Game.weapon2 = weapon2;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Game.player = player;
    }

    public static BossOrc getBoss() {
        return boss;
    }

    public static void setBoss(BossOrc boss) {
        Game.boss = boss;
    }

    public static ArrayList<Island> getIslandsArrayList() {
        return islandsArrayList;
    }

    public static void setIslandsArrayList(ArrayList<Island> islandsArrayList) {
        Game.islandsArrayList = islandsArrayList;
    }

    public static ArrayList<Orc> getOrcArrayList() {
        return orcArrayList;
    }

    public static void setOrcArrayList(ArrayList<Orc> orcArrayList) {
        Game.orcArrayList = orcArrayList;
    }

    public static ArrayList<TreasureChest> getTreasureChestArrayList() {
        return treasureChestArrayList;
    }

    public static void setTreasureChestArrayList(ArrayList<TreasureChest> treasureChestArrayList) {
        Game.treasureChestArrayList = treasureChestArrayList;
    }

    public static ArrayList<Weapon> getWeaponsList() {
        return weaponsList;
    }

    public static void setWeaponsList(ArrayList<Weapon> weaponsList) {
        Game.weaponsList = weaponsList;
    }

    public static FallingFloor getFf1() {
        return ff1;
    }

    public static void setFf1(FallingFloor ff1) {
        Game.ff1 = ff1;
    }

    public static FallingFloor getFf2() {
        return ff2;
    }

    public static void setFf2(FallingFloor ff2) {
        Game.ff2 = ff2;
    }

    public static Helmet getHelmet() {
        return helmet;
    }

    public static void setHelmet(Helmet helmet) {
        Game.helmet = helmet;
    }

    public static AnchorPane getContent() {
        return content;
    }

    public static void setContent(AnchorPane content) {
        Game.content = content;
    }
}
