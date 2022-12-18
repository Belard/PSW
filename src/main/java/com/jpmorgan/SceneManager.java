package com.jpmorgan;

import com.jpmorgan.scenes.GamePanel;
import com.jpmorgan.scenes.InitialPanel;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SceneManager {

    private static final String STYLES_DIRECTORY = "./src/main/resources/com/jpmorgan/stylesheets";

    private Stage primaryStage;

    private static SceneManager instance;

    private Map<String, AnchorPane> scenes = new HashMap<>() {{
        put("initialPanel", new InitialPanel().start());
        //put("onlinePanel", new OnlinePanel().start());
        put("gamePanel", new GamePanel().start());
    }};

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }

        return instance;
    }

    private SceneManager() {
        // Empty
    }

    public void initScene(Stage stage) throws IOException {
        primaryStage = stage;

        // Setting title to the Stage
        primaryStage.setTitle("CSS Example");

        primaryStage.setWidth(1920);
        primaryStage.setHeight(1080);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        // Adding scene to the stage
        changeScene("initialPanel");

        loadStyles(primaryStage.getScene());

        primaryStage.show();
    }

    public void changeScene(String sceneName) {
        if (!scenes.containsKey(sceneName)) {
            throw new IllegalArgumentException("Could not find scene " + sceneName);
        }

        AnchorPane root = scenes.get(sceneName);

        if (primaryStage.getScene() == null) {
            primaryStage.setScene(new Scene(root));
        } else {
            primaryStage.getScene().setRoot(root);
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void loadStyles(Scene scene) throws IOException {
        File stylesDirectory = new File(STYLES_DIRECTORY);

        if (!stylesDirectory.exists()) {
            throw new IOException("Could not locate stylesheets directory : " + STYLES_DIRECTORY);
        }

        List<File> files = List.of(stylesDirectory.listFiles());

        for (File file : files) {
            scene.getStylesheets().add(file.toURI().toURL().toExternalForm());
        }
    }
}
