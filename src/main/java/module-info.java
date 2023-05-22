module com.example.solarsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.solarsystem to javafx.fxml;
    exports com.example.solarsystem;
}