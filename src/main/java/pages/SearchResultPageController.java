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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.cinema.Movie;
import models.concert.Concert;
import models.quest.Quest;
import models.sport.Dance;
import models.theatre.Performance;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPageController {

    @FXML
    private Button backButton;

    @FXML
    private GridPane grid;

    @FXML
    private AnchorPane pane;

    @FXML
    private ScrollPane scroll;


    @FXML
    private Text searchResult;


    public void searchName(String choiceSearch) {
        searchResult.setText(choiceSearch);
    }

    private final List<Movie> movies = new ArrayList<>();
    private final List<Performance> performances = new ArrayList<>();
    private final List<Concert> concerts = new ArrayList<>();
    private final List<Quest> quests = new ArrayList<>();
    private final List<Dance> dances = new ArrayList<>();

    @FXML
    void initialize() {

        createMovieChoice();
        createTheatreChoice();
        createConcertChoice();
        createQuestChoice();
        createDanceChoice();

        backButton.setOnAction(event1 -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("HomePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Let's Event!");
            stage.show();
        });
    }


    private List<Movie> getMovieData() {
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        movie.setMovieName("Карина");
        DBHandlerCinema db = new DBHandlerCinema();
        ResultSet resultSet = db.getMovie(movie);
        try {
            if (resultSet.next()) {
                movie = new Movie();

                movie.setMovieName(resultSet.getString(MoviesConst.MOVIE_NAME));
                movie.setMovieLink(resultSet.getString(MoviesConst.MOVIE_LINK));
                movie.setMovieGenre(resultSet.getString(MoviesConst.MOVIE_GENRE));
                movie.setMovieDateRelease(resultSet.getString(MoviesConst.MOVIE_YEAR_RELEASE));
                movie.setMovieLength(resultSet.getString(MoviesConst.MOVIE_LENGTH));
                movie.setMovieAgeLimit(resultSet.getString(MoviesConst.MOVIE_AGE_LIMIT));
                movie.setMovieDirector(resultSet.getString(MoviesConst.MOVIE_DIRECTOR));
                movie.setMovieDescription(resultSet.getString(MoviesConst.MOVIE_DESCRIPTION));
                movie.setMovieImageLink(resultSet.getString(MoviesConst.MOVIE_IMAGE_LINK));
                movie.setMovieImageSource(resultSet.getString(MoviesConst.MOVIE_IMAGE_SOURCE));
                movies.add(movie);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return movies;
    }

    public void createMovieChoice() {
        movies.addAll(getMovieData());
        int column = 1;
        int row = 1;
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

    }

    private List<Performance> getTheatreData() {
        List<Performance> performances = new ArrayList<>();
        Performance performance = new Performance();
        performance.setPerformanceName("Карина");
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

    public void createTheatreChoice() {
        performances.addAll(getTheatreData());
        int column = 1;
        int row = 1;
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
    }

    private List<Concert> getConcertData() {
        List<Concert> concerts = new ArrayList<>();
        Concert concert = new Concert();
        concert.setConcertName("Карина");
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

    public void createConcertChoice() {
        concerts.addAll(getConcertData());
        int column = 1;
        int row = 1;
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

    private List<Quest> getQuestData() {
        List<Quest> quests = new ArrayList<>();
        Quest quest = new Quest();
        quest.setQuestName("Карина");
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

    public void createQuestChoice() {
        quests.addAll(getQuestData());
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

    private List<Dance> getDanceData() {
        List<Dance> dances = new ArrayList<>();
        Dance dance = new Dance();
        dance.setDanceStudioName("Карина");
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

    public void createDanceChoice() {
        dances.addAll(getDanceData());
        int column = 1;
        int row = 1;
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
}
