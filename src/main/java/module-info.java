module homePage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens pages to javafx.fxml;
    exports pages;

}