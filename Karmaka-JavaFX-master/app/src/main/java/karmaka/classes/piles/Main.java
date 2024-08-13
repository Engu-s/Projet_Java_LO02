package karmaka.classes.piles;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Pile;

/**
 * La classe Main représente une liste de cartes associés aux mains des
 * différents joueurs jouant à Karmaka.
 * Elle étend la classe abstraite Pile et utilise une liste d'objets Carte pour
 * stocker les cartes du paquet.
 * 
 * @see Pile
 * @see Carte
 */
public class Main extends Pile {

    /**
     * Constructeur par défaut de la classe Main.
     * Initialise le paquet de cartes en utilisant une liste vide d'objets Carte.
     */
    public Main() {
        super(new ArrayList<Carte>());
    }
}
