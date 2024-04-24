package pages;

import db.cinemaDB.DBHandlerCinema;
import db.cinemaDB.MoviesConst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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

public class SearchResultPageController {

    @FXML
    private Button backButton;

    @FXML
    private GridPane grid;

    @FXML
    private AnchorPane pane;

    @FXML
    private ScrollPane scroll;


    @FXML
    private Text searchResult;


    public void searchName(String choiceSearch) {
        searchResult.setText(choiceSearch);
    }

    private final List<Movie> movies = new ArrayList<>();

    @FXML
    void initialize() {

        createMovieChoice();

        backButton.setOnAction(event1 -> {
            backButton.getScene().getWindow().hide();
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


    private List<Movie> getData() {
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        movie.setMovieName("Карина");
        DBHandlerCinema db = new DBHandlerCinema();
        ResultSet resultSet = db.getMovie(movie);
        try {
            if (resultSet.next()) {
                movie = new Movie();

                movie.setMovieName(resultSet.getString(MoviesConst.MOVIE_NAME));
                movie.setMovieGenre(resultSet.getString(MoviesConst.MOVIE_GENRE));
                movie.setMovieDateRelease(resultSet.getString(MoviesConst.MOVIE_YEAR_RELEASE));
                movie.setMovieLength(resultSet.getString(MoviesConst.MOVIE_LENGTH));
                movie.setMovieAgeLimit(resultSet.getString(MoviesConst.MOVIE_AGE_LIMIT));
                movie.setMovieDirector(resultSet.getString(MoviesConst.MOVIE_DIRECTOR));
                movie.setMovieDescription(resultSet.getString(MoviesConst.MOVIE_DESCRIPTION));
                movie.setMovieImageLink(resultSet.getString(MoviesConst.MOVIE_IMAGE_LINK));
                movie.setMovieImageSource(resultSet.getString(MoviesConst.MOVIE_IMAGE_SOURCE));
                movies.add(movie);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return movies;
    }

    public void createMovieChoice() {
        movies.addAll(getData());
        int column = 1;
        int row = 1;
        try {
            for (Movie movie : movies) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("movieForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                MovieItemController itemController = fxmlLoader.getController();
                itemController.setData(movie);
                if (column == 3) {
                    column = 1;
                    row++;
                }
                grid.add(anchorPane, column++, row);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
