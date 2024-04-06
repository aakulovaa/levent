module com.example.levent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.levent to javafx.fxml;
    exports com.example.levent;
}