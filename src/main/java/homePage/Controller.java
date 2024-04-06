package homePage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button chooseEvent;

    @FXML
    private DatePicker dateEvents;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchEvent;

    @FXML
    void initialize(){
        searchButton.setOnAction(event -> {
            System.out.println("Search Button Working!");
        });
        searchEvent.setOnAction(event -> {
            System.out.println("Search Event Working!");
        });
        chooseEvent.setOnAction(event -> {
            System.out.println("Choose Event Button Working!");
        });
        dateEvents.setOnAction(event -> {
            System.out.println("Date Events Working!");
        });
    }

}
