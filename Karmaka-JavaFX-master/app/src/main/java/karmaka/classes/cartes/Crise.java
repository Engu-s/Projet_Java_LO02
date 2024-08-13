package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Fosse;
import karmaka.classes.piles.Oeuvres;
import karmaka.view.Router;

/**
 * La classe Crise représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Le rival de votre choix défausse une de ses Oeuvres.".
 */
public class Crise extends Carte {
    /**
     * Constructeur de la classe Crise.
     * Hérite du constructeur de la classe cartes.
     */
    public Crise() {
        super("Crise", Couleur.ROUGE, "Le rival de votre choix défausse une de ses Oeuvres.", 2, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Crise.
     * Le rival de votre choix défausse une de ses Oeuvres.
     */
    public void pouvoir() {
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        Joueur joueurAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2);
        joueur.afficher("La carte Crise va être jouée !");
        Oeuvres oeuvresAdv = joueurAdv.getOeuvres();
        Fosse fosse = Partie.getInstance().getFosse();
        if (oeuvresAdv.size() > 0) {
            Router.getInstance().setScene("plateauPlaceholder");
            joueur.afficher("Laissez votre adversaire choisir une carte à défausser.");
            Carte carte = joueurAdv.choix("Veuillez choisir une carte à défausser de vos oeuvres.",
                    oeuvresAdv.getCartes());
            fosse.ajouter(oeuvresAdv.piocher(carte));
            joueurAdv.afficher("Une carte a été défaussée ! Redonnez la main à votre adversaire.");
            Router.getInstance().setScene("plateau");
        } else {
            joueur.afficher("L'adversaire n'a pas d'oeuvres.");
        }
    }
}
