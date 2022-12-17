package com.jpmorgan;

import com.jpmorgan.model.Player;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameManager {

    private static final String PLAYER_IMAGES_DIRECTORY = "./src/main/resources/com/jpmorgan/images/player";

    private static final int NUM_PLAYERS = 5;

    private static GameManager instance;

    private final List<Player> players = new ArrayList<>();

    private Player playerSelf;

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }

        return instance;
    }

    private GameManager() {
        // Empty
    }

    public void init() {
        loadPlayers();
    }

    private void loadPlayers() {
        List<Image> playerImages = loadPlayerImages();

        playerSelf = new Player("Dev", getRandomPlayerImage(playerImages), 600);

        for (int i = 1; i <= NUM_PLAYERS; i++) {
            players.add(new Player("Player " + i, getRandomPlayerImage(playerImages), 600 - (i * 100)));
        }
    }

    private List<Image> loadPlayerImages() {
        List<Image> playerImages = new ArrayList<>();

        File playerImagesDirectory = new File(PLAYER_IMAGES_DIRECTORY);

//        File file2 = new File("./src/main/resources/com");
//        for(String fileNames : file2.list()) System.out.println(fileNames);
        
        if (!playerImagesDirectory.exists()) {
            System.err.println("Could not locate player images directory : " + PLAYER_IMAGES_DIRECTORY);
        }

        List<File> files = List.of(Objects.requireNonNull(playerImagesDirectory.listFiles()));

        for (File file : files) {
            try {
                playerImages.add(new Image(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return playerImages;
    }

    private Image getRandomPlayerImage(List<Image> playerImages) {
        int number = (int) Math.floor(Math.random() * (playerImages.size()));

        return playerImages.remove(number);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayerSelf() {
        return playerSelf;
    }

    
}
