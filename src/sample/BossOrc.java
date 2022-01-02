package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class BossOrc extends Orc {
    private int alternate = 0;
    private boolean check_if_boss_hit = false;
    private boolean boss_dead = false;
    public BossOrc(ImageView orc,int healthpoints)
    {
        super(orc,healthpoints);
    }
    public void moveBoss(AnchorPane content, ArrayList<Island> islandsArrayList, Group group_game, Group group_hero,Player player,ImageView exit) {
        if(boss_dead == true)
        {
            return;
        }
        TranslateTransition translate_object = translate_an_object(this.getGobj(), 0, -48, 500);
        translate_object.setOnFinished(e -> boss_fall_down(content, islandsArrayList, group_game, group_hero,player,exit));
        alternate+=1;
        if(alternate %2 == 0)
        {
            move_boss_horizontally(group_game,group_hero,player);
        }
        translate_object.play();
    }
    public void move_boss_under_gravity(AnchorPane content, ArrayList<Island> islandsArrayList, Group group_game, Group group_hero,Player player,ImageView exit) throws IOException {

        TranslateTransition translate_object1 = translate_an_object(this.getGobj(), 0,1 , 5);
        if(group_hero.localToParent(this.getGobj().getBoundsInParent()).intersects(group_game.localToParent(exit.getBoundsInParent())))
        {
            game_over(content);
        }
        if(check_island_collision(islandsArrayList, group_game, group_hero))
        {
            translate_object1.setOnFinished(e -> moveBoss(content, islandsArrayList, group_game, group_hero,player,exit));
        }
        else {
            translate_object1.setOnFinished(e -> {
                try {
                    this.move_boss_under_gravity(content, islandsArrayList, group_game, group_hero,player,exit);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }
        translate_object1.play();
    }
    public boolean check_island_collision(ArrayList<Island> islands, Group group_game, Group group_hero) {
        for(int i =20;i<islands.size();i++)
        {
            if (islands.get(i).check_orc_collision(this, group_game)) {
                return true;
            }
        }
        return false;
    }
    private void boss_fall_down(AnchorPane content, ArrayList<Island> islandsArrayList, Group group_game, Group group_hero,Player player,ImageView exit) {
        if(boss_dead == true)
        {
            return;
        }
        TranslateTransition translate_object1 = translate_an_object(this.getGobj(), 0,1 , 10);
        translate_object1.setOnFinished(e -> {
            try {
                move_boss_under_gravity(content, islandsArrayList, group_game, group_hero,player,exit);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        translate_object1.play();
    }
    public void move_boss_small(int number, Group group_game, Group group_hero,Player player) {
        if(boss_dead == true)
        {
            return;
        }
        if(number < 1 || check_if_boss_hit == true) {

            return;
        }
        else {
            if(check_player_collision(player,group_hero,player.get_move_click_hero_in_use(),group_game))
            {
                TranslateTransition translate_object2 = translate_an_object(group_game, 100,0 , 500);
                translate_object2.play();
            }
            TranslateTransition translate_object1 = translate_an_object(this.getGobj(), -1,0 , 10);
            translate_object1.setOnFinished(e -> move_boss_small(number - 1, group_game, group_hero,player));
            translate_object1.play();
        }
    }

    public void move_boss_horizontally(Group group_game, Group group_hero, Player player)
    {
        if(boss_dead == true)
        {
            return;
        }
        if(check_if_boss_hit == false)
        {
            TranslateTransition translate_object1 = translate_an_object(this.getGobj(), -1,0 , 10);
            translate_object1.setOnFinished(e -> move_boss_small(100, group_game, group_hero,player));
            translate_object1.play();
            if(check_player_collision(player,group_hero,player.get_move_click_hero_in_use(),group_game))
            {
                TranslateTransition translate_object2 = translate_an_object(group_game, 100,0 , 500);
                translate_object2.play();
            }
        }
    }
    public boolean check_player_collision(Player player, Group group_hero,boolean move_click_hero_in_use,Group group_game)
    {
        if(move_click_hero_in_use == true )
        {
            return false;
        }
        return group_hero.localToParent(player.getGobj().getBoundsInParent()).intersects(group_game.localToParent(this.getGobj().getBoundsInParent()));
    }
    public boolean check_collision_with_player(GameObject obj, Group group_game, Group group_hero)
    {
        if(group_hero.localToParent(obj.getGobj().getBoundsInParent()).intersects(group_game.localToParent(this.getGobj().getBoundsInParent())))
        {
            return true;
        }
        return false;
    }
    public void make_check_if_boss_hit_false()
    {
            check_if_boss_hit = false;
    }
    public void move_()
    {
        if(boss_dead == true)
        {
            return;
        }
        check_if_boss_hit = true;
        TranslateTransition translate_object3 = translate_an_object(this.getGobj(), 200,0 , 200);
        translate_object3.setOnFinished(e -> make_check_if_boss_hit_false());
        translate_object3.play();
    }
    public boolean collision_weapon(GameObject obj, Group group_game, Group group_hero)
    {
        return group_hero.localToParent(obj.getGobj().getBoundsInParent()).intersects(group_game.localToParent(this.getGobj().getBoundsInParent()));
    }
    public void death(AnchorPane content)
    {
        boss_dead = true;
        TranslateTransition translate_object3 = translate_an_object(this.getGobj(), 0,1000 , 500);
        translate_object3.setOnFinished(e -> {
            try {
                game_over(content);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        translate_object3.play();
    }
    public void game_over(AnchorPane content) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("SavePage.fxml"));
        content.getChildren().setAll(root);
    }
}
