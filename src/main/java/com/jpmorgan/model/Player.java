package com.jpmorgan.model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;

    private final Image icon;

    private final Image token;

    private int balance;
    
    private int tile;

    List<Property> properties = new ArrayList<>();

    public Player(String name, Image icon, Image token, int balance, int tile) {
        this.name = name;
        this.icon = icon;
        this.token = token;
        this.balance = balance;
        this.tile = tile;
    }

	public String getName() {
        return name;
    }

    public Image getIcon() {
        return icon;
    }

    public Image getToken() {
        return token;
    }

    public int getBalance() {
        return balance;
    }

    public int getTile() {
        return tile;
    }

    public int changeBalance(int balance) {
        this.balance += balance;

        return this.balance;
    }

    public int changeTile(int tile) {
        this.tile = tile;

        return this.tile;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
