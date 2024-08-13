package karmaka.classes.cartes;

import java.util.ArrayList;
import java.util.Random;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Main;

/**
 * La classe Duperie représente une carte du jeu Karmaka avec le pouvoir
 * spécifique "Regardez 3 cartes de la Main d’un rival; ajoutez-en une à votre
 * Main.".
 */
public class Duperie extends Carte {
    /**
     * Constructeur de la classe Duperie.
     * Hérite du constructeur de la classe cartes.
     */
    public Duperie() {
        super("Duperie", Couleur.BLEU, "Regardez 3 cartes de la Main d’un rival; ajoutez-en une à votre Main.", 3,
                false);
    }

    /**
     * Met en oeuvre le pouvoir de la carte Duperie.
     * Regardez 3 cartes de la Main d’un rival; ajoutez-en une à votre Main.
     */
    public void pouvoir() {
        // TODO: tester
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        joueur.afficher("La carte Duperie va être jouée !");
        Random random = new Random();
        Main mainAdv = Partie.getInstance().getJoueur((Partie.getInstance().getTour() + 1) % 2).getMain();
        Main main = joueur.getMain();
        ArrayList<Integer> randomPrec = new ArrayList<Integer>();
        ArrayList<Carte> carteTemp = new ArrayList<Carte>();
        for (int i = 0; i < Math.min(3, mainAdv.size()); i++) {
            int newRandom = random.nextInt(mainAdv.size());
            while (randomPrec.contains(newRandom)) {
                newRandom = random.nextInt(mainAdv.size());
            }
            randomPrec.add(newRandom);
            carteTemp.add(mainAdv.getCartes().get(newRandom));
        }
        if (carteTemp.size() > 0) {
            Carte c = joueur.choix("Voici les cartes aléatoires de la main de votre adversaire, choisissez-en une.",
                    carteTemp);
            main.ajouter(mainAdv.piocher(c));
            joueur.afficher("La carte a été ajoutée à votre main.");
        } else {
            joueur.afficher("L'adversaire n'a pas de carte dans sa main !");
        }
    }
}
