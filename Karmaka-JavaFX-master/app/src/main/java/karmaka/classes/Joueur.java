package karmaka.classes;

import java.io.Serializable;
import java.util.ArrayList;

import karmaka.classes.piles.Deck;
import karmaka.classes.piles.Main;
import karmaka.classes.piles.Oeuvres;
import karmaka.classes.piles.VieFuture;

/**
 * La classe abstraite Joueur représente un joueur durant une partie de jeu
 * Karmaka.
 * Chaque joueur possède un nom, une échelle karmique, un nombre d'anneaux
 * karmiques, une main de cartes, un deck, une pile "Vie future", et une pile
 * "Oeuvres".
 * La classe est conçue pour être étendue par des classes spécifiques de
 * joueurs, tels que des joueurs humains ou des robots.
 * Elle implémente l'interface Serializable pour permettre la sérialisation des
 * instances de joueurs.
 *
 * @see Serializable
 */
public abstract class Joueur implements Serializable {

    /** Le nom du joueur. */
    private String nom;

    /** Un indicateur indiquant si le joueur est mort ou non. */
    private boolean mort;

    /** Le niveau actuel sur l'échelle karmique du joueur. */
    private int echelleKarmique;

    /** Le nombre d'anneaux possédés par le joueur. */
    private int nbAnneaux;

    /** La main de cartes du joueur. */
    private Main main;

    /** Le deck du joueur. */
    private Deck deck;

    /** La pile "Vie future" du joueur. */
    private VieFuture vieFuture;

    /** La pile "Oeuvres" du joueur. */
    private Oeuvres oeuvres;

    /**
     * Constructeur de la classe Joueur.
     *
     * @param nom Le nom du joueur.
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.echelleKarmique = 4;
        this.nbAnneaux = 0;
        this.main = new Main();
        this.deck = new Deck();
        this.vieFuture = new VieFuture();
        this.oeuvres = new Oeuvres();
    }

    public Main getMain() {
        return main;
    }

    public int getEchelleKarmique() {
        return echelleKarmique;
    }

    public Deck getDeck() {
        return deck;
    }

    public VieFuture getVieFuture() {
        return vieFuture;
    }

    public Oeuvres getOeuvres() {
        return oeuvres;
    }

    public int getNbAnneaux() {
        return nbAnneaux;
    }

    public void setNbAnneaux(int nbAnneaux) {
        this.nbAnneaux = nbAnneaux;
    }

    public void setEchelleKarmique(int echelleKarmique) {
        this.echelleKarmique = echelleKarmique;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Ajoute un anneau karmique au joueur.
     */
    public void addAnneau() {
        this.nbAnneaux += 1;
    }

    /**
     * Indique si le joueur est mort.
     *
     * @return True si le joueur est mort, sinon False.
     */
    public boolean isMort() {
        return mort;
    }

    public void setMort(boolean mort) {
        this.mort = mort;
    }

    /**
     * Méthode abstraite pour le choix d'une carte par le joueur.
     * Les sous-classes de Joueur devront implémenter cette méthode pour définir le
     * comportement spécifique du choix de carte par le joueur.
     *
     * @param message Le message d'invitation pour le choix.
     * @param cartes  La liste des cartes parmi lesquelles choisir.
     * @return La carte choisie par le joueur.
     */
    abstract public Carte choix(String message, ArrayList<Carte> cartes);

    /**
     * Méthode abstraite pour le choix d'une option par le joueur.
     * Les sous-classes de Joueur devront implémenter cette méthode pour définir le
     * comportement spécifique du choix d'option par le joueur.
     *
     * @param message Le message d'invitation pour le choix d'option.
     * @param options Les options parmi lesquelles choisir.
     * @return L'option choisie par le joueur.
     */
    abstract public String choix(String message, String... options);

    /**
     * Méthode abstraite pour afficher les cartes.
     * Les sous-classes de Joueur devront implémenter cette méthode pour définir le
     * comportement spécifique de l'affichage des cartes par le joueur.
     *
     * @param message Le message à afficher avant les cartes.
     * @param cartes  La liste des cartes à afficher.
     */
    abstract public void afficherCartes(String message, ArrayList<Carte> cartes);

    /**
     * Méthode abstraite pour afficher un message.
     * Les sous-classes de Joueur devront implémenter cette méthode pour définir le
     * comportement spécifique de l'affichage des messages par le joueur.
     *
     * @param message Le message à afficher.
     */
    abstract public void afficher(String message);

    /**
     * Méthode abstraite indiquant si le joueur est un robot.
     * Les sous-classes de Joueur devront implémenter cette méthode pour définir si
     * le joueur est un robot ou non.
     *
     * @return True si le joueur est un robot, sinon False.
     */
    abstract public boolean isRobot();
}
