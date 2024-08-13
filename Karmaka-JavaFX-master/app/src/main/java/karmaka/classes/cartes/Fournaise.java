package karmaka.classes.cartes;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Fosse;
import karmaka.classes.piles.VieFuture;

/**
 * La classe Fournaise représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Défaussez les 2 premières cartes de la Vie Future d'un rival.".
 */
public class Fournaise extends Carte {
    /**
     * Constructeur de la classe Fournaise.
     * Hérite du constructeur de la classe cartes.
     */
    public Fournaise() {
        super("Fournaise", Couleur.ROUGE, "Défaussez les 2 premières cartes de la Vie Future d'un rival.", 2, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Fournaise.
     * Défaussez les 2 premières cartes de la Vie Future d'un rival.
     */
    public void pouvoir() {
        // TODO : tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Fournaise va être jouée !");
        VieFuture vieFutureAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2)
                .getVieFuture();
        Fosse fosse = Partie.getInstance().getFosse();
        if (vieFutureAdv.size() > 0) {
            ArrayList<Carte> cartes = vieFutureAdv.piocher(Math.min(2, vieFutureAdv.size()));
            fosse.ajouter(cartes);
        } else {
            joueur.afficher("L'adversaire n'a pas de carte dans sa vie future !");
        }
    }
}
