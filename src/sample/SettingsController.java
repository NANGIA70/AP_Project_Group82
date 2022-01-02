package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class SettingsController {
    private Stage stage;
    private Scene scene;


    @FXML
    private AnchorPane content;

    @FXML
    private ImageView background;
    @FXML
    private ImageView Menu_background;
    @FXML
    private ImageView quit;
    @FXML
    private ImageView resume;
    @FXML
    private ImageView save;


    public void resume_action(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 645);
        stage.setScene(scene);
        stage.show();
    }

    public void save_action(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SavePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 645);
        stage.setScene(scene);
        stage.show();
    }

    public void quit_action(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 645);
        stage.setScene(scene);
        stage.show();
    }

}
