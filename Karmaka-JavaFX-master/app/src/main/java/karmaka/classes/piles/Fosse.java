package karmaka.classes.piles;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Pile;

/**
 * La classe Fosse représente un paquet de cartes commun à tous les joueurs
 * jouant à Karmaka (la fosse).
 * Elle étend la classe abstraite Pile et utilise une liste d'objets Carte pour
 * stocker les cartes du paquet.
 * 
 * @see Pile
 * @see Carte
 */
public class Fosse extends Pile {
    /**
     * Constructeur par défaut de la classe Fosse.
     * Initialise le paquet de cartes en utilisant une liste vide d'objets Carte.
     */
    public Fosse() {
        super(new ArrayList<Carte>());
    }
}
