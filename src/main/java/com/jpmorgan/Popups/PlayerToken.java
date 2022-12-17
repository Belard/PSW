package com.jpmorgan.Popups;

import com.jpmorgan.model.Player;

import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlayerToken {
    
    private static PlayerToken instance;

    private Map<String, String> singlePlayerOnTileMap = new HashMap<>() {{
        put("brown_1",             "910/1032");          
        put("community_chest_1",   "822.5/1032");   
        put("brown_2",             "735/1032");
        put("income_taxes",        "647,5/1032");
        put("railroad_1",          "560/1032");
        put("cyan_1",              "472,5/1032");
        put("lucky_1",             "385/1032");
        put("cyan_2",              "297,5/1032");
        put("cyan_3",              "210/1032");
        put("jail",                "15/15");
        put("jail_free",           "15/15");
        put("purple_1",            "15/15");
        put("electric_company",    "15/15");
        put("purple_2",            "15/15");
        put("purple_3",            "15/15");
        put("railroad_2",          "15/15");
        put("orange_1",            "15/15");
        put("community_chest_2",   "15/15");
        put("orange_2",            "15/15");
        put("orange_3",            "15/15");
        put("free_parking",        "15/15");
        put("red_1",               "15/15");
        put("lucky_2",             "15/15");
        put("red_2",               "15/15");
        put("red_3",               "15/15");
        put("railroad_3",          "15/15");
        put("yellow_1",            "15/15");
        put("yellow_2",            "15/15");
        put("water_company",       "15/15");
        put("yellow_3",            "15/15");
        put("go_to_jail",          "15/15");
        put("green_1",             "15/15");
        put("green_2",             "15/15");
        put("community_chest_3",   "15/15");
        put("green_3",             "15/15");
        put("railroad_4",          "15/15");
        put("lucky_3",             "15/15");
        put("blue_1",              "15/15");
        put("luxury_tax",          "15/15");
        put("blue_2",              "15/15");
    }};

    List<Circle> playerCircles = new ArrayList<>();;

    public static PlayerToken getInstance() {
        if (instance == null) {
            instance = new PlayerToken();
        }

        return instance;
    }

    private void saveCircle(Circle circle) {
        playerCircles.add(circle);
    }

    public List<Circle> getCircle() {
        return playerCircles;
    }

    public void addTokenInit(AnchorPane root, Double x, Double y, Player player){
        Circle otherPlayerImage = new Circle(20, new ImagePattern(player.getToken()));
        saveCircle(otherPlayerImage);
        otherPlayerImage.setId(player.getName());

        otherPlayerImage.setCenterX(x+20);
        otherPlayerImage.setCenterY(y+20);

        root.getChildren().add(otherPlayerImage);
    }


}
