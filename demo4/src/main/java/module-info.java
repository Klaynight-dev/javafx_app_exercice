module TP2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;



    opens TP2 to javafx.fxml,javafx.controls,javafx.graphics,javafx.base,java.desktop;
    exports TP2;
}