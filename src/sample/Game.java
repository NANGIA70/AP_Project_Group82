package sample;

import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.ArrayList;

public class Game implements Serializable {
    private double group_X;
    private double group_Y;
    private Coin coin;
    private Weapon1 weapon1;
    private Weapon2 weapon2;
    private Player player;
    private BossOrc boss;
    private ArrayList<Island> islandsArrayList = new ArrayList<Island>();
    private ArrayList<Orc> orcArrayList = new ArrayList<Orc>();
    private ArrayList<TreasureChest> treasureChestArrayList = new ArrayList<TreasureChest>();
    private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
    private FallingFloor ff1;
    private FallingFloor ff2;
    private Helmet helmet;
    private transient AnchorPane content;

    public double getGroup_X() {
        return group_X;
    }

    public void setGroup_X(double group_X) {
        this.group_X = group_X;
    }

    public double getGroup_Y() {
        return group_Y;
    }

    public void setGroup_Y(double group_Y) {
        this.group_Y = group_Y;
    }

    public Game(double group_X, double group_Y, FallingFloor ff1, FallingFloor ff2, Helmet helmet, ArrayList<Island> islandsArrayList, ArrayList<Orc> orcArrayList, ArrayList<TreasureChest> treasureChestArrayList, ArrayList<Weapon> weaponsList, AnchorPane content, Coin coin, Weapon1 weapon1, Weapon2 weapon2, Player player, BossOrc boss) {
        this.group_X = group_X;
        this.group_Y = group_Y;
        this.ff1 = ff1;
        this.ff2 = ff2;
        this.helmet = helmet;
        this.islandsArrayList = islandsArrayList;
        this.orcArrayList = orcArrayList;
        this.weaponsList = weaponsList;
        this.treasureChestArrayList = treasureChestArrayList;
        this.content = content;
        this.coin = coin;
        this.weapon1 = weapon1;
        this.weapon2 = weapon2;
        this.player = player;
        this.boss = boss;
    }

    public static void serialize(Game gameo) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("GameObject.txt"));
            out.writeObject(gameo);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Hello exception");
        }
        finally {
            out.close();
        }
    }

    public static Game deserialize() throws IOException {
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

    public Coin getCoin() {
        return coin;
    }

    public Weapon1 getWeapon1() {
        return weapon1;
    }

    public Weapon2 getWeapon2() {
        return weapon2;
    }

    public Player getPlayer() {
        return player;
    }

    public BossOrc getBoss() {
        return boss;
    }

    public ArrayList<Island> getIslandsArrayList() {
        return islandsArrayList;
    }

    public ArrayList<Orc> getOrcArrayList() {
        return orcArrayList;
    }

    public ArrayList<TreasureChest> getTreasureChestArrayList() {
        return treasureChestArrayList;
    }

    public ArrayList<Weapon> getWeaponsList() {
        return weaponsList;
    }

    public FallingFloor getFf1() {
        return ff1;
    }

    public FallingFloor getFf2() {
        return ff2;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public AnchorPane getContent() {
        return content;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public void setWeapon1(Weapon1 weapon1) {
        this.weapon1 = weapon1;
    }

    public void setWeapon2(Weapon2 weapon2) {
        this.weapon2 = weapon2;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBoss(BossOrc boss) {
        this.boss = boss;
    }

    public void setIslandsArrayList(ArrayList<Island> islandsArrayList) {
        this.islandsArrayList = islandsArrayList;
    }

    public void setOrcArrayList(ArrayList<Orc> orcArrayList) {
        this.orcArrayList = orcArrayList;
    }

    public void setTreasureChestArrayList(ArrayList<TreasureChest> treasureChestArrayList) {
        this.treasureChestArrayList = treasureChestArrayList;
    }

    public void setWeaponsList(ArrayList<Weapon> weaponsList) {
        this.weaponsList = weaponsList;
    }

    public void setFf1(FallingFloor ff1) {
        this.ff1 = ff1;
    }

    public void setFf2(FallingFloor ff2) {
        this.ff2 = ff2;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public void setContent(AnchorPane content) {
        this.content = content;
    }
}
