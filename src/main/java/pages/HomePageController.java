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
import java.time.format.DateTimeFormatter;


public class HomePageController {

    @FXML
    private Button chooseEvent;

    @FXML
    private DatePicker dateEvents;

    @FXML
    private TextField searchEvent;

    @FXML
    void clickChooseEvent(ActionEvent event) {

    }

    @FXML
    void initialize(){

        searchEvent.setOnAction(event -> {
            searchEvent.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pages/SearchResultPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Search Result");
            stage.show();
        });

        dateEvents.setOnAction(event -> {
            dateEvents.getScene().getWindow().hide();
            String datePicker = dateEvents.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println("https://www.afisha.ru/voronezh/schedule_cinema/" + datePicker +'/');
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pages/sortDatePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            DateSortController dateSortController = loader.getController();
            dateSortController.displayName(datePicker);

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Date Picker");
            stage.show();
        });

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
            stage.setTitle("Event");
            stage.show();
        });

    }

}
