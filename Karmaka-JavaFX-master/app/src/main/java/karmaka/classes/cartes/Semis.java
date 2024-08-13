package karmaka.classes.cartes;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Main;
import karmaka.classes.piles.Source;
import karmaka.classes.piles.VieFuture;

/**
 * La classe Semis représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2
 * cartes de votre Main.".
 */
public class Semis extends Carte {
    /**
     * Constructeur de la classe Semis.
     * Hérite du constructeur de la classe cartes
     */
    public Semis() {
        super("Semis", Couleur.VERT,
                "Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main.", 2, false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Semis.
     * Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de
     * votre Main.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Semis va être jouée !");
        Source source = Partie.getInstance().getSource();
        if (source.size() > 0) {
            source.piocher(Math.min(2, source.size()));
            joueur.afficher("Les cartes ont été puisées.");
        } else {
            joueur.afficher("La source est vide.");
        }
        Main main = joueur.getMain();
        VieFuture vieFuture = joueur.getVieFuture();
        if (main.size() > 0) {
            Carte choix = joueur.choix(
                    "Veuillez choisir une première carte dans votre main à mettre sur votre vie future.",
                    main.getCartes());
            vieFuture.ajouter(main.piocher(choix));
            if (main.size() > 0) {
                choix = joueur.choix(
                        "Veuillez choisir une deuxième carte dans votre main à mettre sur votre vie future.",
                        main.getCartes());
                vieFuture.ajouter(main.piocher(choix));
            } else {
                joueur.afficher("Il n'y a plus de cartes dans votre main.");
            }
        } else {
            joueur.afficher("Il n'y a pas de cartes dans votre main.");
        }
    }
}
