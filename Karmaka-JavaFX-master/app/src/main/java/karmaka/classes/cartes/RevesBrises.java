package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.VieFuture;

/**
 * La classe RevesBrises représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Placez la première carte de la Vie Future d'un rival sur la
 * vôtre.".
 */
public class RevesBrises extends Carte {
    /**
     * Constructeur de la classe RevesBrises.
     * Hérite du constructeur de la classe cartes
     */
    public RevesBrises() {
        super("RevesBrises", Couleur.BLEU, "Placez la première carte de la Vie Future d'un rival sur la vôtre.", 2,
                false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte RevesBrises.
     * Placez la première carte de la Vie Future d'un rival sur la vôtre.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Rêves Brisés va être jouée !");
        VieFuture vieFutureAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2)
                .getVieFuture();
        VieFuture vieFuture = joueur.getVieFuture();
        if (vieFutureAdv.size() > 0) {
            vieFuture.ajouter(vieFutureAdv.piocher());
            joueur.afficher("La carte a été ajouté à votre vie future.");
        } else {
            joueur.afficher("L'adversaire n'avait pas de cartes dans sa vie future.");
        }
    }
}
