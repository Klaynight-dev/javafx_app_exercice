package eventMaker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FenPuissance4 extends Stage {
	
	final private int NB_LIGNES 	= 6;
	final private int NB_COLONNES 	= 7;
	final private int RAYON 		= 20;
	final private int ECART 		= 5;
	
	private Group 		racine = new Group();
	private Circle 		pion	= new Circle(RAYON, Color.RED);
	private Rectangle 	grille	= new Rectangle();
	private Circle 		trou;
	
	public FenPuissance4() {
		this.setTitle("Puissance 4");
		this.setResizable(false);
		Scene sc = new Scene(creerSceneGraph() );
		this.setScene(sc);
	}

	private Group creerSceneGraph() {
		
		pion.setCenterX(RAYON + ECART);
		pion.setCenterY(RAYON + ECART);
		
		grille.setWidth( (2*RAYON + ECART) * NB_COLONNES + ECART );
		grille.setHeight( (2*RAYON + ECART) * NB_LIGNES + ECART );
		grille.setLayoutX(0);
		grille.setLayoutY( 2*(RAYON + ECART) );
		grille.setFill(Color.BLUE);
		
		racine.getChildren().addAll(grille, pion);
		
		for (int i=0 ; i<NB_LIGNES ; i++) {
			for (int j=0 ; j<NB_COLONNES ; j++) {
				trou = 	new Circle((2*j+1)*RAYON + (j+1)*ECART, 2*(RAYON + ECART) + (2*i+1)*RAYON + (i+1)*ECART, RAYON, Color.WHITE);
				racine.getChildren().add(trou);
			}
		}
		
		return racine;
	}
	
}
