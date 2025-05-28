package forms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.io.IOException;

public class Controler {

    @FXML
    private ToggleGroup a;

    @FXML
    private CheckBox acceptation;

    @FXML
    private TextField addresse1;

    @FXML
    private TextField addresse2;

    @FXML
    private Button annuler;

    @FXML
    private ToggleGroup b;

    @FXML
    private RadioButton cheque;

    @FXML
    private TextField codep;

    @FXML
    private TextField email;

    @FXML
    private Button envoyer;

    @FXML
    private RadioButton formueB;

    @FXML
    private RadioButton formuleA;

    @FXML
    private TextField nom;

    @FXML
    private RadioButton prelevement;

    @FXML
    private TextField prenom;

    @FXML
    private TextField tel;

    @FXML
    private TextField ville;

    public void initialize() {
        Tooltip tipNom = new Tooltip("La saisie ne peut dépasser plus de 15 caractères");
        // tipNom.setShowDelay(Duration.ZERO);
        nom.setTooltip(tipNom);
        envoyer.setDisable(true);

    }
    @FXML
    private void textLimit(javafx.scene.input.KeyEvent event) throws IOException {
        if (nom.getText().length() >= 16){
            nom.deletePreviousChar();
        } if (prenom.getText().length() >= 16){
            prenom.deletePreviousChar();
        }

    }

    @FXML
    void annuler(ActionEvent event) throws IOException {
        System.out.println("Annulation");
        Main.fermer();
    }

    @FXML
    void envoyer(ActionEvent event) throws IOException {
        System.out.println("Envoyer");
        Main.fermer();
    }
}
