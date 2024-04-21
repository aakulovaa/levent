package pages;

import models.cinema.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class MovieItemController {

    @FXML
    private Label movieGenre;

    @FXML
    private ImageView movieImage;

    @FXML
    private Button movieName;

    @FXML
    private Label movieYear;

    private Movie movie;
    private String[] date;
    private String[] genre;

    public void setData(Movie movie) {
        this.movie = movie;
        movieName.setText(movie.getMovieName());
        date = movie.getMovieDateRelease().split(" ");
        movieYear.setText(date[date.length - 1]);
        genre = movie.getMovieGenre().split(" ");
        movieGenre.setText(genre[0]);
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(movie.getMovieImageSource())));
        movieImage.setImage(image);

    }

    @FXML
    void initialize() {

        loadPage();

    }

    private void loadPage(){
        movieName.setOnAction(event -> {
            movieName.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MoviePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            MoviePageController moviePageController = getMoviePageController(loader);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(movie.getMovieImageSource())));
            moviePageController.movieImage(image);


            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Movie");
            stage.show();
        });
    }

    private MoviePageController getMoviePageController(FXMLLoader loader) {
        MoviePageController moviePageController = loader.getController();
        moviePageController.movieName(movieName.getText());
        moviePageController.movieGenre(movie.getMovieGenre());
        moviePageController.movieAge(movie.getMovieAgeLimit());
        moviePageController.movieLength(movie.getMovieLength());
        moviePageController.movieDate(movie.getMovieDateRelease());
        moviePageController.movieDirector(movie.getMovieDirector());
        moviePageController.movieDescription(movie.getMovieDescription());
        return moviePageController;
    }

}

