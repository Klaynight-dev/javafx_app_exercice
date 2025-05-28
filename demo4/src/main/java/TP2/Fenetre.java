package TP2;


import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;



public class Fenetre extends Stage {

    public Fenetre() throws IOException {
        Scene sc = new Scene(creerSceneGraph() );
        this.setScene(sc);
    }

    private Pane creerSceneGraph() throws IOException {
        File fichier = new File("C:/Users/Elouan/cours1/demo4/src/main/java/TP2/listeClients.fxml");
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane pane = loader.load();
        return pane;
    }

}
