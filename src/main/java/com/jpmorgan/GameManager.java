package com.jpmorgan;

import com.jpmorgan.model.Player;
import com.jpmorgan.Popups.PlayerToken;
import com.jpmorgan.model.Board;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameManager {

    private static final String PLAYER_IMAGES_DIRECTORY = "./src/main/resources/com/jpmorgan/images/player";

    private static final String PLAYER_TOKENS_DIRECTORY = "./src/main/resources/com/jpmorgan/images/playerToken";

    private static final int NUM_PLAYERS = 5;

    private static GameManager instance;

    private final List<Player> players = new ArrayList<>();

    private final List<Board> tiles = new ArrayList<>();

    private Player playerSelf;

    private int playerPlaying;

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
        loadBoard();
        playerPlaying = 0;
    }

    private void loadBoard() {
        List<Image> tileImages = loadPlayerImages();
        List<Player> allPlayers = new ArrayList<>();
        allPlayers.add(playerSelf);
        allPlayers.addAll(players);

        /*
         * 
         * FALTA POR AS IMAGENS CORRETAS
         * 
         */

        tiles.add(new Board("start", tileImages.get(0), allPlayers));
        tiles.add(new Board("brown_1", tileImages.get(0)));
        tiles.add(new Board("community_chest_1", tileImages.get(0)));
        tiles.add(new Board("brown_2", tileImages.get(0)));
        tiles.add(new Board("income_taxes", tileImages.get(0)));
        tiles.add(new Board("railroad_1", tileImages.get(0)));
        tiles.add(new Board("cyan_1", tileImages.get(0)));
        tiles.add(new Board("lucky_1", tileImages.get(0)));
        tiles.add(new Board("cyan_2", tileImages.get(0)));
        tiles.add(new Board("cyan_3", tileImages.get(0)));
        tiles.add(new Board("jail_free", tileImages.get(0)));
        tiles.add(new Board("purple_1", tileImages.get(0)));
        tiles.add(new Board("electric_company", tileImages.get(0)));
        tiles.add(new Board("purple_2", tileImages.get(0)));
        tiles.add(new Board("purple_3", tileImages.get(0)));
        tiles.add(new Board("railroad_2", tileImages.get(0)));
        tiles.add(new Board("orange_1", tileImages.get(0)));
        tiles.add(new Board("community_chest_2", tileImages.get(0)));
        tiles.add(new Board("orange_2", tileImages.get(0)));
        tiles.add(new Board("orange_3", tileImages.get(0)));
        tiles.add(new Board("free_parking", tileImages.get(0)));
        tiles.add(new Board("red_1", tileImages.get(0)));
        tiles.add(new Board("lucky_2", tileImages.get(0)));
        tiles.add(new Board("red_2", tileImages.get(0)));
        tiles.add(new Board("red_3", tileImages.get(0)));
        tiles.add(new Board("railroad_3", tileImages.get(0)));
        tiles.add(new Board("yellow_1", tileImages.get(0)));
        tiles.add(new Board("yellow_2", tileImages.get(0)));
        tiles.add(new Board("water_company", tileImages.get(0)));
        tiles.add(new Board("yellow_3", tileImages.get(0)));
        tiles.add(new Board("go_to_jail", tileImages.get(0)));
        tiles.add(new Board("green_1", tileImages.get(0)));
        tiles.add(new Board("green_2", tileImages.get(0)));
        tiles.add(new Board("community_chest_3", tileImages.get(0)));
        tiles.add(new Board("green_3", tileImages.get(0)));
        tiles.add(new Board("railroad_4", tileImages.get(0)));
        tiles.add(new Board("lucky_3", tileImages.get(0)));
        tiles.add(new Board("blue_1", tileImages.get(0)));
        tiles.add(new Board("luxury_tax", tileImages.get(0)));
        tiles.add(new Board("blue_2", tileImages.get(0)));
        tiles.add(new Board("jail", tileImages.get(0)));

    }

    private void loadPlayers() {
        List<Image> playerImages = loadPlayerImages();
        List<Image> playerTokens = loadPlayerTokens();

        int x = getRandomPlayerImage(playerImages);

        playerSelf = new Player("Dev", playerImages.remove(x), playerTokens.remove(x) , 600, 0);

        for (int i = 1; i <= NUM_PLAYERS; i++) {
            int y = getRandomPlayerImage(playerImages);
            players.add(new Player("Player " + i, playerImages.remove(y), playerTokens.remove(y) , 600 - (i * 100), 0));
        }
    }

    private List<Image> loadPlayerTokens() {
        List<Image> playerTokensImages = new ArrayList<>();

        File playerTokensDirectory = new File(PLAYER_TOKENS_DIRECTORY);

//        File file2 = new File("./src/main/resources/com");
//        for(String fileNames : file2.list()) System.out.println(fileNames);
        
        if (!playerTokensDirectory.exists()) {
            System.err.println("Could not locate player tokens directory : " + PLAYER_TOKENS_DIRECTORY);
        }

        List<File> files = List.of(Objects.requireNonNull(playerTokensDirectory.listFiles()));

        for (File file : files) {
            try {
                playerTokensImages.add(new Image(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return playerTokensImages;
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

    private int getRandomPlayerImage(List<Image> playerImages) {
        int number = (int) Math.floor(Math.random() * (playerImages.size()));

        return number;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayerSelf() {
        return playerSelf;
    }

    public List<Board> getBoard() {
        return tiles;
    }

    public int getPlayerPlaying() {
        return playerPlaying;
    }

    public void movePlayer(int diceValue, int location) {
        Player player = GameManager.getInstance().getPlayerSelf();
        if (getPlayerPlaying() > 0) player = GameManager.getInstance().getPlayers().get(getPlayerPlaying() - 1);
        
        GameManager.getInstance().getBoard().get(location).removePlayer(player);
        int newLocation = diceValue + location;
        if (newLocation > 39) newLocation = newLocation - 40;
        GameManager.getInstance().getBoard().get(newLocation).addPlayer(player);
        
        if (GameManager.getInstance().getPlayerSelf().getName() == player.getName()) GameManager.getInstance().getPlayerSelf().changeTile(newLocation);
        else GameManager.getInstance().getPlayers().get(getPlayerPlaying() - 1).changeTile(newLocation);

        for (int i = 1; i <= GameManager.getInstance().getBoard().get(newLocation).getPlayers().size(); i++) {
            PlayerToken.getInstance().moveTokens(GameManager.getInstance().getBoard().get(newLocation).getPlayers().size(), i, GameManager.getInstance().getBoard().get(newLocation).getName(), GameManager.getInstance().getBoard().get(newLocation).getPlayers().get(i-1), PlayerToken.getInstance().getRotation(newLocation));
        }
    }
}
