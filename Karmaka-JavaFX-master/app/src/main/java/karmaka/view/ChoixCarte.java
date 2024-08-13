package karmaka.view;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import karmaka.classes.Carte;

/**
 * La classe ChoixCarte étend la classe Alert et représente une boîte de
 * dialogue
 * permettant à l'utilisateur de choisir une carte parmi une liste.
 */
public class ChoixCarte extends Alert {
    private Carte carteSel;

    /**
     * Constructeur de la classe ChoixCarte.
     *
     * @param message Message à afficher dans la boîte de dialogue.
     * @param cartes  Liste des cartes parmi lesquelles l'utilisateur peut choisir.
     */
    public ChoixCarte(String message, ArrayList<Carte> cartes) {
        super(AlertType.NONE);
        // Liste d'ImageView représentant les cartes
        ArrayList<ImageView> cartesView = new ArrayList<ImageView>();
        // Étiquette affichant la carte sélectionnée
        Label carteSelLabel = new Label("La carte sélectionnée actuellement est: Aucune");
        // Parcours des cartes pour créer les ImageView correspondantes
        cartes.iterator()
                .forEachRemaining(c -> {
                    ImageView tempView = new CarteView(c);
                    // Gestionnaire d'événements pour le clic sur une carte
                    tempView.setOnMouseClicked(e -> {
                        carteSel = c;
                        carteSelLabel.setText("La carte sélectionnée actuellement est: " + c.getNom());
                    });
                    cartesView.add(tempView);
                });
        // HBox contenant toutes les cartes
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setPrefWidth(00);
        hbox.getChildren().addAll(cartesView);
        // ScrollPane contenant la HBox
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(hbox);
        // Étiquette affichant le message
        Label label = new Label(message);
        // VBox contenant l'étiquette, le ScrollPane et l'étiquette de la carte
        // sélectionnée
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(label, scrollPane, carteSelLabel);
        // DialogPane contenant la VBox (nécessaire pour l'alerte)
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContent(vbox);
        // Configuration de l'alerte
        super.setTitle("Veuillez faire un choix.");
        super.setDialogPane(dialogPane);
        super.getButtonTypes().add(ButtonType.OK);
    }

    /**
     * Récupère la carte sélectionnée par l'utilisateur.
     *
     * @return La carte sélectionnée.
     */
    public Carte getCarteSel() {
        return carteSel;
    }
}