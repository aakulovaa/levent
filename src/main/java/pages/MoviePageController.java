package pages;

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

import java.io.IOException;

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
    @FXML
    private Button homeButton;

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
        movieImage.setFitWidth(528);
        movieImage.setFitHeight(150);
    }

    @FXML
    void initialize() {

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

        homeButton.setOnAction(event1 -> {
            homeButton.getScene().getWindow().hide();
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
