package pages;

import cinema.Movie;
import cinemaDB.MoviesConst;
import db.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinemaDB.MoviesConst;

public class CinemaPageController {

    @FXML
    private Button cinemaBackButton;


    @FXML
    private GridPane grid;

    @FXML
    private AnchorPane pane;

    @FXML
    private ScrollPane scroll;


    @FXML
    void initialize() {
        Movie movie = new Movie();
        gettingMovie(movie);
        //cinemaText.setItems();
        //cinemaText.setText(movie.getMovieName());
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

    public void gettingMovie(Movie movie){
        DBHandler db = new DBHandler();
        ResultSet resultSet = db.moviesGetting();

        try {
            while(resultSet.next()) {
                movie.setMovieName(resultSet.getString(MoviesConst.MOVIE_NAME));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
