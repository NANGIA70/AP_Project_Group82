package sample;

public class Weapon1 extends Weapon{

    public Weapon1(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed,*/ int damage, int range, int damageRadius, int level) {
        super(/*x_Coordinate, y_Coordinate, x_Speed, y_Speed,*/ damage, range, damageRadius, level);
    }

    @Override
    public void move() {
//        implement move
    }
}
