package forms;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Fenetre fenetre;

    public void start(Stage stage) throws IOException {
        fenetre = new Fenetre();
        fenetre.show();
    }

    static public void main(String[] args) throws IOException {
        Application.launch(args);
    }

    static public void fermer() throws IOException{
        if (fenetre != null) {
            fenetre.close();
        }
    }
}
