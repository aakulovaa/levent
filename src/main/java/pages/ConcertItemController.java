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
import models.concert.Concert;

import java.io.IOException;
import java.util.Objects;

public class ConcertItemController {

    @FXML
    private Label concertGenre;

    @FXML
    private ImageView concertImage;

    @FXML
    private Button concertName;

    private Concert concert;

    public void setData(Concert concert) {
        this.concert = concert;
        concertName.setText(concert.getConcertName());
        String[] genre = concert.getConcertGenre().split(" ");
        concertGenre.setText(genre[0]);
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(concert.getConcertImageSource())));
        concertImage.setImage(image);

    }

    @FXML
    void initialize() {

        loadPage();

    }

    private void loadPage(){
        concertName.setOnAction(event -> {
            concertName.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ConcertPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ConcertPageController concertPageController = getConcertPageController(loader);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(concert.getConcertImageSource())));
            concertPageController.concertGetImage(image);


            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Concert");
            stage.show();
        });
    }

    private ConcertPageController getConcertPageController(FXMLLoader loader) {
        ConcertPageController concertPageController = loader.getController();
        concertPageController.concertGetName(concertName.getText());
        concertPageController.concertGetGenre(concert.getConcertGenre());
        concertPageController.concertGetAge(concert.getConcertAgeLimit());
        concertPageController.concertGetDescription(concert.getConcertDescription());
        return concertPageController;
    }


}
