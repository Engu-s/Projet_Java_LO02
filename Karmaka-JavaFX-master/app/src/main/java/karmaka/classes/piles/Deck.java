package karmaka.classes.piles;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Pile;

/**
 * La classe Deck représente les paquets de cartes associés aux différents
 * joueurs jouant à Karmaka (leurs pioches).
 * Elle étend la classe abstraite Pile et utilise une liste d'objets Carte pour
 * stocker les cartes du paquet.
 * 
 * @see Pile
 * @see Carte
 */
public class Deck extends Pile {
    /**
     * Constructeur par défaut de la classe Deck.
     * Initialise le paquet de cartes en utilisant une liste vide d'objets Carte.
     */
    public Deck() {
        super(new ArrayList<Carte>());
    }
}
