module demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens tp2 to javafx.fxml;
    exports tp2;

}