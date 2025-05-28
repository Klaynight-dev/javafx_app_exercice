module tp4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tp4 to javafx.fxml;
    exports tp4;
}