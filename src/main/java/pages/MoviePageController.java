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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class MoviePageController {

    @FXML
    private Label age;

    @FXML
    private Button backButton;

    @FXML
    private Label date;

    @FXML
    private Text description;

    @FXML
    private Label length;

    @FXML
    private Label movieGenre;

    @FXML
    private ImageView movieImage;

    @FXML
    private Label movieName;

    @FXML
    private Label director;
    private Movie movie;

    public void movieName(String choiceMovie) {
        movieName.setText(choiceMovie);
    }
    public void movieGenre(String movieGenreChoisedMovie) {
        movieGenre.setText(movieGenreChoisedMovie);
    }

    public void movieAge(String movieAgeChoisedMovie) {
        age.setText(movieAgeChoisedMovie);
    }

    public void movieDate(String movieDateChoisedMovie) {
        date.setText(movieDateChoisedMovie);
    }

    public void movieLength(String movieLengthChoisedMovie) {
        length.setText(movieLengthChoisedMovie);
    }

    public void movieDirector(String movieDirectorChoisedMovie) {
        director.setText(movieDirectorChoisedMovie);
    }

    public void movieDescription(String movieDescriptionChoisedMovie) {
        description.setText(movieDescriptionChoisedMovie);
    }

    public void movieImage(Image movieImageChoisedMovie) {
        movieImage.setImage(movieImageChoisedMovie);
    }


//    private Movie fillMovie() {
//        movie = new Movie();
//        movie.setMovieName(movieName.getText());
//        DBHandler db = new DBHandler();
//        ResultSet resultSet = db.gettingMovie(movie);
//        int counter = 0;
//        try {
//            while (resultSet.next()){
//                counter++;
//            }
//        } catch (SQLException e) {
//                throw new RuntimeException(e);
//        }
//        if(counter>=1) {
//            try {
//                movie.setMovieGenre(resultSet.getString(MoviesConst.MOVIE_GENRE));
//                movie.setMovieDateRelease(resultSet.getString(MoviesConst.MOVIE_YEAR_RELEASE));
//                movie.setMovieLength(resultSet.getString(MoviesConst.MOVIE_LENGTH));
//                movie.setMovieAgeLimit(resultSet.getString(MoviesConst.MOVIE_AGE_LIMIT));
//                movie.setMovieDirector(resultSet.getString(MoviesConst.MOVIE_DIRECTOR));
//                movie.setMovieDescription(resultSet.getString(MoviesConst.MOVIE_DESCRIPTION));
//                movie.setMovieImageSource(resultSet.getString(MoviesConst.MOVIE_IMAGE_SOURCE));
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return movie;
//    }
//
//    public void setData(Movie movie) {
//        this.movie = movie;
//        movieGenre.setText(movie.getMovieGenre());
//        date.setText(movie.getMovieDateRelease());
//        length.setText(movie.getMovieLength());
//        age.setText(movie.getMovieAgeLimit());
//        director.setText(movie.getMovieDirector());
//        description.setText(movie.getMovieDescription());
//        Image image = null;
//        try {
//            image = new Image(new FileInputStream(movie.getMovieImageSource()));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        movieImage.setImage(image);
//    }

    @FXML
    void initialize() {

        //setData(fillMovie());
        //movieGenre.setText(fillMovie().getMovieGenre());

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CinemaPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Cinema");
            stage.show();
        });

    }

}
