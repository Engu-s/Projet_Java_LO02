package karmaka.classes.cartes;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Fosse;
import karmaka.classes.piles.VieFuture;

/**
 * La classe Recyclage représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Ajoutez à votre Vie Future une des 3 dernières cartes de la
 * Fosse.".
 */
public class Recyclage extends Carte {
    /**
     * Constructeur de la classe Recyclage.
     * Hérite du constructeur de la classe cartes
     */
    public Recyclage() {
        super("Recyclage", Couleur.VERT, "Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse.", 1,
                false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Recyclage.
     * Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Recyclage va être jouée !");
        Fosse fosse = Partie.getInstance().getFosse();
        VieFuture vieFuture = joueur.getVieFuture();
        ArrayList<Carte> troisCartes = new ArrayList<Carte>(
                fosse.getCartes().subList(Math.max(0, fosse.size() - 3), fosse.size() - 1));
        if (troisCartes.size() > 0) {
            Carte c = joueur.choix("Choisissez une carte à ajouter à votre vie future.", troisCartes);
            vieFuture.ajouter(fosse.piocher(c));
        } else {
            joueur.afficher("La fosse est vide.");
        }
    }
}
