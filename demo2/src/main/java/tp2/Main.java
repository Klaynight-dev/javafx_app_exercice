package tp2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) {
        Fenetre fenetre = new Fenetre();
        fenetre.show();
    }

    static public void main(String[] args) {
        Application.launch(args);
    }
}
