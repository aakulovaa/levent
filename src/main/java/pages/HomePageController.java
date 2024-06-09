package pages;

import db.cinemaDB.DBHandlerCinema;
import db.cinemaDB.MoviesConst;
import db.concertDB.ConcertsConst;
import db.concertDB.DBHandlerConcert;
import db.questDB.DBHandlerQuest;
import db.questDB.QuestsConst;
import db.sportDB.DBHandlerDance;
import db.sportDB.DanceConst;
import db.theatreDB.DBHandlerTheatre;
import db.theatreDB.PerformancesConst;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.cinema.Movie;
import models.concert.Concert;
import models.quest.Quest;
import models.sport.Dance;
import models.theatre.Performance;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class HomePageController {

    @FXML
    private Button chooseEvent;

    @FXML
    private DatePicker dateEvents;
    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    @FXML
    public TextField searchEvent;

    private final List<Movie> movies = new ArrayList<>();
    private final List<Performance> performances = new ArrayList<>();
    private final List<Concert> concerts = new ArrayList<>();
    private final List<Quest> quests = new ArrayList<>();
    private final List<Dance> dances = new ArrayList<>();

    private List<Movie> getMovieData() {
        List<Movie> movies = new ArrayList<>();
        Movie movie2 = new Movie();
        movie2.setMovieName(searchEvent.getText());
        DBHandlerCinema db = new DBHandlerCinema();
        ResultSet resultSet = db.getMovie(movie2);
        try {
            if (resultSet.next()) {
                movie2 = new Movie();

                movie2.setMovieName(resultSet.getString(MoviesConst.MOVIE_NAME));
                movie2.setMovieLink(resultSet.getString(MoviesConst.MOVIE_LINK));
                movie2.setMovieGenre(resultSet.getString(MoviesConst.MOVIE_GENRE));
                movie2.setMovieDateRelease(resultSet.getString(MoviesConst.MOVIE_YEAR_RELEASE));
                movie2.setMovieLength(resultSet.getString(MoviesConst.MOVIE_LENGTH));
                movie2.setMovieAgeLimit(resultSet.getString(MoviesConst.MOVIE_AGE_LIMIT));
                movie2.setMovieDirector(resultSet.getString(MoviesConst.MOVIE_DIRECTOR));
                movie2.setMovieDescription(resultSet.getString(MoviesConst.MOVIE_DESCRIPTION));
                movie2.setMovieImageLink(resultSet.getString(MoviesConst.MOVIE_IMAGE_LINK));
                movie2.setMovieImageSource(resultSet.getString(MoviesConst.MOVIE_IMAGE_SOURCE));
                movies.add(movie2);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return movies;
    }

    private List<Performance> getTheatreData() {
        List<Performance> performances = new ArrayList<>();
        Performance performance = new Performance();
        performance.setPerformanceName(searchEvent.getText());
        DBHandlerTheatre db = new DBHandlerTheatre();
        ResultSet resultSet = db.getTheate(performance);
        try {
            if (resultSet.next()) {
                performance = new Performance();
                performance.setPerformanceName(resultSet.getString(PerformancesConst.PERFORMANCES_NAME));
                performance.setPerformanceLink(resultSet.getString(PerformancesConst.PERFORMANCES_LINK));
                performance.setPerformanceDate(resultSet.getString(PerformancesConst.PERFORMANCES_DATE));
                performance.setPerformanceAddress(resultSet.getString(PerformancesConst.PERFORMANCES_ADDRESS));
                performance.setPerformanceGenre(resultSet.getString(PerformancesConst.PERFORMANCES_GENRE));
                performance.setPerformanceLength(resultSet.getString(PerformancesConst.PERFORMANCES_LENGTH));
                performance.setPerformanceAgeLimit(resultSet.getString(PerformancesConst.PERFORMANCES_AGE_LIMIT));
                performance.setPerformanceDirector(resultSet.getString(PerformancesConst.PERFORMANCES_DIRECTOR));
                performance.setPerformanceDescription(resultSet.getString(PerformancesConst.PERFORMANCES_DESCRIPTION));
                performance.setPerformanceImageLink(resultSet.getString(PerformancesConst.PERFORMANCES_IMAGE_LINK));
                performance.setPerformanceImageSource(resultSet.getString(PerformancesConst.PERFORMANCES_IMAGE_SOURCE));
                performances.add(performance);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return performances;
    }
    private List<Concert> getConcertData() {
        List<Concert> concerts = new ArrayList<>();
        Concert concert = new Concert();
        concert.setConcertName(searchEvent.getText());//!!! получать вводимую информацию
        DBHandlerConcert db = new DBHandlerConcert();
        ResultSet resultSet = db.getConcert(concert);
        try {
            if (resultSet.next()) {
                concert = new Concert();

                concert.setConcertName(resultSet.getString(ConcertsConst.CONCERT_GROUP_NAME));
                concert.setConcertLink(resultSet.getString(ConcertsConst.CONCERT_LINK));
                concert.setConcertDate(resultSet.getString(ConcertsConst.CONCERT_DATE));
                concert.setConcertAddress(resultSet.getString(ConcertsConst.CONCERT_ADDRESS));
                concert.setConcertGenre(resultSet.getString(ConcertsConst.CONCERT_GENRE));
                concert.setConcertAgeLimit(resultSet.getString(ConcertsConst.CONCERT_AGE_LIMIT));
                concert.setConcertDescription(resultSet.getString(ConcertsConst.CONCERT_DESCRIPTION));
                concert.setConcertImageLink(resultSet.getString(ConcertsConst.CONCERT_IMAGE_LINK));
                concert.setConcertImageSource(resultSet.getString(ConcertsConst.CONCERT_IMAGE_SOURCE));
                concerts.add(concert);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return concerts;
    }

    private List<Quest> getQuestData() {
        List<Quest> quests = new ArrayList<>();
        Quest quest = new Quest();
        quest.setQuestName(searchEvent.getText());//!!! получать вводимую информацию
        DBHandlerQuest db = new DBHandlerQuest();
        ResultSet resultSet = db.getQuest(quest);
        try {
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
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return quests;
    }

    private List<Dance> getDanceData() {
        List<Dance> dances = new ArrayList<>();
        Dance dance = new Dance();
        dance.setDanceStudioName(searchEvent.getText());//!!! получать вводимую информацию
        DBHandlerDance db = new DBHandlerDance();
        ResultSet resultSet = db.getSport(dance);
        try {
            if (resultSet.next()) {
                dance = new Dance();

                dance.setDanceStudioName(resultSet.getString(DanceConst.DANCE_STUDIO_NAME));
                dance.setDanceAddress(resultSet.getString(DanceConst.DANCE_ADDRESS));
                dance.setDanceDescription(resultSet.getString(DanceConst.DANCE_DESCRIPTION));
                dance.setDanceImageLink(resultSet.getString(DanceConst.DANCE_IMAGE_LINK));
                dance.setDanceImageSource(resultSet.getString(DanceConst.DANCE_IMAGE_SOURCE));

                dances.add(dance);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return dances;
    }

    public void createChoice() {
        int column = 1;
        int row = 1;
        movies.addAll(getMovieData());
        try {
            for (Movie movie : movies) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("movieForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                MovieItemController itemController = fxmlLoader.getController();
                itemController.setData(movie);
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

        performances.addAll(getTheatreData());
        try {
            for (Performance performance : performances) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("performanceForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                PerformanceItemController itemController = fxmlLoader.getController();
                itemController.setData(performance);
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

        concerts.addAll(getConcertData());
        try {
            for (Concert concert : concerts) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("concertForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ConcertItemController itemController = fxmlLoader.getController();
                itemController.setData(concert);
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

        quests.addAll(getQuestData());
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

        dances.addAll(getDanceData());
        try {
            for (Dance dance : dances) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("danceForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                DanceItemController itemController = fxmlLoader.getController();
                itemController.setData(dance);
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
    void enterEvent(ActionEvent event) {
        createChoice();
    }

    @FXML
    void clickChooseEvent(ActionEvent event) {
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
    }

    private List<Performance> getTheatreInfoForDate() {
        List<Performance> performances = new ArrayList<>();
        Performance performance = new Performance();
        String[] date = dateEvents.getValue().format(DateTimeFormatter.ofPattern("d-MMMM")).split("-");
        String dateText = date[0] + " " + date[1];
        performance.setPerformanceDate(dateText);
        DBHandlerTheatre db = new DBHandlerTheatre();
        ResultSet resultSet = db.getDateTheate(performance);
        try {
            if (resultSet.next()) {
                performance = new Performance();

                performance.setPerformanceName(resultSet.getString(PerformancesConst.PERFORMANCES_NAME));
                performance.setPerformanceLink(resultSet.getString(PerformancesConst.PERFORMANCES_LINK));
                performance.setPerformanceDate(resultSet.getString(PerformancesConst.PERFORMANCES_DATE));
                performance.setPerformanceAddress(resultSet.getString(PerformancesConst.PERFORMANCES_ADDRESS));
                performance.setPerformanceGenre(resultSet.getString(PerformancesConst.PERFORMANCES_GENRE));
                performance.setPerformanceLength(resultSet.getString(PerformancesConst.PERFORMANCES_LENGTH));
                performance.setPerformanceAgeLimit(resultSet.getString(PerformancesConst.PERFORMANCES_AGE_LIMIT));
                performance.setPerformanceDirector(resultSet.getString(PerformancesConst.PERFORMANCES_DIRECTOR));
                performance.setPerformanceDescription(resultSet.getString(PerformancesConst.PERFORMANCES_DESCRIPTION));
                performance.setPerformanceImageLink(resultSet.getString(PerformancesConst.PERFORMANCES_IMAGE_LINK));
                performance.setPerformanceImageSource(resultSet.getString(PerformancesConst.PERFORMANCES_IMAGE_SOURCE));
                performances.add(performance);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return performances;
    }
    public void createDateChoice() {
        int column = 1;
        int row = 1;
        performances.addAll(getTheatreInfoForDate());
        try {
            for (Performance performance : performances) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("performanceForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                PerformanceItemController itemController = fxmlLoader.getController();
                itemController.setData(performance);
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
        concerts.addAll(getConcertInfoForDate());
        try {
            for (Concert concert : concerts) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("concertForChoice.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ConcertItemController itemController = fxmlLoader.getController();
                itemController.setData(concert);
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
    private List<Concert> getConcertInfoForDate() {
        List<Concert> concerts = new ArrayList<>();
        Concert concert = new Concert();
        String[] date = dateEvents.getValue().format(DateTimeFormatter.ofPattern("d-MMMM")).split("-");
        String dateText = date[0] + " " + date[1];
        concert.setConcertDate(dateText);
        DBHandlerConcert db = new DBHandlerConcert();
        ResultSet resultSet = db.getDateConcert(concert);
        try {
            if (resultSet.next()) {
                concert = new Concert();

                concert.setConcertName(resultSet.getString(ConcertsConst.CONCERT_GROUP_NAME));
                concert.setConcertLink(resultSet.getString(ConcertsConst.CONCERT_LINK));
                concert.setConcertDate(resultSet.getString(ConcertsConst.CONCERT_DATE));
                concert.setConcertAddress(resultSet.getString(ConcertsConst.CONCERT_ADDRESS));
                concert.setConcertGenre(resultSet.getString(ConcertsConst.CONCERT_GENRE));
                concert.setConcertAgeLimit(resultSet.getString(ConcertsConst.CONCERT_AGE_LIMIT));
                concert.setConcertDescription(resultSet.getString(ConcertsConst.CONCERT_DESCRIPTION));
                concert.setConcertImageLink(resultSet.getString(ConcertsConst.CONCERT_IMAGE_LINK));
                concert.setConcertImageSource(resultSet.getString(ConcertsConst.CONCERT_IMAGE_SOURCE));
                concerts.add(concert);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return concerts;
    }

    @FXML
    void chooseDate(ActionEvent event) {
        createDateChoice();
    }


    @FXML
    void initialize() {

    }

}
