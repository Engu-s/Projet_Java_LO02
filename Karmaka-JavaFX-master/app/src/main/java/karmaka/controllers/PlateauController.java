package karmaka.controllers;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import karmaka.classes.Action;
import karmaka.classes.Carte;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.piles.Deck;
import karmaka.classes.piles.Fosse;
import karmaka.view.CarteView;
import karmaka.view.Router;

/**
 * La classe PlateauController gère les actions et les interactions de
 * l'interface utilisateur
 * pour la scène du plateau de jeu du jeu Karmaka.
 */
public class PlateauController implements Initializable {
    // Cards dimensions are 115x160
    @FXML
    private ImageView source, fosse, adversaireDeck, adversaireVieFuture, vieFuture, deck;

    @FXML
    private Text adversaireVieFutureQte, adversaireDeckQte, sourceQte, fosseQte, deckQte, vieFutureQte,
            adversaireAnneaux, anneaux;

    @FXML
    private HBox main, oeuvres, adversaireOeuvres;

    @FXML
    private Button passer, suivantRobot;

    /**
     * Gère l'action du bouton "Passer" pour passer au tour suivant si l'action est
     * possible.
     */
    @FXML
    public void handlePasser() {
        ArrayList<Action> actionsPossibles = Partie.getInstance().getActionsPossibles();
        Joueur joueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour());
        if (actionsPossibles.contains(Action.PASSER)) {
            Partie.getInstance().setEtape(Partie.Etape.TOUR_SUIVANT);
            Partie.getInstance().tour();
        } else {
            joueur.afficher("Vous ne pouvez pas passer votre tour. Vous n'avez sans doute pas encore pioché de carte.");
        }
    }

    @FXML
    public void handleSuivantRobot() {
        ArrayList<Action> actionsPossibles = Partie.getInstance().getActionsPossibles();
        if (actionsPossibles.contains(Action.TOUR_SUIVANT_ROBOT)) {
            Partie.getInstance().tour();
        }
    }

    /**
     * Gère l'action du bouton "Échelle" pour afficher la scène de l'échelle
     * karmique.
     */
    @FXML
    public void handleEchelleButton() {
        Router.getInstance().setScene("echelle");
    }

    /**
     * Gère l'action du bouton "Deck" pour piocher une carte du deck si l'action est
     * possible.
     */
    @FXML
    public void handleDeck() {
        ArrayList<Action> actionsPossibles = Partie.getInstance().getActionsPossibles();
        System.out.println(actionsPossibles);
        if (actionsPossibles.contains(Action.PIOCHER_DECK)) {
            Partie.getInstance().tour();
        }
    }

    /**
     * Gère l'action du bouton "Sauvegarder" pour sauvegarder l'état actuel de la
     * partie.
     */
    @FXML
    public void handleSave() {
        Partie.getInstance().sauvegarder();
    }

    /**
     * Gère l'action du bouton "Charger" pour charger une partie sauvegardée.
     */
    @FXML
    public void handleLoad() {
        Partie.getInstance().charger();
    }

    @FXML
    public void handleQuit() {
        Platform.exit();
        System.exit(0);
    }

    /**
     * Gère le clic sur une carte dans la main du joueur.
     *
     * @param c La carte sur laquelle le joueur a cliqué.
     */
    private void handleMouseClicked(Carte c) {
        ArrayList<Action> actionsPossibles = Partie.getInstance().getActionsPossibles();
        System.out.println(actionsPossibles);
        // Si on peut choisir une carte de la main et si cette carte est dans la main.
        if (actionsPossibles.contains(Action.CHOISIR_CARTE_MAIN)
                && Partie.getInstance().getJoueur(Partie.getInstance().getTour()).getMain().getCartes().contains(c)) {
            Partie.getInstance().setCarteChoisie(c);
            Partie.getInstance().tour();
        }
    }

    /**
     * Initialise la disposition des cartes de la main du joueur actuel sur
     * l'interface graphique.
     */
    private void initMain() {
        Partie partie = Partie.getInstance();
        partie.getJoueur(partie.getTour()).getMain().getCartes().iterator()
                .forEachRemaining(c -> {
                    ImageView tempView = new CarteView(c);
                    tempView.setOnMouseClicked(e -> {
                        handleMouseClicked(c);
                    });
                    main.getChildren().add(tempView);
                });
    }

    /**
     * Initialise la disposition des cartes dans la zone des œuvres des deux joueurs
     * sur l'interface graphique.
     */
    private void initOeuvres() {
        // joueur actuel
        Partie partie = Partie.getInstance();
        ArrayList<ImageView> cartes = new ArrayList<ImageView>();
        partie.getJoueur(partie.getTour()).getOeuvres().getCartes().iterator()
                .forEachRemaining(c -> {
                    ImageView tempView = new CarteView(c);
                    tempView.setOnMouseClicked(e -> {
                        handleMouseClicked(c);
                    });
                    cartes.add(tempView);
                });
        oeuvres.getChildren().addAll(cartes);
        // joueur adversaire
        cartes.clear();
        partie.getJoueur((partie.getTour() + 1) % 2).getOeuvres().getCartes().iterator()
                .forEachRemaining(c -> {
                    ImageView tempView = new CarteView(c);
                    tempView.setOnMouseClicked(e -> {
                        handleMouseClicked(c);
                    });
                    cartes.add(tempView);
                });
        adversaireOeuvres.getChildren().addAll(cartes);
    }

    /**
     * Initialise la disposition de la fosse du jeu sur l'interface graphique.
     */
    private void initFosse() {
        Partie partie = Partie.getInstance();
        Fosse fosseJeu = partie.getFosse();
        if (fosseJeu.size() > 0) {
            fosse.setVisible(true);
            fosseQte.setVisible(true);
            fosse.setImage(
                    new Image("/images/cartes/" + fosseJeu.getCartes().get(fosseJeu.size() - 1).getNom() + ".png"));
            fosseQte.setText(Integer.toString(fosseJeu.size()));
        } else {
            fosse.setVisible(false);
            fosseQte.setVisible(false);
        }
    }

    /**
     * Initialise la disposition des cartes dans la zone de la vie future des deux
     * joueurs sur l'interface graphique.
     */
    private void initVieFuture() {
        Partie partie = Partie.getInstance();
        // joueur actuel vie future
        if (partie.getJoueur(partie.getTour()).getVieFuture().size() > 0) {
            vieFuture.setVisible(true);
            vieFutureQte.setVisible(true);
            ArrayList<Carte> vf = partie.getJoueur(partie.getTour()).getVieFuture().getCartes();
            vieFuture.setImage(new Image("/images/cartes/"
                    + vf.get(vf.size() - 1).getNom() + ".png"));
            vieFutureQte.setText(Integer.toString(vf.size()));
        } else {
            vieFuture.setVisible(false);
            vieFutureQte.setVisible(false);
        }
        // adversaire vie future
        if (partie.getJoueur((partie.getTour() + 1) % 2).getVieFuture().size() > 0) {
            adversaireVieFuture.setVisible(true);
            adversaireVieFutureQte.setVisible(true);
            adversaireVieFutureQte
                    .setText(Integer.toString(partie.getJoueur((partie.getTour() + 1) % 2).getVieFuture().size()));
        } else {
            adversaireVieFuture.setVisible(false);
            adversaireVieFutureQte.setVisible(false);
        }
    }

    /**
     * Initialise la disposition des cartes dans la zone du deck des deux joueurs
     * sur l'interface graphique.
     */
    private void initDeck() {
        Partie partie = Partie.getInstance();
        // joueur actuel deck
        if (partie.getJoueur(partie.getTour()).getDeck().size() > 0) {
            deck.setVisible(true);
            deckQte.setVisible(true);
            deckQte.setText(Integer.toString(partie.getJoueur(partie.getTour()).getDeck().size()));
        } else {
            deckQte.setVisible(false);
            deck.setVisible(false);
        }
        // adversaire deck
        if (partie.getJoueur((partie.getTour() + 1) % 2).getDeck().size() > 0) {
            adversaireDeck.setVisible(true);
            adversaireDeckQte.setVisible(true);
            adversaireDeckQte.setText(Integer.toString(partie.getJoueur((partie.getTour() + 1) % 2).getDeck().size()));
        } else {
            adversaireDeck.setVisible(false);
            adversaireDeckQte.setVisible(false);
        }
    }

    /**
     * Initialise la disposition de la source du jeu sur l'interface graphique.
     */
    private void initSource() {
        Partie partie = Partie.getInstance();
        if (partie.getSource().size() > 0) {
            source.setVisible(true);
            sourceQte.setText(Integer.toString(partie.getSource().size()));
        } else {
            source.setVisible(false);
            sourceQte.setVisible(false);
        }
    }

    /**
     * Initialise la disposition des anneaux des deux joueurs sur l'interface
     * graphique.
     */
    private void initAnneaux() {
        Partie partie = Partie.getInstance();
        anneaux.setText(Integer.toString(partie.getJoueur(partie.getTour()).getNbAnneaux()));
        adversaireAnneaux.setText(Integer.toString(partie.getJoueur((partie.getTour() + 1) % 2).getNbAnneaux()));
    }

    /**
     * Initialise la visibilité du bouton "Passer" en fonction de la présence de
     * cartes dans le deck du joueur actuel.
     */
    private void initPasser() {
        Deck deckJoueur = Partie.getInstance().getJoueur(Partie.getInstance().getTour()).getDeck();
        if (deckJoueur.size() > 0) {
            passer.setVisible(true);
        } else {
            passer.setVisible(false);
        }
    }

    private void initTourSuivantRobot() {
        ArrayList<Action> actionsPossibles = Partie.getInstance().getActionsPossibles();
        if (actionsPossibles.contains(Action.TOUR_SUIVANT_ROBOT)) {
            suivantRobot.setVisible(true);
        } else {
            suivantRobot.setVisible(false);
        }
    }

    /**
     * Initialise les éléments graphiques de la scène du plateau de jeu lors de son
     * affichage.
     *
     * @param arg0 URL utilisée pour résoudre les chemins relatifs aux ressources.
     * @param arg1 ResourceBundle qui contient les paramètres régionaux actuels.
     */
    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        initSource();
        initMain();
        initOeuvres();
        initFosse();
        initVieFuture();
        initDeck();
        initAnneaux();
        initPasser();
        initTourSuivantRobot();
    }
}
