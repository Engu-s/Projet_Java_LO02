package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Main;

/**
 * La classe CoupDoeil représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Regardez la Main d’un rival. Vous pouvez ensuite jouer une autre
 * carte.".
 */
public class CoupDoeil extends Carte {
    /**
     * Constructeur de la classe CoupDoeil.
     * Hérite du constructeur de la classe cartes.
     */
    public CoupDoeil() {
        super("CoupDoeil", Couleur.BLEU, "Regardez la Main d’un rival. Vous pouvez ensuite jouer une autre carte.", 1,
                true);
    }

    /**
     * Met en oeuvre le pouvoir de la carte CoupDoeil.
     * Regardez la Main d’un rival. Vous pouvez ensuite jouer une autre carte.
     */
    public void pouvoir() {
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Coup d'oeil va être jouée !");
        Main mainAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2).getMain();
        joueur.afficherCartes("Voici la main de votre adversaire.", mainAdv.getCartes());
    }
}
