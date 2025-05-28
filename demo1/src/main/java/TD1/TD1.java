package TD1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color; // Import manquant
import javafx.scene.shape.Rectangle; // Import manquant
import javafx.scene.shape.Circle; // Import manquant

public class TD1 extends Application {
    public void start(Stage maFenetre) {
        maFenetre.setTitle("Titre de la fenêtre");
        maFenetre.setX(10);
        maFenetre.setY(200);

        maFenetre.setWidth(500);
        maFenetre.setHeight(300);

        maFenetre.setMinWidth(300);
        maFenetre.setMinHeight(100);

        // Création des formes
        Rectangle carre = new Rectangle(10, 10, 100, 100);
        carre.setFill(Color.LIGHTBLUE);
        Circle rond = new Circle(60, 60, 40);
        rond.setFill(Color.ORANGE);

        // Ajout des formes au groupe racine
        Group racine = new Group();
        racine.getChildren().add(rond);
        racine.getChildren().add(carre);

        // Création et attachement de la scène
        Scene laScene = new Scene(racine, 500, 300); // Taille ajustée
        maFenetre.setScene(laScene);

        maFenetre.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}