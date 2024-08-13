package karmaka.classes;

import java.io.Serializable;
import java.util.ArrayList;

import karmaka.classes.Partie.Etape;
import karmaka.classes.piles.Fosse;
import karmaka.classes.piles.Source;

/**
 * La classe {@code GameData} représente la structure de données contenant
 * l'état d'une partie de Karmaka.
 * Elle inclut des informations sur les joueurs, les éléments du jeu, les
 * actions disponibles et l'état actuel de la partie.
 *
 * <p>
 * Cette classe implémente l'interface {@code Serializable} pour permettre la
 * sérialisation des objets.
 * </p>
 */
public class GameData implements Serializable {

    /** Un tableau contenant les 2 joueurs participant à la partie. */
    public Joueur[] joueurs = new Joueur[2];

    /**
     * La pile commune "Source" contenant les cartes disponibles pour les joueurs.
     * Elle leur sert majoritairement de pioche.
     */
    public Source source = new Source();

    /** La pile commune "Fosse" où les cartes défaussées sont placées. */
    public Fosse fosse = new Fosse();

    /**
     * La liste des actions possibles que les joueurs peuvent effectuer pendant leur
     * tour.
     */
    public ArrayList<Action> actionsPossibles = new ArrayList<Action>();

    /** Le tour du joueur actuel (0 pour le joueur 1, 1 pour le joueur 2). */
    public int tour = 0;

    /** L'index du joueur gagnant, si la partie est terminée. */
    public int gagnant;

    /**
     * L'étape actuelle de la partie (est initialisée à l'étape DEBUT et
     * s'actualisera au cours des tours de jeux).
     */
    public Etape etape = Etape.DEBUT;

    /** La carte désignée par un joueur dans l'interface graphique. */
    public Carte carteChoisie = null;
}
