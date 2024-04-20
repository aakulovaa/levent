package pages;

import cinema.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import posts.MovieParser;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


public class MovieItemController {

    @FXML
    private Label movieGenre;

    @FXML
    private ImageView movieImage;

    @FXML
    private Label movieName;

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
        Image image = new Image(getClass().getResourceAsStream(movie.getMovieImageLink()));
        movieImage.setImage(image);

    }

}

