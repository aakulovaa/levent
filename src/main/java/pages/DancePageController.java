package pages;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DancePageController {

    @FXML
    private Button backButton;

    @FXML
    private Label danceAddress;

    @FXML
    private ImageView danceImage;

    @FXML
    private Label danceName;

    @FXML
    private Text description;
    @FXML
    private Button homeButton;

    public void danceGetName(String text) {
        danceName.setText(text);
    }

    public void danceGetAddress(String danceGettingAddress) {
        danceAddress.setText(danceGettingAddress);
    }

    public void danceGetDescription(String danceGettingDescription) {
        description.setText(danceGettingDescription);
    }

    public void danceGetImage(Image image) {
        danceImage.setImage(image);
        danceImage.setFitWidth(528);
        danceImage.setFitHeight(150);
    }

    @FXML
    void initialize() {

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SportPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Sport");
            stage.show();
        });

        homeButton.setOnAction(event1 -> {
            homeButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("HomePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Let's Event!");
            stage.show();
        });

    }
}
