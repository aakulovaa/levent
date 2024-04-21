package pages;

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
import models.theatre.Performance;
import pages.PerformanceItemController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheatrePageController {

    @FXML
    private GridPane grid;

    @FXML
    private AnchorPane pane;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Button theatreBackButton;

    private List<Performance> performances = new ArrayList<>();

    private Integer iterator = gettingID();

    private List<Performance> getData() {
        List<Performance> movies = new ArrayList<>();
        Performance performance;
        DBHandlerTheatre db = new DBHandlerTheatre();
        ResultSet resultSet = db.performancesGetting();
        try {
            for (int i = 0; i < iterator; i++) {//добавляет нужное количество карточек
                if (resultSet.next()) {
                    performance = new Performance();

                    performance.setPerformanceName(resultSet.getString(PerformancesConst.PERFORMANCES_NAME));
                    performance.setPerformanceGenre(resultSet.getString(PerformancesConst.PERFORMANCES_GENRE));
                    performance.setPerformanceLength(resultSet.getString(PerformancesConst.PERFORMANCES_LENGTH));
                    performance.setPerformanceAgeLimit(resultSet.getString(PerformancesConst.PERFORMANCES_AGE_LIMIT));
                    performance.setPerformanceDirector(resultSet.getString(PerformancesConst.PERFORMANCES_DIRECTOR));
                    performance.setPerformanceDescription(resultSet.getString(PerformancesConst.PERFORMANCES_DESCRIPTION));
                    performance.setPerformanceImageLink(resultSet.getString(PerformancesConst.PERFORMANCES_IMAGE_LINK));
                    performance.setPerformanceImageSource(resultSet.getString(PerformancesConst.PERFORMANCES_IMAGE_SOURCE));
                    movies.add(performance);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    @FXML
    void initialize() {

        createPerformanceChoice();

        theatreBackButton.setOnAction(event1 -> {
            theatreBackButton.getScene().getWindow().hide();
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
        DBHandlerTheatre db = new DBHandlerTheatre();
        ResultSet resultSet = db.performancesGetting();
        try {
            while (resultSet.next()) {
                count = resultSet.getInt(PerformancesConst.PERFORMANCES_ID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void createPerformanceChoice() {
        performances.addAll(getData());
        int column = 1;
        int row = 1;
        try {
            for(int i = 0; i < performances.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("performanceForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                PerformanceItemController itemController = fxmlLoader.getController();
                itemController.setData(performances.get(i));
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
