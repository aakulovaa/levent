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
import models.sport.Run;

import java.io.IOException;
import java.util.Objects;

public class RunItemController {

    @FXML
    private ImageView runImage;

    @FXML
    private Label runLogo;

    @FXML
    private Button runName;
    private Run run;

    public void setData(Run run) {
        this.run = run;
        runName.setText(run.getRunName());
        runLogo.setText(run.getRunLogo());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(run.getRunImageSource())));
        runImage.setImage(image);
    }

    @FXML
    void initialize() {

        loadPage();

    }

    private void loadPage(){
        runName.setOnAction(event -> {
            runName.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("RunPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            RunPageController runPageController = getRunPageController(loader);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(run.getRunImageSource())));
            runPageController.runGetImage(image);


            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Quest");
            stage.show();
        });
    }

    private RunPageController getRunPageController(FXMLLoader loader) {
        RunPageController runPageController = loader.getController();
        runPageController.runGetName(runName.getText());
        runPageController.runGetLogo(run.getRunLogo());
        runPageController.runGetLink(run.getRunLink());
        runPageController.runAddress(run.getRunAddress());
        runPageController.runDate(run.getRunDate());
        runPageController.runGetDescription(run.getRunDescription());
        return runPageController;
    }

}
