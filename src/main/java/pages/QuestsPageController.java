package pages;

import db.questDB.DBHandlerQuest;
import db.questDB.QuestsConst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import models.quest.Quest;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestsPageController {

    @FXML
    private GridPane grid;

    @FXML
    private Button questBackButton;

    private final List<Quest> quests = new ArrayList<>();

    private final Integer iterator = gettingID();

    private List<Quest> getData() {
        List<Quest> concerts = new ArrayList<>();
        Quest quest;
        DBHandlerQuest db = new DBHandlerQuest();
        ResultSet resultSet = db.questsGetting();
        try {
            for (int i = 0; i < iterator; i++) {
                if (resultSet.next()) {
                    quest = new Quest();

                    quest.setQuestName(resultSet.getString(QuestsConst.QUEST_NAME));
                    quest.setQuestCountPlayers(resultSet.getString(QuestsConst.QUEST_COUNT_PLAYER));
                    quest.setQuestAgeLimit(resultSet.getString(QuestsConst.QUEST_AGE_LIMIT));
                    quest.setQuestDescription(resultSet.getString(QuestsConst.QUEST_DESCRIPTION));
                    quest.setQuestLocation(resultSet.getString(QuestsConst.QUEST_LOCATION));
                    quest.setQuestImageLink(resultSet.getString(QuestsConst.QUEST_IMAGE_LINK));
                    quest.setQuestImageSource(resultSet.getString(QuestsConst.QUEST_IMAGE_SOURCE));
                    quests.add(quest);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return concerts;
    }


    @FXML
    void initialize() {

        createQuestChoice();

        questBackButton.setOnAction(event1 -> {
            questBackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("EventsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Events");
            stage.show();
        });
    }

    public Integer gettingID() {
        int count = 0;
        DBHandlerQuest db = new DBHandlerQuest();
        try (ResultSet resultSet = db.questsGetting()) {
            while (resultSet.next()) {
                count = resultSet.getInt(QuestsConst.QUEST_ID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void createQuestChoice() {
        quests.addAll(getData());
        int column = 1;
        int row = 1;
        try {
            for (Quest quest : quests) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("questForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                QuestItemController itemController = fxmlLoader.getController();
                itemController.setData(quest);
                if (column == 3) {
                    column = 1;
                    row++;
                }
                grid.add(anchorPane, column++, row);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
