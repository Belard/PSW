package com.jpmorgan.model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;

    private final Image icon;

    private int balance;

    List<Property> properties = new ArrayList<>();

    public Player(String name, Image icon, int balance) {
        this.name = name;
        this.icon = icon;
        this.balance = balance;
    }

	public String getName() {
        return name;
    }

    public Image getIcon() {
        return icon;
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
