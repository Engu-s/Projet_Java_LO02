package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.Pile;
import karmaka.classes.piles.Fosse;

/**
 * La classe Panique représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Défaussez la première carte de la Pile d'un joueur. Vous pouvez
 * ensuite jouer une autre carte.".
 */
public class Panique extends Carte {
    /**
     * Constructeur de la classe Panique.
     * Hérite du constructeur de la classe cartes
     */
    public Panique() {
        super("Panique", Couleur.ROUGE,
                "Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer une autre carte.", 1,
                true);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Panique.
     * Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer
     * une autre carte.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Panique va être jouée !");
        Fosse fosse = Partie.getInstance().getFosse();
        Pile pileAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2).getDeck();
        if (pileAdv.size() > 0) {
            fosse.ajouter(pileAdv.piocher());
            joueur.afficher("La carte a été ajouté à la fosse. Veuillez rejouer.");
        } else {
            joueur.afficher("L'adversaire n'avait pas de cartes dans sa pile. Vous pouvez quand même rejouer.");
        }
    }
}
