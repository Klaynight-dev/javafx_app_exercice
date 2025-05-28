package src.vue;

import src.controleur.Main;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class CtrlNouvelEmploye {
    @FXML
    private Button bnAnnuler;
    @FXML
    private Button bnOK;
    @FXML
    private ComboBox<String> cbDepartement;
    @FXML
    private ComboBox<String> cbSuperieur;
    @FXML
    private DatePicker dpDateEmbauche;
    @FXML
    private TextField txtMatricule;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPoste;
    @FXML
    private TextField txtPrime;
    @FXML
    private TextField txtSalaire;

    @FXML
    public void annuler() {
        Main.fermerNouvelEmploye();
    }

    @FXML
    public void valider() {
        // Vérification du matricule
        int matricule;
        try {
            matricule = Integer.parseInt(txtMatricule.getText());
            if (Main.getLesEmployes().stream().anyMatch(e -> e.getMatricule() == matricule)) {
                afficherErreur("Matricule déjà utilisé");
                return;
            }
        } catch (NumberFormatException e) {
            afficherErreur("Le matricule doit être un nombre");
            return;
        }

        // Vérification du supérieur
        int sup;
        if (cbSuperieur.getSelectionModel().getSelectedIndex() == 0 || cbSuperieur.getSelectionModel().getSelectedIndex() == -1) {
            sup = -1;
        } else {
            sup = Integer.parseInt(cbSuperieur.getSelectionModel().getSelectedItem());
            if (sup == matricule) {
                afficherErreur("Un employé ne peut pas être son propre supérieur");
                return;
            }
        }

        // Vérification du salaire
        float sal;
        try {
            if (txtSalaire.getText().isEmpty()) {
                sal = -1;
            } else {
                sal = Float.parseFloat(txtSalaire.getText());
                if (sal < 0) {
                    afficherErreur("Le salaire doit être positif");
                    return;
                }
            }
        } catch (NumberFormatException e) {
            afficherErreur("Le salaire doit être un nombre");
            return;
        }

        // Vérification de la prime
        float prime;
        try {
            if (txtPrime.getText().isEmpty()) {
                prime = -1;
            } else {
                prime = Float.parseFloat(txtPrime.getText());
                if (prime < 0) {
                    afficherErreur("La prime doit être positive");
                    return;
                }
            }
        } catch (NumberFormatException e) {
            afficherErreur("La prime doit être un nombre");
            return;
        }

        // Vérification de la date
        if (dpDateEmbauche.getValue().isAfter(LocalDate.now())) {
            afficherErreur("La date d'embauche ne peut pas être dans le futur");
            return;
        }

        Main.ajouterEmploye(matricule,
                txtNom.getText(),
                txtPoste.getText(),
                sup,
                dpDateEmbauche.getValue().getDayOfMonth(),
                dpDateEmbauche.getValue().getMonthValue(),
                dpDateEmbauche.getValue().getYear(),
                sal,
                prime,
                Integer.parseInt(cbDepartement.getSelectionModel().getSelectedItem())
        );
    }

    public void effacer() {
        txtMatricule.clear();
        txtNom.clear();
        txtPoste.clear();
        dpDateEmbauche.setValue(LocalDate.now());
        cbSuperieur.setValue(this.cbSuperieur.getItems().get(0));
        txtSalaire.clear();
        txtPrime.clear();
        cbDepartement.setValue(cbDepartement.getItems().get(0));
    }

    public void initialize() {
        ArrayList<Integer> lesSup = Main.getLesSuperieurs();
        this.cbSuperieur.getItems().clear();
        for (int i = 0; i < lesSup.size(); i++) {
            this.cbSuperieur.getItems().add("" + lesSup.get(i));
        }
        this.cbSuperieur.getItems().add(0, "- aucun -");
        this.cbSuperieur.setValue(this.cbSuperieur.getItems().get(0));

        ArrayList<Integer> lesDep = Main.getLesDepartements();
        this.cbDepartement.getItems().clear();
        for (int i = 0; i < lesDep.size(); i++) {
            this.cbDepartement.getItems().add("" + lesDep.get(i));
        }
        this.cbDepartement.setValue(this.cbDepartement.getItems().get(0));

        dpDateEmbauche.setValue(LocalDate.now());

        BooleanBinding manque = Bindings.or(txtMatricule.textProperty().isEmpty(), txtNom.textProperty().isEmpty());
        bnOK.disableProperty().bind(Bindings.when(manque).then(true).otherwise(false));

        // Ajout des listeners pour validation en temps réel
        txtMatricule.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtMatricule.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        txtSalaire.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*\\.?\\d*")) {
                txtSalaire.setText(oldValue);
            }
        });

        txtPrime.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*\\.?\\d*")) {
                txtPrime.setText(oldValue);
            }
        });
    }
}