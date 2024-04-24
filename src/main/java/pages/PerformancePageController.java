package pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class PerformancePageController {

    @FXML
    private Label age;

    @FXML
    private Button backButton;

    @FXML
    private Text description;

    @FXML
    private Label director;

    @FXML
    private Label length;

    @FXML
    private Label performanceGenre;

    @FXML
    private ImageView performanceImage;

    @FXML
    private Label performanceName;
    @FXML
    private Button homeButton;
    @FXML
    private Hyperlink link;
    @FXML
    void hyperlink(ActionEvent event) throws IOException {
        Desktop.getDesktop().browse(URI.create(link.getAccessibleText()));
    }

    public void performanceGetImage(Image image) {
        performanceImage.setImage(image);
        performanceImage.setFitWidth(528);
        performanceImage.setFitHeight(150);
    }

    public void performanceGetName(String text) {
        performanceName.setText(text);
    }

    public void performanceGetGenre(String performanceGenreForFill) {
        performanceGenre.setText(performanceGenreForFill);
    }

    public void performanceGetAge(String performanceAgeLimit) {
        age.setText(performanceAgeLimit);
    }

    public void performanceGetLength(String performanceLength) {
        length.setText(performanceLength);
    }

    public void performanceGetDirector(String performanceDirector) {
        director.setText(performanceDirector);
    }

    public void performanceGetDescription(String performanceDescription) {
        description.setText(performanceDescription);
    }

    @FXML
    void initialize() {

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TheatrePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Theatre");
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

    public void performanceGetLink(String performanceLink) {
        link.setAccessibleText(performanceLink);
    }
}

