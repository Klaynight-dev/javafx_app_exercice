package eventMaker;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) {
        FenPuissance4 fenetre = new FenPuissance4();
        fenetre.show();
    }

    static public void main(String[] args) {
        Application.launch(args);
    }
}
