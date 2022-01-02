package sample;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Powerup extends GameObject
{
    private int powerup_number;
    private int increase_horizontal_jump;
    private int increase_vertical_jump;
    private int duration;

    public boolean isCollision_done() {
        return collision_done;
    }

    public void setCollision_done(boolean collision_done) {
        this.collision_done = collision_done;
    }

    private boolean collision_done = false;
    public Powerup(ImageView powerview,int powerup_number,int xjump, int yjump,int duration) {
        super(powerview);
        this.powerup_number = powerup_number;
        this.increase_horizontal_jump = xjump;
        this.increase_vertical_jump = yjump;
        this.duration = duration;
    }
    @Override
    public boolean collision(GameObject obj, Group group_game, Group group_hero)
    {
        if(collision_done == false)
        {
            if(group_hero.localToParent(obj.getGobj().getBoundsInParent()).intersects(group_game.localToParent(this.getGobj().getBoundsInParent())))
            {
                collision_done = true;
                FadeTransition fade_obj = new FadeTransition();
                fade_obj.setDuration(Duration.millis(1));
                fade_obj.setToValue(0);
                fade_obj.setNode(this.getGobj());
                fade_obj.play();
                return true;
            }
        }
        return false;
    }
    @Override
    public void move()
    {
        ;
    }
    public int getPowerup_number()
    {
        return powerup_number;
    }
    public void setPowerup_number(int powerup_number)
    {
        this.powerup_number = powerup_number;
    }

    public int getIncrease_horizontal_jump() {
        return increase_horizontal_jump;
    }
    public int getIncrease_vertical_jump() {
        return increase_vertical_jump;
    }

    public int getDuration() {
        return duration;
    }
}
