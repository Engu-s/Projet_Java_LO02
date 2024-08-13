package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Fosse;
import karmaka.classes.piles.Main;

import java.util.Random;

/**
 * La classe Bassesse représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Défaussez au hasard 2 cartes de la Main d’un rival.".
 */
public class Bassesse extends Carte {
    /**
     * Constructeur de la classe Bassesse.
     * Hérite du constructeur de la classe cartes.
     */
    public Bassesse() {
        super("Bassesse", Couleur.ROUGE, "Défaussez au hasard 2 cartes de la Main d’un rival.", 3, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Bassesse.
     * Défausse au hasard deux cartes de la main d'un rival.
     */
    public void pouvoir() {
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Bassesse va être jouée !");
        Random random = new Random();
        Main mainAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2).getMain();
        int nbCartesAdv = mainAdv.size();
        Fosse fosse = Partie.getInstance().getFosse();
        for (int i = 0; i < Math.min(2, mainAdv.size()); i++) {
            Carte cartePioche = mainAdv.getCartes().get(random.nextInt(mainAdv.size()));
            fosse.ajouter(mainAdv.piocher(cartePioche));
        }
        if (nbCartesAdv >= 2) {
            joueur.afficher("2 cartes de la main de l'adversaire ont été défaussées !");
        } else if (nbCartesAdv == 1) {
            joueur.afficher("1 carte de la main de l'adversaire a été défaussée !");
        } else {
            joueur.afficher("Votre adversaire n'avait aucune carte à se défausser !");
        }
    }
}
