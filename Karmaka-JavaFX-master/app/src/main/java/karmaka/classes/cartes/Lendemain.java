package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Deck;
import karmaka.classes.piles.Source;

/**
 * La classe Lendemain représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Puisez une carte à la Source. Vous pouvez ensuite jouer une autre
 * carte.".
 */
public class Lendemain extends Carte {
    /**
     * Constructeur de la classe Lendemain.
     * Hérite du constructeur de la classe cartes
     */
    public Lendemain() {

        super("Lendemain", Couleur.VERT, "Puisez une carte à la Source. Vous pouvez ensuite jouer une autre carte.", 1,
                true);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Lendemain.
     * Puisez une carte à la Source. Vous pouvez ensuite jouer une autre carte.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Lendemain va être jouée !");
        Source source = Partie.getInstance().getSource();
        Deck deck = joueur.getDeck();
        if (source.size() > 0) {
            deck.ajouter(source.piocher());
        } else {
            System.out.println("La source est vide.");
        }
        joueur.afficher("Vous pouvez rejouer.");
    }
}
