package src.vue;

import javafx.scene.control.*;
import javafx.stage.Stage;
import src.controleur.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import src.modele.Employe;

import static src.controleur.Main.*;


public class CtrlListeEmployes {

    @FXML
    private Button bnAjouter;
    @FXML
    private Button bnModifier;
    @FXML
    private Button bnSupprimer;
    @FXML
    private Button bnFermer;
    @FXML
    private TableView<Employe> tvListeEmployes;

    private MenuItem optionAjouter = new MenuItem("Ajouter...");
    private MenuItem optionModifier = new MenuItem("Modifier...");
    private MenuItem optionSupprimer = new MenuItem("Supprimer");

    private ContextMenu menu = new ContextMenu(optionAjouter,
            new SeparatorMenuItem(),
            optionModifier,
            new SeparatorMenuItem(),
            optionSupprimer);

    // clic sur bouton Ajouter
    @FXML
    void clicAjouter(ActionEvent event) {
        ouvrirNouvelEmploye();
    }

    // clic sur bouton Modifier 
    @FXML
    void clicModifier(ActionEvent event) {
        Employe selectedEmploye = tvListeEmployes.getSelectionModel().getSelectedItem();
        if (selectedEmploye != null) {
            ouvrirModifierEmploye(selectedEmploye);
        }
    }

    // clic sur bouton Supprimer
    @FXML
    void clicSupprimer(ActionEvent event) {
        Employe selectedEmploye = tvListeEmployes.getSelectionModel().getSelectedItem();
        if (selectedEmploye != null) {
            supprimerEmploye(selectedEmploye);
        }
    }

    // clic sur bouton Fermer
    @FXML
    void clicFermer(ActionEvent event) {
        fermerAppli();
    }

    @FXML
    void doubleClic(MouseEvent e) {
        if (e.getClickCount() == 2
                && e.getButton() == MouseButton.PRIMARY
                && e.getTarget() instanceof Text) {
            clicModifier(null);
        }
    }

    @FXML
    void initialize() {
        TableColumn<Employe, Integer> colonne1 = new TableColumn<Employe, Integer>("Matricule");
        colonne1.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("matricule"));
        tvListeEmployes.getColumns().set(0, colonne1);
        TableColumn<Employe, String> colonne2 = new TableColumn<Employe, String>("Nom");
        colonne2.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
        tvListeEmployes.getColumns().set(1, colonne2);
        TableColumn<Employe, String> colonne3 = new TableColumn<Employe, String>("Poste");
        colonne3.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
        tvListeEmployes.getColumns().set(2, colonne3);
        TableColumn<Employe, Integer> colonne4 = new TableColumn<Employe, Integer>("Département");
        colonne4.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("dept"));
        tvListeEmployes.getColumns().set(3, colonne4);

        tvListeEmployes.setItems(Main.getLesEmployes());
        tvListeEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //A FAIRE griser les boutons Modifier et Supprimer quand aucune sélection
        bnModifier.disableProperty().bind(tvListeEmployes.getSelectionModel().selectedItemProperty().isNull());
        bnSupprimer.disableProperty().bind(tvListeEmployes.getSelectionModel().selectedItemProperty().isNull());
        tvListeEmployes.setContextMenu(menu);
        optionAjouter.setOnAction(e -> clicAjouter(e));
        optionModifier.setOnAction(e -> clicModifier(e));
        optionSupprimer.setOnAction(e -> clicSupprimer(e));

        tvListeEmployes.setOnMouseClicked(e -> doubleClic(e));

        optionModifier.disableProperty().bind(tvListeEmployes.getSelectionModel().selectedItemProperty().isNull());
        optionSupprimer.disableProperty().bind(tvListeEmployes.getSelectionModel().selectedItemProperty().isNull());
    }

}