module forms {
    requires javafx.controls;
    requires javafx.fxml;


    opens forms to javafx.fxml;
    exports forms;
}