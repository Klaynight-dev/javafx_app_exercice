package src.vue;

import src.controleur.Main;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import src.modele.Donnees;
import src.modele.Employe;

import static src.controleur.Main.fermerAppli;
import static src.controleur.Main.fermerModifierEmploye;
import static src.controleur.Main.getLesEmployes;

public class CtrlModifierEmploye {
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
        fermerModifierEmploye();
    }

    private void afficherErreur(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de validation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void valider() {
        try {
            int matricule = Integer.parseInt(txtMatricule.getText());

            // Vérification du matricule unique
            if (getLesEmployes().stream()
                    .anyMatch(e -> e.getMatricule() == matricule && !txtMatricule.getText().equals(String.valueOf(e.getMatricule())))) {
                afficherErreur("Ce matricule est déjà attribué");
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
            if (txtSalaire.getText().isEmpty()) {
                sal = -1;
            } else {
                try {
                    sal = Float.parseFloat(txtSalaire.getText());
                    if (sal < 0) {
                        afficherErreur("Le salaire doit être positif");
                        return;
                    }
                } catch (NumberFormatException e) {
                    afficherErreur("Le salaire doit être un nombre");
                    return;
                }
            }

            // Vérification de la prime
            float prime;
            if (txtPrime.getText().isEmpty()) {
                prime = -1;
            } else {
                try {
                    prime = Float.parseFloat(txtPrime.getText());
                    if (prime < 0) {
                        afficherErreur("La prime doit être positive");
                        return;
                    }
                } catch (NumberFormatException e) {
                    afficherErreur("La prime doit être un nombre");
                    return;
                }
            }

            // Vérification de la date
            if (dpDateEmbauche.getValue() == null) {
                afficherErreur("La date d'embauche est obligatoire");
                return;
            }
            if (dpDateEmbauche.getValue().isAfter(LocalDate.now())) {
                afficherErreur("La date d'embauche ne peut pas être dans le futur");
                return;
            }

            // Vérification du département
            if (cbDepartement.getSelectionModel().getSelectedItem() == null) {
                afficherErreur("Veuillez sélectionner un département");
                return;
            }

            Main.modifierEmploye(matricule,
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

        } catch (NumberFormatException e) {
            afficherErreur("Le matricule doit être un nombre entier");
        }
    }

    public void afficherEmploye(Employe e) {
        txtMatricule.setText("" + e.getMatricule());
        txtNom.setText(e.getNom());
        txtPoste.setText(e.getPoste());
        if (!e.getEmbauche().equals("")) {
            String dateemb[] = e.getEmbauche().split("/");
            int jour = Integer.parseInt(dateemb[2]);
            int mois = Integer.parseInt(dateemb[1]);
            int annee = Integer.parseInt(dateemb[0]);
            dpDateEmbauche.setValue(LocalDate.of(annee, mois, jour));
        }
        if (e.getSuperieur() == -1) {
            cbSuperieur.setValue("- aucun -");
        } else {
            cbSuperieur.setValue("" + e.getSuperieur());
        }

        txtSalaire.clear();
        if (e.getSalaire() != -1) txtSalaire.setText("" + e.getSalaire());
        txtPrime.clear();
        if (e.getPrime() != -1) txtPrime.setText("" + e.getPrime());

        cbDepartement.setValue("" + e.getDept());
    }

    public void initialize() {
        ArrayList<Integer> lesSup = Donnees.getLesSuperieurs();
        this.cbSuperieur.getItems().clear();
        for (int i = 0; i < lesSup.size(); i++) {
            this.cbSuperieur.getItems().add("" + lesSup.get(i));
        }
        this.cbSuperieur.getItems().add(0, "- aucun -");

        ArrayList<Integer> lesDep = Donnees.getLesDepartements();
        this.cbDepartement.getItems().clear();
        for (int i = 0; i < lesDep.size(); i++) {
            this.cbDepartement.getItems().add("" + lesDep.get(i));
        }

        bnOK.disableProperty().bind(txtNom.textProperty().isEmpty());
    }
}