package karmaka.controllers;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import karmaka.classes.Partie;
import karmaka.view.Router;

/**
 * La classe EchelleController gère les actions et les interactions de
 * l'interface utilisateur pour l'affichage de l'échelle karmique des joueurs
 * dans le jeu.
 */
public class EchelleController implements Initializable {
    @FXML
    private AnchorPane j1Pion, j2Pion;

    @FXML
    private Text j1Nom, j2Nom;

    /**
     * Gère l'action du bouton "Retour" pour revenir à la scène du plateau de jeu.
     */
    @FXML
    public void handleRetourButton() {
        Router.getInstance().setScene("plateau");
    }

    /**
     * Initialise le contrôleur après que son élément racine ait été complètement
     * traité.
     *
     * @param arg0 URL utilisée pour résoudre les chemins relatifs aux ressources.
     * @param arg1 ResourceBundle qui contient les paramètres régionaux actuels.
     */
    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        j1Nom.setText(Partie.getInstance().getJoueur(0).getNom());
        j2Nom.setText(Partie.getInstance().getJoueur(1).getNom());

        // Affiche les pions des joueurs en fonction de leur échelle karmique.
        updatePionPosition(j1Pion, Partie.getInstance().getJoueur(0).getEchelleKarmique());
        updatePionPosition(j2Pion, Partie.getInstance().getJoueur(1).getEchelleKarmique());
    }

    /**
     * Met à jour la position du pion en fonction de l'échelle karmique du joueur.
     *
     * @param pion            Le pion à mettre à jour.
     * @param echelleKarmique L'échelle karmique du joueur.
     */
    private void updatePionPosition(AnchorPane pion, int echelleKarmique) {
        if (echelleKarmique <= 4) {
            pion.setLayoutY(400);
        } else if (echelleKarmique <= 5) {
            pion.setLayoutY(310);
        } else if (echelleKarmique <= 6) {
            pion.setLayoutY(220);
        } else if (echelleKarmique <= 7) {
            pion.setLayoutY(130);
        } else {
            pion.setLayoutY(40);
        }
    }
}
