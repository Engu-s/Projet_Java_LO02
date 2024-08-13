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
 * La classe AffichageCartes étend la classe Alert de JavaFX et est utilisée
 * pour afficher les cartes dans une boîte de dialogue.
 * Elle prend un message et une liste de cartes en paramètres pour créer une
 * boîte de dialogue avec une disposition spécifique.
 */
public class AffichageCartes extends Alert {

    /**
     * Constructeur de la classe AffichageCartes.
     *
     * @param message Le message à afficher dans la boîte de dialogue.
     * @param cartes  La liste de cartes à afficher dans la boîte de dialogue.
     */
    public AffichageCartes(String message, ArrayList<Carte> cartes) {
        super(AlertType.NONE);
        ArrayList<ImageView> cartesView = new ArrayList<ImageView>();
        cartes.iterator()
                .forEachRemaining(c -> {
                    cartesView.add(new CarteView(c));
                });
        // HBox contenant toutes les cartes.
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setPrefWidth(00);
        hbox.getChildren().addAll(cartesView);
        // ScrollPane contenant la HBox pour gérer le défilement si nécessaire.
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(hbox);
        // Label pour afficher le message au-dessus des cartes.
        Label label = new Label(message);
        // VBox contenant le label et le ScrollPane.
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(label, scrollPane);
        // DialogPane contenant la VBox (nécessaire pour la boîte de dialogue).
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContent(vbox);
        // Configuration de la boîte de dialogue.
        super.setWidth(800);
        super.setTitle("Affichage cartes.");
        super.setDialogPane(dialogPane);
        super.getButtonTypes().add(ButtonType.OK);
    }
}
