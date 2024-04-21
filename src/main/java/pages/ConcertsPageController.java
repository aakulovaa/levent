package pages;

import db.concertDB.ConcertsConst;
import db.concertDB.DBHandlerConcert;
import db.theatreDB.DBHandlerTheatre;
import db.theatreDB.PerformancesConst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.concert.Concert;
import models.theatre.Performance;


public class ConcertsPageController {

    @FXML
    private Button concertBackButton;

    @FXML
    private GridPane grid;

    @FXML
    private AnchorPane pane;

    @FXML
    private ScrollPane scroll;

    private List<Concert> concerts = new ArrayList<>();

    private Integer iterator = gettingID();

    private List<Concert> getData() {
        List<Concert> concerts = new ArrayList<>();
        Concert concert;
        DBHandlerConcert db = new DBHandlerConcert();
        ResultSet resultSet = db.concertsGetting();
        try {
            for (int i = 0; i < iterator; i++) {//добавляет нужное количество карточек
                if (resultSet.next()) {
                    concert = new Concert();

                    concert.setConcertName(resultSet.getString(ConcertsConst.CONCERT_GROUP_NAME));
                    concert.setConcertGenre(resultSet.getString(ConcertsConst.CONCERT_GENRE));
                    concert.setConcertAgeLimit(resultSet.getString(ConcertsConst.CONCERT_AGE_LIMIT));
                    concert.setConcertDescription(resultSet.getString(ConcertsConst.CONCERT_DESCRIPTION));
                    concert.setConcertImageLink(resultSet.getString(ConcertsConst.CONCERT_IMAGE_LINK));
                    concert.setConcertImageSource(resultSet.getString(ConcertsConst.CONCERT_IMAGE_SOURCE));
                    concerts.add(concert);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return concerts;
    }


    @FXML
    void initialize() {

        createConcertChoice();

        concertBackButton.setOnAction(event1 -> {
            concertBackButton.getScene().getWindow().hide();
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
        DBHandlerConcert db = new DBHandlerConcert();
        ResultSet resultSet = db.concertsGetting();
        try {
            while (resultSet.next()) {
                count = resultSet.getInt(ConcertsConst.CONCERT_ID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void createConcertChoice() {
        concerts.addAll(getData());
        int column = 1;
        int row = 1;
        try {
            for(int i = 0; i < concerts.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("concertForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ConcertItemController itemController = fxmlLoader.getController();
                itemController.setData(concerts.get(i));
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
