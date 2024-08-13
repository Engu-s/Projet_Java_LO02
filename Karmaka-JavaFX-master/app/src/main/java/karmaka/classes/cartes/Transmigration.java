package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Main;
import karmaka.classes.piles.VieFuture;

/**
 * La classe Transmigration représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Placez dans votre Main n’importe quelle carte de votre Vie
 * Future.".
 */
public class Transmigration extends Carte {
    /**
     * Constructeur de la classe Transmigration.
     * Hérite du constructeur de la classe cartes
     */
    public Transmigration() {
        super("Transmigration", Couleur.BLEU, "Placez dans votre Main n’importe quelle carte de votre Vie Future.", 1,
                false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Transmigration.
     * Placez dans votre Main n’importe quelle carte de votre Vie Future.
     */
    public void pouvoir() {
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Transmigration va être jouée !");
        VieFuture vieFuture = joueur.getVieFuture();
        Main main = joueur.getMain();
        if (vieFuture.size() != 0) {
            Carte choix = joueur.choix("Veuillez choisir une carte dans votre Vie Future.",
                    vieFuture.getCartes());
            main.ajouter(vieFuture.piocher(choix));
        } else {
            joueur.afficher("Il n'y a pas de cartes dans votre vie future.");
        }
    }
}
