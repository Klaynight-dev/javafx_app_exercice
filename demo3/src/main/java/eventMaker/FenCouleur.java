package eventMaker;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FenCouleur extends Stage{
	
	private	BorderPane 	racine 		= new BorderPane();
	private	VBox 		zoneGauche	= new VBox();
	private	HBox 		zoneBoutons = new HBox();
	private Label 		titre 		= new Label("Choisissez une couleur puis validez :");
	private RadioButton rbBleu 		= new RadioButton("Bleu");
	private RadioButton rbVert 		= new RadioButton("Vert");
	private RadioButton rbJaune 	= new RadioButton("Jaune");
	private RadioButton rbOrange 	= new RadioButton("Orange");
	private Rectangle 	carre		= new Rectangle();
	private Button 		bnAnnuler 	= new Button("Annuler");
	private Button 		bnOK 		= new Button("OK");
	private String 		couleur		= "BLUE";
	
	
	public FenCouleur() {
		this.setTitle("Couleur");
		this.setResizable(false);
		this.setWidth(250);
		this.setHeight(250);
		this.setScene(new Scene(creerSceneGraph() ) );
	}

	private Pane creerSceneGraph() {		
		racine.setPadding(new Insets(10));
		racine.setTop(titre);
		
		zoneGauche.setPadding(new Insets(10));
		zoneGauche.setSpacing(20);
		zoneGauche.getChildren().addAll(rbBleu, rbVert, rbJaune, rbOrange);
		racine.setLeft(zoneGauche);
		
		ToggleGroup groupe = new ToggleGroup();
		groupe.getToggles().addAll(rbBleu, rbVert, rbJaune, rbOrange);
		rbBleu.setSelected(true);
		
		carre.setWidth(120);
		carre.setHeight(120);
		carre.setFill(Color.BLUE);
		racine.setCenter(carre);
		
		zoneBoutons.setSpacing(10);
		zoneBoutons.setAlignment(Pos.CENTER_RIGHT);		bnAnnuler.setPrefWidth(80);		bnOK.setPrefWidth(80);*
		zoneBoutons.getChildren().addAll(bnAnnuler, bnOK);
		
		racine.setBottom(zoneBoutons);
		
		this.bnAnnuler.setOnAction(e -> this.close());
		this.bnOK.setOnAction(e -> setCouleurConsole(e));

		this.rbBleu.setOnMouseClicked(e -> {couleur="BLUE"; carre.setFill(Color.web(couleur));});
		this.rbVert.setOnMouseClicked(e -> {couleur="GREEN"; carre.setFill(Color.web(couleur));});
		this.rbJaune.setOnMouseClicked(e -> {couleur="YELLOW"; carre.setFill(Color.web(couleur));});
		this.rbOrange.setOnMouseClicked(e -> {couleur="ORANGE"; carre.setFill(Color.web(couleur));});

		this.rbBleu.setOnMouseEntered(e -> {carre.setFill(Color.BLUE);});
		this.rbBleu.setOnMouseExited(e -> {carre.setFill(Color.web(couleur));});
		this.rbVert.setOnMouseEntered(e -> {carre.setFill(Color.GREEN);});
		this.rbVert.setOnMouseExited(e -> {carre.setFill(Color.web(couleur));});
		this.rbJaune.setOnMouseEntered(e -> {carre.setFill(Color.YELLOW);});
		this.rbJaune.setOnMouseExited(e -> {carre.setFill(Color.web(couleur));});
		this.rbOrange.setOnMouseEntered(e -> {carre.setFill(Color.ORANGE);});
		this.rbOrange.setOnMouseExited(e -> {carre.setFill(Color.web(couleur));});

		return racine;
	}

	private void setCouleurConsole(ActionEvent e) {
		System.out.println("Couleur = " + couleur);
	}
}
