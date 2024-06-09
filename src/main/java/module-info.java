module homePage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;
    requires org.jsoup;
    requires java.desktop;


    opens pages to javafx.fxml;
    exports pages;
    exports db;
    opens db to javafx.fxml;
    exports db.cinemaDB;
    opens db.cinemaDB to javafx.fxml;
    exports parser;
    opens parser to javafx.fxml;
    exports posts.cinema;
    opens posts.cinema to javafx.fxml;
    exports db.theatreDB;
    opens db.theatreDB to javafx.fxml;
    exports posts.theatre;
    opens posts.theatre to javafx.fxml;
    exports db.concertDB;
    opens db.concertDB to javafx.fxml;
    exports posts.concert;
    opens posts.concert to javafx.fxml;
    exports db.questDB;
    opens db.questDB to javafx.fxml;
    exports posts.quest;
    opens posts.quest to javafx.fxml;
    exports db.sportDB;
    opens db.sportDB to javafx.fxml;
    exports posts.sport;
    opens posts.sport to javafx.fxml;

}