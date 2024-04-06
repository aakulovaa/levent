module homePage {
    requires javafx.controls;
    requires javafx.fxml;


    opens pages to javafx.fxml;
    exports pages;

}