package pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button chooseEvent;

    @FXML
    private DatePicker dateEvents;

    @FXML
    private TextField searchEvent;

    @FXML
    void enterEvent(ActionEvent event) {
        searchEvent.setOnAction(event1 -> {
            System.out.println("Search Event Working!");
        });
    }

    @FXML
    void initialize(){
//        searchEvent.setOnAction(event -> {
//            System.out.println("Search Event Working!");
//        });
        chooseEvent.setOnAction(event -> {
            chooseEvent.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pages/EventsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        dateEvents.setOnAction(event -> {
            dateEvents.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pages/sortDatePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

}