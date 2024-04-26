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

public class RunPageController {

    @FXML
    private Label address;

    @FXML
    private Button backButton;

    @FXML
    private Label date;

    @FXML
    private Text description;

    @FXML
    private Button homeButton;

    @FXML
    private Hyperlink link;

    @FXML
    private ImageView runImage;

    @FXML
    private Label runLogo;

    @FXML
    private Label runName;

    @FXML
    void hyperlink(ActionEvent event) throws IOException {
        Desktop.getDesktop().browse(URI.create(link.getAccessibleText()));
    }

    public void runGetImage(Image image) {
        runImage.setImage(image);
        runImage.setFitWidth(528);
        runImage.setFitHeight(150);
    }

    public void runGetName(String text) {
        runName.setText(text);
    }

    public void runGetLogo(String runGettingLogo) {
        runLogo.setText(runGettingLogo);
    }

    public void runGetLink(String runLink) {
        link.setAccessibleText(runLink);
    }

    public void runAddress(String runAddress) {
        address.setText(runAddress);
    }

    public void runDate(String runDate) {
        date.setText(runDate);
    }

    public void runGetDescription(String runDescription) {
        description.setText(runDescription);
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

