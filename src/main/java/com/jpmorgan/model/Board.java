package com.jpmorgan.model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final String name;

    private final Image icon;

    List<Player> players = new ArrayList<>();

    public Board(String name, Image icon) {
        this.name = name;
        this.icon = icon;
    }

    public Board(String name, Image icon, List<Player> player_inTile) {
        this.name = name;
        this.icon = icon;
        this.players.addAll(player_inTile);
    }

	public String getName() {
        return name;
    }

    public Image getIcon() {
        return icon;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public List<Player> getPlayers() {
        return players;
    }
}

