package karmaka.classes.piles;

import java.util.ArrayList;
import java.util.Arrays;

import karmaka.classes.Carte;
import karmaka.classes.Partie;
import karmaka.classes.Pile;
import karmaka.classes.cartes.*;

/**
 * La classe Source représente un paquet de cartes commun à tous les joueurs
 * jouant à Karmaka (la source).
 * Elle étend la classe abstraite Pile et utilise une liste d'objets Carte pour
 * stocker les cartes du paquet.
 * La classe contient une liste statique d'objets Carte initiaux qui sont
 * mélangés lors de la création d'une instance de Source.
 * Les cartes initiales comprennent des instances de différentes cartes telles
 * que Transmigration, CoupDoeil, RevesBrises, etc.
 * 
 * @see Pile
 * @see Carte
 */
public class Source extends Pile {

    /**
     * Liste statique de cartes initiales représentant le contenu de la source au
     * début de la partie.
     * Chaque type de carte est ajouté en plusieurs exemplaires à la liste.
     */
    static ArrayList<Carte> cartesInit = new ArrayList<Carte>(Arrays.asList(
            new Transmigration(),
            new Transmigration(),
            new Transmigration(),
            new CoupDoeil(),
            new CoupDoeil(),
            new CoupDoeil(),
            new RevesBrises(),
            new RevesBrises(),
            new RevesBrises(),
            new Deni(),
            new Deni(),
            new Deni(),
            new Vol(),
            new Vol(),
            new Lendemain(),
            new Lendemain(),
            new Lendemain(),
            new Sauvetage(),
            new Sauvetage(),
            new Sauvetage(),
            new Longevite(),
            new Longevite(),
            new Longevite(),
            new Voyage(),
            new Voyage(),
            new Jubile(),
            new Jubile(),
            new DernierSouffle(),
            new DernierSouffle(),
            new DernierSouffle(),
            new Crise(),
            new Crise(),
            new Crise(),
            new Fournaise(),
            new Fournaise(),
            new Fournaise(),
            new Vengeance(),
            new Vengeance(),
            new Incarnation(),
            new Incarnation(),
            new Incarnation(),
            new Incarnation(),
            new Incarnation(),
            new Mimetisme(),
            new Mimetisme(),
            new Destinee(),
            new Destinee(),
            new Destinee(),
            new Duperie(),
            new Duperie(),
            new Recyclage(),
            new Recyclage(),
            new Recyclage(),
            new Semis(),
            new Semis(),
            new Semis(),
            new Panique(),
            new Panique(),
            new Panique(),
            new Roulette(),
            new Roulette(),
            new Roulette(),
            new Bassesse(),
            new Bassesse()));

    /**
     * Constructeur de la classe Source. Initialise la Source avec les cartes
     * initiales et les mélange.
     */
    public Source() {
        super(cartesInit);
        melanger();
    }

    public void realimenter() {
        Fosse fosse = Partie.getInstance().getFosse();
        super.ajouter(fosse.piocher(fosse.size()));
        super.melanger();

    }

    /**
     * Pioche un nombre spécifié de cartes de la pile.
     *
     * @param qte Le nombre de cartes à piocher.
     * @return La liste des cartes piochées.
     */
    @Override
    public ArrayList<Carte> piocher(int qte) {
        if (super.getCartes().size() - qte < 0) {
            realimenter();
        }
        ArrayList<Carte> cartesPiochees = new ArrayList<Carte>();
        int iMax = qte <= super.getCartes().size() ? qte : super.getCartes().size() - 1;
        for (int i = 0; i < iMax; i++) {
            cartesPiochees.add(super.getCartes().remove(super.getCartes().size() - 1));
        }
        return cartesPiochees;
    }

    /**
     * Pioche une carte de la pile.
     *
     * @return La carte piochée, ou null si la pile est vide.
     */
    @Override
    public Carte piocher() {
        if (super.getCartes().size() == 0) {
            realimenter();
        }
        return super.getCartes().size() != 0 ? super.getCartes().remove(super.getCartes().size() - 1) : null;
    }

    /**
     * Pioche une carte spécifique de la pile.
     *
     * @param c La carte à piocher.
     * @return La carte piochée, ou null si la carte n'est pas présente dans la
     *         pile.
     */
    @Override
    public Carte piocher(Carte c) {
        if (super.getCartes().size() == 0) {
            realimenter();
        }
        boolean sup = super.getCartes().remove(c);
        return sup ? c : null;
    }
}
