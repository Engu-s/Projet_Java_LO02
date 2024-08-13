package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Deck;
import karmaka.classes.piles.Source;

/**
 * La classe Longevite représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Placez 2 cartes puisées à la Source sur la Pile d'un joueur.".
 */
public class Longevite extends Carte {
    /**
     * Constructeur de la classe Longevite.
     * Hérite du constructeur de la classe cartes
     */
    public Longevite() {

        super("Longevite", Couleur.VERT, "Placez 2 cartes puisées à la Source sur la Pile d'un joueur.", 2, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Longevite.
     * Placez 2 cartes puisées à la Source sur la Pile d'un joueur.
     */
    public void pouvoir() {
        // TODO : tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Longévité va être jouée !");
        Source source = Partie.getInstance().getSource();
        String choixJoueur = joueur.choix(
                "Choisissez le joueur sur lequel vous allez placez les 2 cartes de la source", "Adversaire", "Moi");
        if (choixJoueur == "Adverdaire") {
            Deck deckAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2).getDeck();
            deckAdv.ajouter(source.piocher(Math.min(2, source.size())));
        } else {
            Deck deck = joueur.getDeck();
            deck.ajouter(source.piocher(Math.min(2, source.size())));
        }
        joueur.afficher("Les cartes ont étés ajoutées à la pile du Joueur !");
    }
}
