package karmaka.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * La classe PlateauPlaceholderController initialise les images de la scène du
 * plateau de jeu (placeholder)avant le début d'une partie.
 */
public class PlateauPlaceholderController implements Initializable {
    // Cards dimensions are 160x115
    @FXML
    private ImageView source, fosse, adversaireDeck, adversaireOeuvres, adversaireVieFuture, deck, oeuvres, vieFuture,
            main;

    /**
     * Initialise les images de la scène du plateau de jeu (placeholder) avant le
     * début d'une partie.
     *
     * @param arg0 URL utilisée pour résoudre les chemins relatifs aux ressources.
     * @param arg1 ResourceBundle qui contient les paramètres régionaux actuels.
     */
    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        source.setImage(new Image("/images/cartes/Back.png"));
        fosse.setImage(new Image("/images/cartes/Back.png"));
        adversaireDeck.setImage(new Image("/images/cartes/Back.png"));
        adversaireOeuvres.setImage(new Image("/images/cartes/Back.png"));
        adversaireVieFuture.setImage(new Image("/images/cartes/Back.png"));
        deck.setImage(new Image("/images/cartes/Back.png"));
        oeuvres.setImage(new Image("/images/cartes/Back.png"));
        vieFuture.setImage(new Image("/images/cartes/Back.png"));
        main.setImage(new Image("/images/cartes/Back.png"));
    }
}
