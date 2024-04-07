package pages;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CinemaPageController {

    @FXML
    private Button cinemaBackButton;

    @FXML
    private ImageView cinemaImage;

    @FXML
    private ImageView cinemaImage1;

    @FXML
    private ImageView cinemaImage2;

    @FXML
    private ImageView cinemaImage3;

    @FXML
    private ImageView cinemaImage4;

    @FXML
    private Label cinemaName;

    @FXML
    private Label cinemaName1;

    @FXML
    private Label cinemaName2;

    @FXML
    private Label cinemaName3;

    @FXML
    private Label cinemaName4;

    @FXML
    void initialize() {
        cinemaBackButton.setOnAction(event -> {
            cinemaBackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("EventsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Events");
            stage.show();
        });
    }

}
