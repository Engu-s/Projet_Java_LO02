package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Fosse;
import karmaka.classes.piles.Main;

/**
 * La classe Deni représente une carte du jeu Karmaka avec le pouvoir spécifique
 * "Défaussez une carte de votre Main. Copiez le pouvoir de cette carte.".
 */
public class Deni extends Carte {
    /**
     * Constructeur de la classe Deni.
     * Hérite du constructeur de la classe cartes.
     */
    public Deni() {
        super("Deni", Couleur.BLEU, "Défaussez une carte de votre Main. Copiez le pouvoir de cette carte.", 2, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Deni.
     * Défaussez une carte de votre Main. Copiez le pouvoir de cette carte.
     */
    public void pouvoir() {
        // TODO : tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Deni va être jouée !");
        Main main = joueur.getMain();
        if (main.size() > 0) {
            Fosse fosse = Partie.getInstance().getFosse();
            Carte c = joueur.choix("Choisissez une carte à défausser.", main.getCartes());
            fosse.ajouter(main.piocher(c));
            c.pouvoir();// Active le pouvoir de la carte défaussée
        } else {
            joueur.afficher("Vous n'avez pas de carte dans votre main.");
        }
    }
}
