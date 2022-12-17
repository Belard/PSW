package com.jpmorgan.model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;

    private final Image icon;

    private final Image token;

    private int balance;

    List<Property> properties = new ArrayList<>();

    public Player(String name, Image icon, Image token, int balance) {
        this.name = name;
        this.icon = icon;
        this.token = token;
        this.balance = balance;
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

    public int changeBalance(int balance) {
        this.balance += balance;

        return this.balance;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
