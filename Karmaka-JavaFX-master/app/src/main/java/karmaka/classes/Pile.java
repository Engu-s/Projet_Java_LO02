package karmaka.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * La classe abstraite Pile représente une pile de cartes dans le jeu Karmaka.
 * Elle contient des méthodes pour mélanger les cartes, piocher des cartes,
 * ajouter des cartes à la pile, etc.
 * Cette classe est conçue pour être étendue par des classes spécifiques de
 * piles, telles que Deck, Main, VieFuture, Oeuvres, etc.
 * Elle implémente l'interface Serializable pour permettre la sérialisation des
 * instances de piles.
 *
 * @see Serializable
 */
public abstract class Pile implements Serializable {

    /** La liste des cartes dans la pile. */
    private ArrayList<Carte> cartes;

    /**
     * Constructeur de la classe Pile.
     *
     * @param cartesInit La liste initiale des cartes dans la pile.
     */
    public Pile(ArrayList<Carte> cartesInit) {
        cartes = cartesInit;
    }

    /**
     * Mélange les cartes dans la pile de manière aléatoire.
     */
    public void melanger() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = cartes.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Carte a = cartes.get(index);
            cartes.set(index, cartes.get(i));
            cartes.set(i, a);
        }
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    /**
     * Pioche un nombre spécifié de cartes de la pile.
     *
     * @param qte Le nombre de cartes à piocher.
     * @return La liste des cartes piochées.
     */
    public ArrayList<Carte> piocher(int qte) {
        ArrayList<Carte> cartesPiochees = new ArrayList<Carte>();
        int iMax = qte <= cartes.size() ? qte : cartes.size() - 1;
        for (int i = 0; i < iMax; i++) {
            cartesPiochees.add(cartes.remove(cartes.size() - 1));
        }
        return cartesPiochees;
    }

    /**
     * Pioche une carte de la pile.
     *
     * @return La carte piochée, ou null si la pile est vide.
     */
    public Carte piocher() {
        return cartes.size() != 0 ? cartes.remove(cartes.size() - 1) : null;
    }

    /**
     * Pioche une carte spécifique de la pile.
     *
     * @param c La carte à piocher.
     * @return La carte piochée, ou null si la carte n'est pas présente dans la
     *         pile.
     */
    public Carte piocher(Carte c) {
        boolean sup = cartes.remove(c);
        return sup ? c : null;
    }

    /**
     * Ajoute une liste de cartes à la pile.
     *
     * @param cartesAjoutees La liste des cartes à ajouter.
     */
    public void ajouter(ArrayList<Carte> cartesAjoutees) {
        cartes.addAll(cartesAjoutees);
    }

    /**
     * Ajoute une carte à la pile.
     *
     * @param c La carte à ajouter.
     */
    public void ajouter(Carte c) {
        cartes.add(c);
    }

    /**
     * Retourne le nombre de cartes possédé par une pile désignée.
     *
     * @return Le nombre de cartes possédé par la pile désignée.
     */
    public int size() {
        return cartes.size();
    }
}
