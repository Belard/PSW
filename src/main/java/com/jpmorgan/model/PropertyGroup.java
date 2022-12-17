package com.jpmorgan.model;

public enum PropertyGroup {

    BROWN("brown"),

    LIGHT_BLUE("light_blue"),

    PURPLE("purple"),

    ORANGE("orange"),

    RED("red"),

    YELLOW("yellow"),

    GREEN("green"),

    BLUE("blue"),

    STATION("station"),

    COMPANY("company");

    private final String name;

    PropertyGroup(String name) {
        this.name = name;
    }

    public static PropertyGroup parse(String name) {
        for (PropertyGroup propertyGroup : PropertyGroup.values()) {
            if (propertyGroup.name.equalsIgnoreCase(name)) {
                return propertyGroup;
            }
        }

        return null;
    }
}
