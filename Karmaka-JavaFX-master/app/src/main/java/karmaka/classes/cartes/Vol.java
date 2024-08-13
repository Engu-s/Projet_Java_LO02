package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Main;
import karmaka.classes.piles.Oeuvres;

/**
 * La classe Vol représente une carte du jeu Karmaka avec le pouvoir spécifique
 * "Placez dans votre Main l’Oeuvre Exposée d'un rival.".
 */
public class Vol extends Carte {
    /**
     * Constructeur de la classe Vol.
     * Hérite du constructeur de la classe cartes
     */
    public Vol() {
        super("Vol", Couleur.BLEU, "Placez dans votre Main l’Oeuvre Exposée d'un rival.", 3, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Vol.
     * Placez dans votre Main l’Oeuvre Exposée d'un rival.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Vol va être jouée !");
        Oeuvres oeuvresAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2).getOeuvres();
        Main main = joueur.getMain();
        if (oeuvresAdv.size() > 0) {
            Carte c = joueur.choix("Choisissez une carte parmis les oeuvres de votre adversaire.",
                    oeuvresAdv.getCartes());
            main.ajouter(oeuvresAdv.piocher(c));
        } else {
            joueur.afficher("Votre adversaire n'a pas d'oeuvres.");
        }
    }
}
