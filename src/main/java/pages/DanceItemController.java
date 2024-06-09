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

import models.sport.Dance;

import java.io.IOException;
import java.util.Objects;

public class DanceItemController {

    @FXML
    private Label danceAddress;

    @FXML
    private ImageView danceImage;

    @FXML
    private Button danceName;

    private Dance dance;

    public void setData(Dance dance) {
        this.dance = dance;
        danceName.setText(dance.getDanceStudioName());
        danceAddress.setText(dance.getDanceAddress());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(dance.getDanceImageSource())));
        danceImage.setImage(image);

    }

    @FXML
    void initialize() {

        loadPage();

    }

    private void loadPage(){
        danceName.setOnAction(event -> {
            danceName.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("DancePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            DancePageController dancePageController = getDancePageController(loader);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(dance.getDanceImageSource())));
            dancePageController.danceGetImage(image);


            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Dance");
            stage.show();
        });
    }

    private DancePageController getDancePageController(FXMLLoader loader) {
        DancePageController dancePageController = loader.getController();
        dancePageController.danceGetName(danceName.getText());
        dancePageController.danceGetAddress(dance.getDanceAddress());
        dancePageController.danceGetDescription(dance.getDanceDescription());
        return dancePageController;
    }

}

