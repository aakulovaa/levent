package pages;

import cinema.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import posts.MovieParser;

import java.io.BufferedInputStream;


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
        movieYear.setText(date[date.length-1]);
        genre = movie.getMovieGenre().split(" ");
        movieGenre.setText(genre[0]);
        Image image = new Image(getClass().getResourceAsStream(movie.getMovieImageLink()));
        movieImage.setImage(image);

    }

    public void loadImage(){
        String url = "https://s.afisha.ru/mediastorage/2a/05/4eebebd94b6041e892066224052a.jpg";
        String[] urlArr = url.split("\\.");
        if(urlArr.length>=1) {
            String fileName = "src/main/resources/image/" + 1 + "." + urlArr[urlArr.length - 1];
        }
    }

}

