package karmaka.classes.cartes;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Source;
import karmaka.classes.piles.VieFuture;

/**
 * La classe Destinee représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Regardez les 3 premières cartes de la Source; ajoutez-en jusqu’à
 * 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.".
 */
public class Destinee extends Carte {
    /**
     * Constructeur de la classe Destinee.
     * Hérite du constructeur de la classe cartes.
     */
    public Destinee() {
        super("Destinee", Couleur.BLEU,
                "Regardez les 3 premières cartes de la Source; ajoutez-en jusqu’à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.",
                2, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Destinee.
     * Regardez les 3 premières cartes de la Source; ajoutez-en jusqu’à 2 à votre
     * Vie Future. Replacez le reste dans l'ordre souhaité.
     */
    public void pouvoir() {
        // TODO : tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Destinée va être jouée !");
        Source source = Partie.getInstance().getSource();
        VieFuture vieFuture = joueur.getVieFuture();
        ArrayList<Carte> troisCartes = new ArrayList<Carte>(
                source.getCartes().subList(Math.max(0, source.size() - 3 - 1), source.size() - 1));
        int nbCartes = 0;
        if (troisCartes.size() > 0) {
            joueur.afficherCartes("Voici les 3 premières cartes de la source.", troisCartes);
            String[] possibles;
            if (troisCartes.size() == 1) {
                possibles = new String[] { "1" };
            } else {
                possibles = new String[] { "1", "2" };
            }
            String choix = joueur.choix("Combien de cartes voulez vous defausser de votre main ?", possibles);
            nbCartes = Integer.parseInt(choix);
        } else {
            joueur.afficher("La source est vide");
        }
        for (int i = 0; i < nbCartes; i++) {
            Carte c = joueur.choix("Choisissez la carte à ajouter à votre vie future.",
                    troisCartes);
            vieFuture.ajouter(source.piocher(c));
            troisCartes.remove(c);
        }
        for (int i = 0; i < troisCartes.size(); i++) {
            Carte c = joueur.choix(
                    "Choisissez la carte à replacer dans la source en position " + (i + 1),
                    troisCartes);
            source.ajouter(source.piocher(c));
            troisCartes.remove(c);
        }

    }
}
