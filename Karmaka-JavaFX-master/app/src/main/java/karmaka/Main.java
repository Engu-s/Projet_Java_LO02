package karmaka;

import javafx.application.Application;
import javafx.stage.Stage;
import karmaka.view.Router;

/**
 * La classe {@code Main} représente le point d'entrée principal de
 * l'application Karmaka.
 * Elle étend la classe {@code Application} de JavaFX et initialise le routeur
 * de l'interface utilisateur.
 * La scène initiale est définie sur le menu principal.
 *
 * <p>
 * Pour lancer l'application, la méthode statique {@code main} est utilisée pour
 * appeler la méthode {@code launch} de JavaFX.
 * </p>
 */
public class Main extends Application {
    /**
     * Méthode appelée lors du démarrage de l'application JavaFX.
     * Initialise le routeur de l'interface utilisateur et définit la scène initiale
     * sur le menu principal.
     *
     * @param primaryStage Le conteneur de la fenêtre de l'application.
     * @throws Exception En cas d'erreur lors de l'initialisation.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Router.init(primaryStage);
        Router.getInstance().setScene("menu");
    }

    /**
     * Méthode principale qui lance l'application JavaFX.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cet
     *             exemple).
     */
    public static void main(String[] args) {
        launch(args);
    }
}