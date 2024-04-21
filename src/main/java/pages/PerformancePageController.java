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

public class PerformancePageController {

    @FXML
    private Label age;

    @FXML
    private Button backButton;

    @FXML
    private Text description;

    @FXML
    private Label director;

    @FXML
    private Label length;

    @FXML
    private Label performanceGenre;

    @FXML
    private ImageView performanceImage;

    @FXML
    private Label performanceName;

    public void performanceImage(Image image) {
        performanceImage.setImage(image);
        performanceImage.setFitWidth(528);
        performanceImage.setFitHeight(150);
    }

    public void movieName(String text) {
        performanceName.setText(text);
    }

    public void movieGenre(String performanceGenreForFill) {
        performanceGenre.setText(performanceGenreForFill);
    }

    public void movieAge(String performanceAgeLimit) {
        age.setText(performanceAgeLimit);
    }

    public void movieLength(String performanceLength) {
        length.setText(performanceLength);
    }

    public void movieDirector(String performanceDirector) {
        director.setText(performanceDirector);
    }

    public void movieDescription(String performanceDescription) {
        description.setText(performanceDescription);
    }

    @FXML
    void initialize() {

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TheatrePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Theatre");
            stage.show();
        });

    }
}

