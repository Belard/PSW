package com.jpmorgan.model;

import javafx.scene.image.Image;

public class Property {

    private String name;

    private int numHouses;

    private int numHotels;

    private int buildCost;

    private int mortgageValue;

    private int[] rentValues;

    private Image icon;


    public Property(String name, int buildCost, int mortgageValue, int[] rentValues, Image icon) {
        this.name = name;
        this.buildCost = buildCost;
        this.mortgageValue = mortgageValue;
        this.rentValues = rentValues;
        this.icon = icon;
        this.numHouses = 0;
        this.numHotels = 0;
    }

    public void addHouse() {
        this.numHouses++;
    }

    public void addHotel() {
        this.numHotels++;
    }

    public int calculateRent() {
        return this.rentValues[this.numHouses + this.numHotels];
    }

    public String getName() {
        return name;
    }

    public int getNumHouses() {
        return numHouses;
    }

    public int getNumHotels() {
        return numHotels;
    }

    public int getBuildCost() {
        return buildCost;
    }

    public int getMortgageValue() {
        return mortgageValue;
    }

    public Image getIcon() {
        return icon;
    }
}
