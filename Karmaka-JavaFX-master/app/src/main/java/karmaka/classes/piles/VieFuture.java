package karmaka.classes.piles;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Pile;

/**
 * La classe VieFuture représente les paquets de cartes associés aux différents
 * joueurs jouant à Karmaka (leurs piles "Vie Future").
 * Elle étend la classe abstraite Pile et utilise une liste d'objets Carte pour
 * stocker les cartes du paquet.
 * 
 * @see Pile
 * @see Carte
 */
public class VieFuture extends Pile {

    /**
     * Constructeur par défaut de la classe VieFuture.
     * Initialise le paquet de cartes en utilisant une liste vide d'objets Carte.
     */
    public VieFuture() {
        super(new ArrayList<Carte>());
    }
}
