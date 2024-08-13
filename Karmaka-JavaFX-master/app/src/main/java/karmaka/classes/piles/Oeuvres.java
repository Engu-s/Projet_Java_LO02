package karmaka.classes.piles;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Pile;

/**
 * La classe Oeuvres représente les paquets de cartes associés aux différents
 * joueurs jouant à Karmaka (leurs packets Oeuvres).
 * Elle étend la classe abstraite Pile et utilise une liste d'objets Carte pour
 * stocker les cartes du paquet.
 * 
 * @see Pile
 * @see Carte
 */
public class Oeuvres extends Pile {

    /**
     * Constructeur par défaut de la classe Oeuvres.
     * Initialise le paquet de cartes en utilisant une liste vide d'objets Carte.
     */
    public Oeuvres() {
        super(new ArrayList<Carte>());
    }

    /**
     * Calcule et retourne le nombre total de points associés aux cartes du joueur.
     * Les points sont attribués en fonction de la couleur des cartes et de leurs
     * valeurs.
     * Les couleurs sont représentées par des constantes : 0 pour Rouge, 1 pour
     * Vert, 2 pour Bleu, 3 pour Mosaique.
     * Les points sont cumulés par couleur et on conserve celle ayant accumulé le
     * plus de points.
     * On note ce résultat et on y ajoutant les points de la couleur Mosaique. Ce
     * résultat correspond aux points obtenus par le joueur.
     *
     * @return Le nombre total de points calculé à partir des cartes du joueur.
     */
    public int calculerPoints() {
        // 0: Rouge, 1: Vert, 2: Bleu, 3: Mosaique
        int[] points = { 0, 0, 0, 0 };
        for (Carte c : super.getCartes()) {
            points[c.getCouleur().ordinal()] += c.getPoints();
        }
        return Math.max(points[0], Math.max(points[1], points[2])) + points[3];
    }
}
