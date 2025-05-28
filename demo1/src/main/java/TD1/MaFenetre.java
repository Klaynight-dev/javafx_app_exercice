package TD1;

import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

import java.awt.*;


public class MaFenetre extends Stage {
    private Pane racine = new Pane();

    private Rectangle Ciel = new Rectangle(0,0,200,100);
    private Rectangle Mer = new Rectangle(0,100,200,100);
    private Rectangle Plage = new Rectangle(0,200,200,100);
    private Rectangle Serviette = new Rectangle(75,205,25,50);

    private Circle Sun = new Circle(50, 50, 25);




    public MaFenetre() {
        this.setWidth(200);
        this.setHeight(300);
        Scene sc = new Scene(creerSceneGraph());
        this.setScene(sc);
    }
    private Pane creerSceneGraph() {

        Ciel.setFill(Color.LIGHTBLUE);
        Mer.setFill(Color.BLUE);
        Plage.setFill(Color.LIGHTYELLOW);
        Serviette.setFill(Color.PURPLE);
        Sun.setFill(Color.YELLOW);

        racine.getChildren().add(Ciel);
        racine.getChildren().add(Mer);
        racine.getChildren().add(Plage);
        racine.getChildren().add(Serviette);
        racine.getChildren().add(Sun);

        return racine;
    }
}

