package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Oeuvres;

/**
 * La classe Mimetisme représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée.".
 */
public class Mimetisme extends Carte {
    /**
     * Constructeur de la classe Mimetisme.
     * Hérite du constructeur de la classe cartes
     */
    public Mimetisme() {

        super("Mimetisme", Couleur.MOSAIQUE, "Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée.", 1, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Mimetisme.
     * Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée.
     */
    public void pouvoir() {
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Mimetisme va être jouée !");
        Oeuvres oeuvresAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2).getOeuvres();
        if (oeuvresAdv.size() > 0) {
            joueur.afficher("Vous copiez l'oeuvre exposée de votre adversaire !");
            Carte c = oeuvresAdv.getCartes().get(oeuvresAdv.size() - 1);
            c.pouvoir();
        } else {
            joueur.afficher("L'adversaire n'avait pas de cartes dans ses oeuvres.");
        }
    }
}
