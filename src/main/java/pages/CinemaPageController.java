package pages;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import posts.MovieParser;

import java.io.IOException;

public class CinemaPageController {

    @FXML
    private Button cinemaBackButton;

    @FXML
    private Label cinemaText;


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
//        MovieParser movieParser = new MovieParser();
//        cinemaText.setText(String.valueOf(movieParser.parser().getFirst().getTitle()));
    }

}
