package TP2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public void start(Stage stage) throws IOException {
        Fenetre fenetre = new Fenetre();
        fenetre.show();
    }

    static public void main(String[] args) {
        Application.launch(args);
    }
}
