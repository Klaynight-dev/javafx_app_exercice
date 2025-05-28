module com.example.cours {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cours to javafx.fxml;
    exports com.example.cours;
}