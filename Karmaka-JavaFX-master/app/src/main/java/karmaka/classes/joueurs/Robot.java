package karmaka.classes.joueurs;

import java.util.ArrayList;

import karmaka.classes.Carte;
import karmaka.classes.Couleur;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.view.Router;

/**
 * La classe Robot représente un joueur automatisé dans un jeu de cartes. Il
 * hérite de la classe Joueur.
 * Il implémente des méthodes spécifiques pour effectuer des choix stratégiques
 * automatisés pendant le jeu.
 * Le robot peut adopter l'une des trois stratégies prédéfinies : AGRESSIF,
 * DEFENSIF, ou FERMIER.
 */
public class Robot extends Joueur {
    /**
     * Enumération représentant les différentes stratégies que le robot peut
     * adopter.
     */
    public enum Strategie {
        AGRESSIF, DEFENSIF, FERMIER
    }

    private Strategie strategie; // La stratégie actuelle du robot.

    /**
     * Constructeur de la classe Robot.
     *
     * @param nom Le nom du robot.
     */
    public Robot(String nom, Strategie strat) {
        super(nom);
        strategie = strat;
    }

    /**
     * Méthode permettant au robot de faire un choix parmi ses cartes disponibles en
     * fonction du message reçu.
     *
     * @param message Le message indiquant le contexte du choix.
     * @param cartes  La liste des cartes parmi lesquelles le robot doit faire son
     *                choix.
     * @return La carte choisie par le robot.
     */
    public Carte choix(String message, ArrayList<Carte> cartes) {
        Carte c = cartes.get(0);
        // Analyse du contexte du message pour déterminer la stratégie appropriée.
        if (message.contains("robot choisit carte main")) {
            switch (strategie) {
                case AGRESSIF:
                    // Choix de la première carte rouge ou de la première carte si aucune carte
                    // rouge n'est disponible.
                    c = cartes.stream().filter(carte -> carte.getCouleur() == Couleur.ROUGE).findFirst()
                            .orElse(cartes.get(0));
                    break;
                case DEFENSIF:
                    // Choix de la première carte bleue ou de la première carte si aucune carte
                    // bleue n'est disponible.
                    c = cartes.stream().filter(carte -> carte.getCouleur() == Couleur.BLEU).findFirst()
                            .orElse(cartes.get(0));
                    break;
                case FERMIER:
                    // Choix de la première carte verte ou de la première carte si aucune carte
                    // verte n'est disponible.
                    c = cartes.stream().filter(carte -> carte.getCouleur() == Couleur.VERT).findFirst()
                            .orElse(cartes.get(0));
                    break;
            }
        }
        return c;
    }

    /**
     * Méthode permettant au robot de faire un choix parmi une liste de chaînes de
     * caractères en fonction du message reçu.
     * Cette méthode est utilisée pour les choix liés aux utilisations des cartes ou
     * à l'acceptation/refus d'une carte.
     *
     * @param message Le message indiquant le contexte du choix.
     * @param choix   Les options parmi lesquelles le robot doit faire son choix.
     * @return La chaîne de caractères représentant le choix du robot.
     */
    public String choix(String message, String... choix) {
        if (message.contains("Veuillez choisir une utilisation pour la carte")) {
            Couleur couleur = Partie.getInstance().getCarteChoisie().getCouleur();
            // Analyse du contexte du message pour déterminer la stratégie appropriée.
            switch (strategie) {
                case AGRESSIF:
                    // Choix de "Pouvoir" si la carte est rouge, sinon choix de "Points".
                    return couleur == Couleur.ROUGE ? "Pouvoir" : "Points";
                case DEFENSIF:
                    // Choix de "Pouvoir" si la carte est bleue, sinon choix de "Points".
                    return couleur == Couleur.BLEU ? "Pouvoir" : "Points";
                case FERMIER:
                    // Choix de "Pouvoir" si la carte est verte, sinon choix de "Points".
                    return couleur == Couleur.VERT ? "Pouvoir" : "Points";
                default:
                    break;
            }
        } else if (message.contains("Le bot adverse va vérifier s'il accepte la carte")) {
            Couleur couleur = Partie.getInstance().getCarteChoisie().getCouleur();
            // Analyse du contexte du message pour déterminer la stratégie appropriée.
            switch (strategie) {
                case AGRESSIF:
                    // Choix de "Accepter" si la carte est rouge, sinon choix de "Refuser".
                    return couleur == Couleur.ROUGE ? "Accepter" : "Refuser";
                case DEFENSIF:
                    // Choix de "Accepter" si la carte est bleue, sinon choix de "Refuser".
                    return couleur == Couleur.BLEU ? "Accepter" : "Refuser";
                case FERMIER:
                    // Choix de "Accepter" si la carte est verte, sinon choix de "Refuser".
                    return couleur == Couleur.VERT ? "Accepter" : "Refuser";
                default:
                    break;
            }
        }
        return choix[(int) (Math.random() * choix.length)];
    }

    /**
     * Méthode permettant au robot d'afficher ses cartes en fonction du message
     * reçu.
     *
     * @param message Le message indiquant le contexte de l'affichage des cartes.
     * @param cartes  La liste des cartes à afficher.
     */
    public void afficherCartes(String message, ArrayList<Carte> cartes) {
        return;
    }

    /**
     * Méthode permettant au robot d'afficher un message en utilisant le Router du
     * jeu.
     *
     * @param message Le message à afficher.
     */
    public void afficher(String message) {
        Router.getInstance().afficher(message);
        return;
    }

    /**
     * Méthode permettant de vérifier si le joueur est un robot.
     *
     * @return true si le joueur est un robot, sinon false.
     */
    public boolean isRobot() {
        return true;
    }
}
