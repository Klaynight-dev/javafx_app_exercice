module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    exports TD1 to javafx.graphics;

    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}