package pages;

import db.sportDB.DBHandlerDance;
import db.sportDB.DanceConst;
import db.theatreDB.DBHandlerTheatre;
import db.theatreDB.PerformancesConst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import models.sport.Dance;
import models.theatre.Performance;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportPageController {

    @FXML
    private Button backButton;

    @FXML
    private GridPane grid;

    @FXML
    private AnchorPane pane;

    @FXML
    private ScrollPane scroll;

    private List<Dance> dances = new ArrayList<>();

    private Integer iterator = gettingID();

    private List<Dance> getData() {
        List<Dance> dances1 = new ArrayList<>();
        Dance dance;
        DBHandlerDance db = new DBHandlerDance();
        ResultSet resultSet = db.danceGetting();
        try {
            for (int i = 0; i < iterator; i++) {//добавляет нужное количество карточек
                if (resultSet.next()) {
                    dance = new Dance();

                    dance.setDanceStudioName(resultSet.getString(DanceConst.DANCE_STUDIO_NAME));
                    dance.setDanceAddress(resultSet.getString(DanceConst.DANCE_ADDRESS));
                    dance.setDanceDescription(resultSet.getString(DanceConst.DANCE_DESCRIPTION));
                    dance.setDanceImageLink(resultSet.getString(DanceConst.DANCE_IMAGE_LINK));
                    dance.setDanceImageSource(resultSet.getString(DanceConst.DANCE_IMAGE_SOURCE));

                    dances1.add(dance);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dances1;
    }


    @FXML
    void initialize() {
        createDanceChoice();

        backButton.setOnAction(event1 -> {
            backButton.getScene().getWindow().hide();
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
        DBHandlerDance db = new DBHandlerDance();
        ResultSet resultSet = db.danceGetting();
        try {
            while (resultSet.next()) {
                count = resultSet.getInt(DanceConst.DANCE_ID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void createDanceChoice() {
        dances.addAll(getData());
        int column = 1;
        int row = 1;
        try {
            for(int i = 0; i < dances.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("danceForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                DanceItemController itemController = fxmlLoader.getController();
                itemController.setData(dances.get(i));
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
