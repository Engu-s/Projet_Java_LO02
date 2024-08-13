package karmaka.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import karmaka.classes.Joueur;
import karmaka.classes.Partie;
import karmaka.classes.joueurs.Humain;
import karmaka.classes.joueurs.Robot;
import karmaka.view.Router;

/**
 * La classe CreateGameController gère les actions et les interactions de
 * l'interface utilisateur pour la création d'une nouvelle partie du jeu.
 */
public class CreateGameController implements Initializable {
    @FXML
    private RadioButton j1Humain, j1Robot, j2Humain, j2Robot, j1RobotOff, j2RobotOff;
    @FXML
    private TextField j1Nom, j2Nom;
    @FXML
    private ComboBox<Robot.Strategie> j1Strat, j2Strat;

    /**
     * Initialise le contrôleur après que son élément racine ait été complètement
     * traité.
     *
     * @param arg0 URL utilisée pour résoudre les chemins relatifs aux ressources.
     * @param arg1 ResourceBundle qui contient les paramètres régionaux actuels.
     */
    @FXML
    public void initialize(java.net.URL arg0, java.util.ResourceBundle arg1) {
        j1Strat.setVisible(false);
        j2Strat.setVisible(false);
        j1Strat.getItems().addAll(Robot.Strategie.values());
        j2Strat.getItems().addAll(Robot.Strategie.values());
        j1Strat.getSelectionModel().selectFirst();
        j2Strat.getSelectionModel().selectFirst();
    }

    /**
     * Gère l'action lorsque le joueur 1 est défini comme humain.
     */
    @FXML
    private void handleJ1Humain() {
        j1Robot.setSelected(false);
        j1Strat.setVisible(false);
    }

    /**
     * Gère l'action lorsque le joueur 1 est défini comme robot.
     */
    @FXML
    private void handleJ1Robot() {
        j1Humain.setSelected(false);
        j1Strat.setVisible(true);
    }

    /**
     * Gère l'action lorsque le joueur 2 est défini comme humain.
     */
    @FXML
    private void handleJ2Humain() {
        j2Robot.setSelected(false);
        j2Strat.setVisible(false);
    }

    /**
     * Gère l'action lorsque le joueur 2 est défini comme robot.
     */
    @FXML
    private void handleJ2Robot() {
        j2Humain.setSelected(false);
        j2Strat.setVisible(true);
    }

    /**
     * Gère l'action d'annulation pour revenir au menu principal.
     */
    @FXML
    private void handleAnnuler() {
        Router.getInstance().setScene("menu");
    }

    /**
     * Gère l'action de création d'une nouvelle partie avec les joueurs configurés
     * et redirige vers la scène du plateau de jeu.
     */
    @FXML
    private void handleCreer() {
        Router.getInstance().setScene("plateauPlaceholder");
        Joueur j1;
        Joueur j2;
        if (j1Robot.isSelected()) {
            j1 = new Robot(j1Nom.getText(), j1Strat.getValue());
        } else {
            j1 = new Humain(j1Nom.getText());
        }
        if (j2Robot.isSelected()) {
            j2 = new Robot(j2Nom.getText(), j2Strat.getValue());
        } else {
            j2 = new Humain(j2Nom.getText());
        }
        Partie.init(j1, j2);
        Router.getInstance().setScene("plateau");
        Partie.getInstance().tour();
    }
}
