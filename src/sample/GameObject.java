package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class GameObject implements Movable, Collision{
    protected float x_Coordinate;
    protected float y_Coordinate;
    protected float x_Speed;
    protected float y_Speed;
    protected ImageView Gobj;

    public GameObject(/*float x_Coordinate, float y_Coordinate, float x_Speed, float y_Speed, */ImageView gobj) {
        this.Gobj = gobj;
//        this.x_Coordinate = x_Coordinate;
//        this.y_Coordinate = y_Coordinate;
//        this.x_Speed = x_Speed;
//        this.y_Speed = y_Speed;
    }

    public static TranslateTransition translate_an_object(Node obj, double x_cord, double y_cord, int duration_set) {
        Duration animation_time = Duration.millis(duration_set);
        TranslateTransition translate_object = new TranslateTransition();
        translate_object.setDuration(animation_time);
        translate_object.setNode(obj);
        translate_object.setByX(x_cord);
        translate_object.setByY(y_cord);
        return translate_object;
    }

    public float getX_Coordinate() {
        return x_Coordinate;
    }

    public void setX_Coordinate(float x_Coordinate) {
        this.x_Coordinate = x_Coordinate;
    }

    public ImageView getGobj() {
        return Gobj;
    }

    public void setGobj(ImageView gobj) {
        Gobj = gobj;
    }

    public float getY_Speed() {
        return y_Speed;
    }

    public void setY_Speed(float y_Speed) {
        this.y_Speed = y_Speed;
    }

    public float getX_Speed() {
        return x_Speed;
    }

    public void setX_Speed(float x_Speed) {
        this.x_Speed = x_Speed;
    }

    public float getY_Coordinate() {
        return y_Coordinate;
    }

    public void setY_Coordinate(float y_Coordinate) {
        this.y_Coordinate = y_Coordinate;
    }
}
