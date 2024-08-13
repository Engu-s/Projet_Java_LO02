package karmaka.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;

public class GagnantController implements Initializable {
    @FXML
    private Text gagnant;

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        Joueur gagnantJ = Partie.getInstance().getJoueur(Partie.getInstance().getGagnant());
        gagnant.setText("Le gagnant est " + gagnantJ.getNom() + " !");
    }
}
