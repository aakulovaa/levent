package pages;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.theatre.Performance;

import java.io.IOException;
import java.util.Objects;

public class PerformanceItemController {

    @FXML
    private Label performanceGenre;

    @FXML
    private ImageView performanceImage;
    @FXML
    private Label address;

    @FXML
    private Label date;

    @FXML
    private Button performanceName;
    private Performance performance;

    public void setData(Performance performance) {
        this.performance = performance;
        performanceName.setText(performance.getPerformanceName());
        String[] genre = performance.getPerformanceGenre().split(" ");
        performanceGenre.setText(genre[0]);
        date.setText(performance.getPerformanceDate());
        address.setText(performance.getPerformanceAddress());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(performance.getPerformanceImageSource())));
        performanceImage.setImage(image);

    }

    @FXML
    void initialize() {

        loadPage();

    }

    private void loadPage(){
        performanceName.setOnAction(event -> {
            performanceName.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PerformancePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            PerformancePageController performancePageController = getPerformancePageController(loader);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(performance.getPerformanceImageSource())));
            performancePageController.performanceGetImage(image);


            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Performance");
            stage.show();
        });
    }

    private PerformancePageController getPerformancePageController(FXMLLoader loader) {
        PerformancePageController performancePageController = loader.getController();
        performancePageController.performanceGetName(performanceName.getText());
        performancePageController.performanceGetLink(performance.getPerformanceLink());
        performancePageController.performanceGetGenre(performance.getPerformanceGenre());
        performancePageController.performanceGetAge(performance.getPerformanceAgeLimit());
        performancePageController.performanceGetLength(performance.getPerformanceLength());
        performancePageController.performanceGetDirector(performance.getPerformanceDirector());
        performancePageController.performanceGetDescription(performance.getPerformanceDescription());
        return performancePageController;
    }

}
