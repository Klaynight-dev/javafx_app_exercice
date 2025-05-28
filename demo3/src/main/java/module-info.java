module eventMaker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens eventMaker to javafx.fxml;
    exports eventMaker;
}