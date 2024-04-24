package pages;

import db.cinemaDB.DBHandlerCinema;
import db.cinemaDB.MoviesConst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.cinema.Movie;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DateSortController {

    @FXML
    private Text dateText;

    @FXML
    private Button dateBackButton;

    public void displayName(String choiceDate) {
        dateText.setText(choiceDate);
    }

    @FXML
    void initialize() {
        dateBackButton.setOnAction(event1 -> {
            dateBackButton.getScene().getWindow().hide();
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