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

public class QuestPageController {

    @FXML
    private Label age;

    @FXML
    private Button backButton;

    @FXML
    private Text description;

    @FXML
    private Label location;

    @FXML
    private Label questCountPerson;

    @FXML
    private ImageView questImage;

    @FXML
    private Label questName;

    public void questGetName(String text) {
        questName.setText(text);
    }

    public void questGetCountPlayers(String questCountPlayers) {
        questCountPerson.setText(questCountPlayers);
    }

    public void questGetAge(String questAgeLimit) {
        age.setText(questAgeLimit);
    }

    public void questGetDescription(String questDescription) {
        description.setText(questDescription);
    }

    public void questGetLocation(String questLocation) {
        location.setText(questLocation);
    }

    public void questGetImage(Image image) {
        questImage.setImage(image);
        questImage.setFitWidth(528);
        questImage.setFitHeight(150);
    }

    @FXML
    void initialize() {

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("QuestsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Quests");
            stage.show();
        });

    }
}
