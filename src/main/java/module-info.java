module homePage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;


    opens pages to javafx.fxml;
    exports pages;
    exports db;
    opens db to javafx.fxml;

}