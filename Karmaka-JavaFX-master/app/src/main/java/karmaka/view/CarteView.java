package karmaka.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import karmaka.classes.Carte;

/**
 * La classe CarteView étend ImageView et représente la vue graphique d'une
 * carte.
 */
public class CarteView extends ImageView {

    /**
     * Constructeur de la classe CarteView.
     *
     * @param c Carte associée à la vue.
     */
    public CarteView(Carte c) {
        super();
        super.setFitHeight(160);
        super.setFitWidth(115);
        super.setImage(new Image("/images/cartes/" + c.getNom() + ".png"));
    }
}
