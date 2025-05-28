package tp2;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Fenetre extends Stage {
    private FlowPane root = new FlowPane();
    private Button b = new Button("Bleu");
    private Button o = new Button("Orange");
    private Button v = new Button("Vert");
    private Button j = new Button("Jaune");
    private Text textArea = new Text("Choisissez une couleur puis validez :");
    private Button ok = new Button("OK");
    private Button cancel = new Button("Annuler");
    private Rectangle couleur = new Rectangle(20, 20);

    private void init() {
        Scene scene = new Scene(root, 250, 250);
        setScene(scene);
        setTitle("Couleur");

        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(250);
        textArea.setMaxHeight(250);
        ok.setOnAction(e -> {
            System.out.println("OK");
            this.close();
        });
        cancel.setOnAction(e -> {
            System.out.println("Annuler");
            this.close();
        });


        root.getChildren().addAll(textArea, b, o, v, j, ok, cancel);
    }

    public Fenetre() {
        init();
    }


}
