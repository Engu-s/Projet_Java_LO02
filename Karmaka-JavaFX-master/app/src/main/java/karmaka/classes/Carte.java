package karmaka.classes;

import java.io.Serializable;

/**
 * La classe abstraite Carte représente une carte générique présente dans le jeu
 * Karmaka.
 * Chaque carte a un nom, une couleur, une description, un nombre de points, et
 * un pouvoir spécifique.
 * Cette classe est conçue pour être étendue par des classes spécifiques de
 * cartes qui implémentent des pouvoirs uniques.
 * Elle implémente l'interface Serializable pour permettre la sérialisation des
 * instances de cartes.
 * 
 * @see Serializable
 */
public abstract class Carte implements Serializable {

    /** Le nom de la carte. */
    private String nom;

    /** La couleur de la carte. */
    private Couleur couleur;

    /** La description de la carte. */
    private String description;

    /** Le nombre de points de la carte. */
    private int points;

    /** Un indicateur indiquant si le joueur va rejouer après la carte ou non. */
    private boolean rejouer;

    /**
     * Constructeur de la classe Carte.
     *
     * @param nom         Le nom de la carte.
     * @param couleur     La couleur de la carte.
     * @param description La description de la carte.
     * @param points      Le nombre de points de la carte.
     * @param rejouer     Un indicateur indiquant si le joueur va rejouer après la
     *                    carte ou non.
     */
    public Carte(String nom, Couleur couleur, String description, int points, boolean rejouer) {
        this.nom = nom;
        this.couleur = couleur;
        this.description = description;
        this.points = points;
        this.rejouer = rejouer;
    }

    public String getNom() {
        return nom;
    }

    public int getPoints() {
        return points;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public boolean getRejouer() {
        return rejouer;
    }

    /**
     * Méthode abstraite définissant les pouvoirs de toutes les cartes du jeu
     * Karmaka.
     * Les sous-classes de Carte devront implémenter cette méthode pour définir le
     * comportement spécifique de chaque carte.
     */
    public abstract void pouvoir();
}
