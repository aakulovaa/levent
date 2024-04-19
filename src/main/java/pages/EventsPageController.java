package pages;

import db.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import posts.MovieParser;
import posts.MoviePost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


public class EventsPageController {
    @FXML
    private Button backButton;

    @FXML
    private Button cinemaButton;

    @FXML
    private Button concertsButton;

    @FXML
    private Button questsButton;

    @FXML
    private Button sportButton;

    @FXML
    private Button theatreButton;

    @FXML
    void initialize() {

        DBHandler db = new DBHandler();

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

        cinemaButton.setOnAction(event -> {

            MovieParser movieParser = new MovieParser();
            List<MoviePost> parser = movieParser.parser();
            for (int i = 0; i<parser.getLast().getMovieID(); i++)
            {
                MoviePost parsingCounting = parser.get(i);

                db.moviesFilling(parsingCounting.getMovieID(),parsingCounting.getTitle().replaceAll("\u0000", ""),
                        parsingCounting.getYearRelease().replaceAll("\u0000", ""),parsingCounting.getLength().replaceAll("\u0000", ""),
                        parsingCounting.getAge().replaceAll("\u0000", ""),parsingCounting.getGenre().replaceAll("\u0000", ""),
                        parsingCounting.getDirector().replaceAll("\u0000", ""),parsingCounting.getDescription().replaceAll("\u0000", ""));

            }

            cinemaButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CinemaPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Cinema");
            stage.show();
        });

        theatreButton.setOnAction(event1 -> {

            String output = getUrlContent("https://www.afisha.ru/voronezh/theatre/");
            System.out.println("All working!!");
            System.out.println(output);

            theatreButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TheatrePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Theatre");
            stage.show();
        });

        concertsButton.setOnAction(event1 -> {

            String output = getUrlContent("https://www.afisha.ru/voronezh/concerts/");
            System.out.println("All working!!");
            System.out.println(output);

            concertsButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ConcertsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Concerts");
            stage.show();
        });

        questsButton.setOnAction(event1 -> {
            questsButton.getScene().getWindow().hide();
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

        sportButton.setOnAction(event1 -> {
            sportButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SportPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Sport");
            stage.show();
        });

    }

    private static String getUrlContent(String urlAddress){
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlAddress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null){
                content.append(line).append('\n');
            }
            bufferedReader.close();
        } catch(Exception e){
            System.out.println("not found");
        }
        return content.toString();
    }
}
