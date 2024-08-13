package karmaka.classes.joueurs;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Joueur;
import karmaka.view.Router;

/**
 * La classe {@code Humain} représente un joueur humain dans le jeu Karmaka.
 * Elle hérite de la classe {@code Joueur} et implémente les méthodes
 * spécifiques aux interactions d'un joueur humain.
 *
 * <p>
 * Cette classe utilise le gestionnaire de routage {@code Router} pour gérer les
 * interactions utilisateur.
 * </p>
 */
public class Humain extends Joueur {

    /**
     * Constructeur de la classe {@code Humain}.
     *
     * @param nom Le nom du joueur humain.
     */
    public Humain(String nom) {
        super(nom);
    }

    /**
     * Permet au joueur humain de choisir parmi une liste de cartes.
     *
     * @param message Le message d'instruction pour le choix.
     * @param cartes  La liste de cartes parmi lesquelles le joueur doit choisir.
     * @return La carte choisie par le joueur.
     */
    public Carte choix(String message, ArrayList<Carte> cartes) {
        return Router.getInstance().choix(message, cartes);
    }

    /**
     * Permet au joueur humain de faire un choix parmi plusieurs options.
     *
     * @param message Le message d'instruction pour le choix.
     * @param choix   Les options parmi lesquelles le joueur doit choisir.
     * @return La chaîne représentant le choix du joueur.
     */
    public String choix(String message, String... choix) {
        return Router.getInstance().choix(message, choix);
    }

    /**
     * Affiche les cartes fournies au joueur humain.
     *
     * @param message Le message d'instruction pour l'affichage.
     * @param cartes  La liste de cartes à afficher.
     */
    public void afficherCartes(String message, ArrayList<Carte> cartes) {
        Router.getInstance().afficherCartes(message, cartes);
    }

    /**
     * Affiche un message au joueur humain.
     *
     * @param message Le message à afficher.
     */
    public void afficher(String message) {
        Router.getInstance().afficher(message);
    }

    /**
     * Indique que le joueur en question n'est pas un robot.
     *
     * @return {@code false} car le joueur est humain, pas un robot.
     */
    public boolean isRobot() {
        return false;
    }
}
