package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Fosse;
import karmaka.classes.piles.Oeuvres;
import karmaka.view.Router;

/**
 * La classe Vengeance représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Défaussez l’Oeuvre Exposée d’un rival.".
 */
public class Vengeance extends Carte {
    /**
     * Constructeur de la classe Vengeance.
     * Hérite du constructeur de la classe cartes
     */
    public Vengeance() {
        super("Vengeance", Couleur.ROUGE, "Défaussez l’Oeuvre Exposée d’un rival.", 3, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Vengeance.
     * Défaussez l’Oeuvre Exposée d’un rival.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Vengeance va être jouée !");
        Oeuvres oeuvresAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2).getOeuvres();
        Fosse fosse = Partie.getInstance().getFosse();
        if (oeuvresAdv.size() > 0) {
            Carte c = joueur.choix("Choisissez une carte parmis les oeuvres de votre adversaire.",
                    oeuvresAdv.getCartes());
            fosse.ajouter(oeuvresAdv.piocher(c));
        } else {
            joueur.afficher("Votre adversaire n'a pas d'oeuvres.");
        }
    }
}
