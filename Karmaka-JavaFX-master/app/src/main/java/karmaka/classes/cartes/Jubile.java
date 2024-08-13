package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Main;
import karmaka.classes.piles.Oeuvres;

/**
 * La classe Jubile représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Placez jusqu’à 2 cartes de votre Main sur vos Oeuvres.".
 */
public class Jubile extends Carte {
    /**
     * Constructeur de la classe Jubile.
     * Hérite du constructeur de la classe cartes
     */
    public Jubile() {

        super("Jubile", Couleur.VERT, "Placez jusqu’à 2 cartes de votre Main sur vos Oeuvres.", 3, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Jubile.
     * Placez jusqu’à 2 cartes de votre Main sur vos Oeuvres.
     */
    public void pouvoir() {
        // TODO : tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Jubile va être jouée !");
        Main main = joueur.getMain();
        int nbCartes = 0;
        if (main.size() > 0) {
            String[] possibles;
            if (main.size() == 1) {
                possibles = new String[] { "1" };
            } else {
                possibles = new String[] { "1", "2" };
            }
            String choix = joueur.choix("Combien de cartes voulez vous transferer sur vos Oeuvres ? ", possibles);
            nbCartes = Integer.parseInt(choix);
        } else {
            joueur.afficher("Votre main est vide.");
        }
        Oeuvres oeuvres = joueur.getOeuvres();
        for (int i = 0; i < Math.min(nbCartes, main.size()); i++) {
            Carte c = joueur.choix("Choisissez une carte à placer sur vos oeuvres.", main.getCartes());
            oeuvres.ajouter(main.piocher(c));
        }
    }
}
