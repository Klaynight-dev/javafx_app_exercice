package TD1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Principale extends Application {
    public void start(Stage f) throws Exception {
        f = new MaFenetre();
        f.show();
    }

    public static void main(String args[]) {
        Application.launch();
    }
}