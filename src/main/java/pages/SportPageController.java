package pages;

import db.sportDB.DBHandlerDance;
import db.sportDB.DBHandlerRun;
import db.sportDB.DanceConst;
import db.sportDB.RunConst;
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
import models.sport.Run;
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
    private List<Run> runs = new ArrayList<>();

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

    private List<Run> getRunData() {
        List<Run> runs = new ArrayList<>();
        Run run;
        DBHandlerRun db = new DBHandlerRun();
        ResultSet resultSet = db.runGetting();
        try {
            //for (int i = 0; i < iterator; i++) {//добавляет нужное количество карточек
                if (resultSet.next()) {
                    run = new Run();

                    run.setRunName(resultSet.getString(RunConst.RUN_NAME));
                    run.setRunLogo(resultSet.getString(RunConst.RUN_LOGO));
                    run.setRunLink(resultSet.getString(RunConst.RUN_LINK));
                    run.setRunAddress(resultSet.getString(RunConst.RUN_ADDRESS));
                    run.setRunDate(resultSet.getString(RunConst.RUN_DATE));
                    run.setRunDescription(resultSet.getString(RunConst.RUN_DESCRIPTION));
                    run.setRunImageLink(resultSet.getString(RunConst.RUN_IMAGE_LINK));
                    run.setRunImageSource(resultSet.getString(RunConst.RUN_IMAGE_SOURCE));

                    runs.add(run);

                }
            //}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return runs;
    }


    public void createRunChoice() {
        runs.addAll(getRunData());
        int column = 1;
        int row = 1;
        try {
            for (Run run : runs) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("runForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                RunItemController itemController = fxmlLoader.getController();
                itemController.setData(run);
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


    @FXML
    void initialize() {
        createSportChoice();

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

    public void createSportChoice() {
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

        runs.addAll(getRunData());
        try {
            for (Run run : runs) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("runForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                RunItemController itemController = fxmlLoader.getController();
                itemController.setData(run);
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
