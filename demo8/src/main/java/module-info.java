module src {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens src.vue to javafx.fxml, javafx.graphics, javafx.base, javafx.controls;
    opens src.modele to javafx.fxml, javafx.graphics, javafx.base, javafx.controls;
    opens src.controleur to javafx.fxml, javafx.graphics, javafx.base, javafx.controls;
    exports src.vue;
    exports src.modele;
    exports src.controleur;
}