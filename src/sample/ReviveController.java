package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class ReviveController {
    private Stage stage;
    private Scene scene;


    @FXML
    private AnchorPane content;

    @FXML
    private ImageView background;
    @FXML
    private ImageView reviveBackground;
    @FXML
    private ImageView coinImage;
    @FXML
    private ImageView reviveButton1;
    @FXML
    private ImageView reviveButton2;

    @FXML
    private javafx.scene.control.Label revive;
    @FXML
    private javafx.scene.control.Label noThanks;

    public void reviveAction(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 645);
        stage.setScene(scene);
        stage.show();
    }

    public void noAction(javafx.scene.input.MouseEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 645);
        stage.setScene(scene);
        stage.show();
    }
}
