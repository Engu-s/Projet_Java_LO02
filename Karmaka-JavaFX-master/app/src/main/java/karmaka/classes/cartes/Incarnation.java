package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Oeuvres;

/**
 * La classe Incarnation représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Choisissez une de vos Oeuvres. Copiez son pouvoir.".
 */
public class Incarnation extends Carte {
    /**
     * Constructeur de la classe Incarnation.
     * Hérite du constructeur de la classe cartes
     */
    public Incarnation() {
        super("Incarnation", Couleur.MOSAIQUE, "Choisissez une de vos Oeuvres. Copiez son pouvoir.", 1, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Incarnation.
     * Choisissez une de vos Oeuvres. Copiez son pouvoir.
     */
    public void pouvoir() {
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Incarnation va être jouée !");
        Oeuvres oeuvres = joueur.getOeuvres();
        if (oeuvres.size() > 0) {
            Carte choix = joueur.choix(
                    "Veuillez choisir la carte de votre pile Oeuvres que vous voulez copier : ",
                    oeuvres.getCartes());
            choix.pouvoir();
        } else {
            joueur.afficher("Vous n'aviez pas de cartes dans votre pile Oeuvres !");
        }
    }
}
