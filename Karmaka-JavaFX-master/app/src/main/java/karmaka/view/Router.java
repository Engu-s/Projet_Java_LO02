package karmaka.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import karmaka.classes.Carte;
import karmaka.classes.GameData;

/**
 * La classe Router gère la navigation entre les différentes vues de
 * l'application.
 */
public final class Router {
    private static String scene;
    private static Stage stage;
    private static Router instance = null;
    private static HashMap<String, String> scenes = new HashMap<String, String>();

    /**
     * Constructeur privé pour appliquer le modèle Singleton.
     *
     * @param initStage La scène principale de l'application.
     */
    private Router(Stage initStage) {
        stage = initStage;
        addScenes();
    }

    /**
     * Ajoute les différentes scènes de l'application à la table de hachage.
     */
    private void addScenes() {
        scenes.put("menu", "fxml/Menu.fxml");
        scenes.put("createGame", "fxml/CreateGame.fxml");
        scenes.put("plateau", "fxml/Plateau.fxml");
        scenes.put("plateauPlaceholder", "fxml/PlateauPlaceholder.fxml");
        scenes.put("echelle", "fxml/Echelle.fxml");
        scenes.put("gagnant", "fxml/Gagnant.fxml");
    }

    /**
     * Initialise le Router avec la scène principale.
     *
     * @param stage La scène principale de l'application.
     */
    public static void init(Stage stage) {
        if (instance == null) {
            instance = new Router(stage);
        }
    }

    public static Router getInstance() {
        return instance;
    }

    public void setScene(String sceneName) {
        scene = sceneName;
        stage.setTitle(sceneName);
        try {
            Scene newScene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource(scenes.get(sceneName))));
            stage.setScene(newScene);
        } catch (Exception e) {
            System.out.println("Scene not found: " + sceneName);
            e.printStackTrace();
        }
        stage.show();
        System.out.println("Scene changed to " + scene);
    }

    /**
     * Met à jour la scène actuelle de l'application.
     */
    public void update() {
        stage.setTitle(scene);
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getClassLoader().getResource(scenes.get(scene)))));
        } catch (Exception e) {
            System.out.println("Scene not found: " + scene);
            e.printStackTrace();
        }
        stage.show();
        System.out.println("Scene updated to " + scene);
    }

    /**
     * Affiche une boîte de dialogue d'information avec le message spécifié.
     *
     * @param inst Le message à afficher.
     */
    public void afficher(String inst) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instructions");
        alert.setHeaderText(null);
        alert.setContentText(inst);

        alert.showAndWait();
    }

    /**
     * Affiche une boîte de dialogue de choix avec les options spécifiées.
     *
     * @param message Le message à afficher.
     * @param choix   Les options disponibles.
     * @return Le choix de l'utilisateur.
     */
    public String choix(String message, String... choix) {
        ChoiceDialog<String> dialog = new ChoiceDialog<String>(choix[0], choix);
        dialog.setTitle("Veuillez faire un choix.");
        dialog.setHeaderText(null);
        dialog.setContentText(message);

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    /**
     * Affiche une boîte de dialogue de choix de carte parmi une liste.
     *
     * @param message Le message à afficher.
     * @param cartes  La liste des cartes parmi lesquelles l'utilisateur peut
     *                choisir.
     * @return La carte choisie par l'utilisateur.
     */
    public Carte choix(String message, ArrayList<Carte> cartes) {
        ChoixCarte alert = new ChoixCarte(message, cartes);

        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            return alert.getCarteSel();
        } else {
            return null;
        }
    }

    /**
     * Affiche une boîte de dialogue contenant une liste de cartes.
     *
     * @param message Le message à afficher.
     * @param cartes  La liste des cartes à afficher.
     */
    public void afficherCartes(String message, ArrayList<Carte> cartes) {
        AffichageCartes alert = new AffichageCartes(message, cartes);

        alert.showAndWait();
    }

    /**
     * Sauvegarde les données de la partie dans un fichier.
     *
     * @param gameData Les données de la partie à sauvegarder.
     */
    private void savePartieToFile(GameData gameData, File file) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameData);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            System.out.println("probleme");
        }
    }

    /**
     * Permet à l'utilisateur de sauvegarder la partie en cours dans un fichier.
     *
     * @param gameData Les données de la partie à sauvegarder.
     */
    public void sauvegarder(GameData gameData) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sauvegarder");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sauvegarde karmaka (.krmk)", "*.krmk"));
        fileChooser.setInitialFileName("partie.krmk");
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            savePartieToFile(gameData, file);
        }
    }

    /**
     * Charge les données d'une partie depuis un fichier.
     *
     * @param file Le fichier à partir duquel charger les données de la partie.
     * @return Les données de la partie chargées depuis le fichier.
     */
    private GameData loadPartieFromFile(File file) {
        GameData gameData = null;
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            System.out.println(in);
            gameData = (GameData) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            System.out.println("probleme");
        } catch (ClassNotFoundException ex) {
            System.out.println("probleme");
        }
        return gameData;
    }

    /**
     * Permet à l'utilisateur de charger une partie depuis un fichier.
     *
     * @return Les données de la partie chargées depuis le fichier.
     */
    public GameData charger() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Charger");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sauvegarde karmaka (.krmk)", "*.krmk"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            return loadPartieFromFile(file);
        }
        return null;
    }
}
