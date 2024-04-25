package pages;

import db.FillingDB;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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


    public static void main(String[] args){
//        System.out.println("Обновить данные приложения? 1 - Да /2 - Нет");
//        Scanner choiceAction = new Scanner(System.in);
//        int choice;
//        choice = choiceAction.nextInt();
//        if(choice == 1){
//
//            FillingDB fillingDB = new FillingDB();
//            fillingDB.filling();
//
//            System.out.println("Updated!");
//        }

        launch();

    }
}