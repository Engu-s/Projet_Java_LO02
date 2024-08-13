package karmaka.classes.cartes;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Fosse;
import karmaka.classes.piles.Main;

/**
 * La classe Sauvetage représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Ajoutez à votre Main une des 3 dernières cartes de la Fosse.".
 */
public class Sauvetage extends Carte {
    /**
     * Constructeur de la classe Sauvetage.
     * Hérite du constructeur de la classe cartes
     */
    public Sauvetage() {
        super("Sauvetage", Couleur.VERT, "Ajoutez à votre Main une des 3 dernières cartes de la Fosse.", 2, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Sauvetage.
     * Ajoutez à votre Main une des 3 dernières cartes de la Fosse.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Sauvetage va être jouée !");
        Fosse fosse = Partie.getInstance().getFosse();
        Main main = joueur.getMain();
        ArrayList<Carte> troisCartes = new ArrayList<Carte>(
                fosse.getCartes().subList(Math.max(0, fosse.size() - 3 - 1), fosse.size() - 1));
        if (troisCartes.size() > 0) {
            Carte c = joueur.choix("Choisissez une carte à ajouter à votre main.", troisCartes);
            main.ajouter(fosse.piocher(c));
        } else {
            System.out.println("La fosse est vide.");
        }
    }
}
