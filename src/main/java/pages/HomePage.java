package pages;

import cinema.Movie;
import db.DBHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import posts.MovieParser;
import posts.MoviePost;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class HomePage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Let's Event!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private static void fillingMovies() {
        DBHandler db = new DBHandler();

        MovieParser movieParser = new MovieParser();
        List<MoviePost> parser = movieParser.parser();
        for (int i = 0; i<parser.getLast().getMovieID(); i++)
        {
            MoviePost parsingCounting = parser.get(i);
            String movieName = parsingCounting.getTitle().replaceAll("\u0000", "");
            String movieDateRelease = parsingCounting.getYearRelease().replaceAll("\u0000", "");
            String movieLength = parsingCounting.getLength().replaceAll("\u0000", "");
            String movieAgeLimit = parsingCounting.getAge().replaceAll("\u0000", "");
            String movieGenre = parsingCounting.getGenre().replaceAll("\u0000", "");
            String movieDirector = parsingCounting.getDirector().replaceAll("\u0000", "");
            String movieDescription = parsingCounting.getDescription().replaceAll("\u0000", "");

            Movie movie = new Movie(movieName,movieDateRelease,
                    movieLength,movieAgeLimit,movieGenre,movieDirector,movieDescription);

            db.moviesFilling(movie);

        }
    }

    public static void main(String[] args){
        System.out.println("Обновить данные приложения? 1 - Да /2 - Нет");
        Scanner choiceAction = new Scanner(System.in);
        int choice;
        choice = choiceAction.nextInt();
        if(choice == 1){
            DBHandler db = new DBHandler();
            db.moviesCleaning();
            fillingMovies();
            System.out.println("Update!");
        }
        launch();
    }
}