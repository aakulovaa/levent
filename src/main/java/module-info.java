module homePage {
    requires javafx.controls;
    requires javafx.fxml;


    opens homePage to javafx.fxml;
    exports homePage;

}