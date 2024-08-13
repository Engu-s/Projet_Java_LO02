package karmaka.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import karmaka.classes.Partie;
import karmaka.view.Router;

/**
 * La classe MenuController gère les actions et les interactions de l'interface
 * utilisateur
 * pour le menu principal du jeu.
 */
public class MenuController implements Initializable {

    /**
     * Gère l'action du bouton "Jouer" pour rediriger vers la scène de création de
     * partie.
     */
    @FXML
    private void handlePlay() {
        Router.getInstance().setScene("createGame");
    }

    /**
     * Gère l'action du bouton "Charger" pour initialiser une partie, charger une
     * sauvegarde
     * et commencer le tour de jeu.
     */
    @FXML
    private void handleLoad() {
        Partie.init();
        Partie.getInstance().charger();
        Partie.getInstance().tour();
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
    }
}
