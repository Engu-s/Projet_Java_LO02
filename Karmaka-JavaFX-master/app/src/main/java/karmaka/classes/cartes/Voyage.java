package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Deck;
import karmaka.classes.piles.Source;

/**
 * La classe Voyage représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre
 * carte.".
 */
public class Voyage extends Carte {
    /**
     * Constructeur de la classe Voyage.
     * Hérite du constructeur de la classe cartes
     */
    public Voyage() {
        super("Voyage", Couleur.VERT, "Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre carte.", 3,
                true);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Voyage.
     * Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre carte.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Voyage va être jouée !");
        Source source = Partie.getInstance().getSource();
        Deck deck = joueur.getDeck();
        if (source.size() > 0) {
            deck.ajouter(source.piocher(Math.min(3, source.size())));
        } else {
            joueur.afficher("La source est vide.");
        }
    }
}
