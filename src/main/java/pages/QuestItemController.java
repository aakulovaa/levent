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
import models.quest.Quest;

import java.io.IOException;
import java.util.Objects;

public class QuestItemController {

    @FXML
    private Label questCountPlayers;

    @FXML
    private ImageView questImage;

    @FXML
    private Button questName;

    private Quest quest;

    public void setData(Quest quest) {
        this.quest = quest;
        questName.setText(quest.getQuestName());
        questCountPlayers.setText(quest.getQuestCountPlayers());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(quest.getQuestImageSource())));
        questImage.setImage(image);

    }

    @FXML
    void initialize() {

        loadPage();

    }

    private void loadPage(){
        questName.setOnAction(event -> {
            questName.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("QuestPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            QuestPageController questPageController = getQuestPageController(loader);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(quest.getQuestImageSource())));
            questPageController.questGetImage(image);


            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Quest");
            stage.show();
        });
    }

    private QuestPageController getQuestPageController(FXMLLoader loader) {
        QuestPageController questPageController = loader.getController();
        questPageController.questGetName(questName.getText());
        questPageController.questGetCountPlayers(quest.getQuestCountPlayers());
        questPageController.questGetAge(quest.getQuestAgeLimit());
        questPageController.questGetDescription(quest.getQuestDescription());
        questPageController.questGetLocation(quest.getQuestLocation());
        return questPageController;
    }

}
