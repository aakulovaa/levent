module homePage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;
    requires org.jsoup;


    opens pages to javafx.fxml;
    exports pages;
    exports db;
    opens db to javafx.fxml;
    exports posts;
    opens posts to javafx.fxml;
    exports cinemaDB;
    opens cinemaDB to javafx.fxml;

}