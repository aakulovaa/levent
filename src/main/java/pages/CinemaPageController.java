package pages;

import models.cinema.Movie;
import db.cinemaDB.MoviesConst;
import db.cinemaDB.DBHandlerCinema;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaPageController {

    @FXML
    private Button cinemaBackButton;

    @FXML
    private GridPane grid;
    private final List<Movie> movies = new ArrayList<>();

    private final Integer iterator = gettingID();

    private List<Movie> getData() {
        List<Movie> movies = new ArrayList<>();
        Movie movie;
        DBHandlerCinema db = new DBHandlerCinema();
        try (ResultSet resultSet = db.moviesGetting()) {
            for (int i = 0; i < iterator; i++) {
                if (resultSet.next()) {
                    movie = new Movie();

                    movie.setMovieName(resultSet.getString(MoviesConst.MOVIE_NAME));
                    movie.setMovieLink(resultSet.getString(MoviesConst.MOVIE_LINK));
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
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    @FXML
    void initialize() {

        createMovieChoice();

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

    public Integer gettingID() {
        int count = 0;
        DBHandlerCinema db = new DBHandlerCinema();
        try (ResultSet resultSet = db.moviesGetting()) {
            while (resultSet.next()) {
                count = resultSet.getInt(MoviesConst.MOVIE_ID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
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
