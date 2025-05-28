
package eventMaker;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class FenNbClics extends Stage{
	private final 	String texte = "Nombre de clicks : ";
	private int 	nbClics = 0;
	
	private	HBox 	racine 	= new HBox();
	private Button 	bouton 	= new Button("OK");
	private Label	message	= new Label(texte + nbClics);
	
	
	
	public FenNbClics() {
		this.setTitle("Exemple");
		this.setResizable(true);
		this.setScene(new Scene(creerSceneGraph() ) );
		this.setWidth(400);
	}

	private HBox creerSceneGraph() {
		this.racine.getChildren().add(bouton);
		this.racine.getChildren().add(message);
		this.bouton.setPadding(new Insets(10));
		this.message.setPadding(new Insets(10));
		this.racine.setSpacing(10);
		this.racine.setPadding(new Insets(10));

		this.bouton.setOnAction(e -> {nbClics++; this.message.setText(texte + nbClics);});
		
		return racine;
	}
}
