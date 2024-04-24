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

public class ConcertPageController {

    @FXML
    private Label age;

    @FXML
    private Button backButton;

    @FXML
    private Label concertGenre;

    @FXML
    private ImageView concertImage;

    @FXML
    private Label concertName;

    @FXML
    private Text description;
    @FXML
    private Button homeButton;

    public void concertGetImage(Image image) {
        concertImage.setImage(image);
        concertImage.setFitWidth(528);
        concertImage.setFitHeight(150);
    }

    public void concertGetName(String text) {
        concertName.setText(text);
    }

    public void concertGetGenre(String concertGenreForFill) {
        concertGenre.setText(concertGenreForFill);
    }

    public void concertGetAge(String concertAgeLimit) {
        age.setText(concertAgeLimit);
    }

    public void concertGetDescription(String concertDescription) {
        description.setText(concertDescription);
    }

    @FXML
    void initialize() {

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ConcertsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Concert");
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

