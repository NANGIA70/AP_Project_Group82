package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WinController {
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane content;

    @FXML
    private Group group1;

    @FXML
    private ImageView background;
    @FXML
    private ImageView winBackground;
    @FXML
    private ImageView homeImage;


    public void homeAction(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 645);
        stage.setScene(scene);
        stage.show();
    }
}