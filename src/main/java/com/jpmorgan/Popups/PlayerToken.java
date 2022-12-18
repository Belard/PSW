package com.jpmorgan.Popups;

import com.jpmorgan.model.Player;
import com.jpmorgan.GameManager;
import com.jpmorgan.model.Board;

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
        put("start",               "1000/960");
        put("brown_1",             "910/1038");          
        put("community_chest_1",   "822.5/1038");   
        put("brown_2",             "735/1038");
        put("income_taxes",        "647.5/1038");
        put("railroad_1",          "560/1038");
        put("cyan_1",              "472.5/1038");
        put("lucky_1",             "385/1038");
        put("cyan_2",              "297.5/1038");
        put("cyan_3",              "210/1038");
        put("jail_free",           "140/1056");
        put("purple_1",            "68/890");
        put("electric_company",    "68/802.5");
        put("purple_2",            "68/715");
        put("purple_3",            "68/627.5");
        put("railroad_2",          "68/540");
        put("orange_1",            "68/452.5");
        put("community_chest_2",   "68/365");
        put("orange_2",            "68/277.5");
        put("orange_3",            "68/190");
        put("free_parking",        "135/100");
        put("red_1",               "212/42");
        put("lucky_2",             "299.5/42");
        put("red_2",               "387/42");
        put("red_3",               "474.5/42");
        put("railroad_3",          "562/42");
        put("yellow_1",            "649.5/42");
        put("yellow_2",            "737/42");
        put("water_company",       "824.5/42");
        put("yellow_3",            "912/42");
        put("go_to_jail",          "1005/120");
        put("green_1",             "1055/190");
        put("green_2",             "1055/277.5");
        put("community_chest_3",   "1055/365");
        put("green_3",             "1055/452.5");
        put("railroad_4",          "1055/540");
        put("lucky_3",             "1055/627.5");
        put("blue_1",              "1055/715");
        put("luxury_tax",          "1055/802.5");
        put("blue_2",              "1055/890");
        put("jail",                "140/1010");
    }};

    private Map<String, String> doublePlayerOnTileMap1 = new HashMap<>() {{
        put("start",               "1000/960");
        put("brown_1",             "890/1038");          
        put("community_chest_1",   "802.5/1038");   
        put("brown_2",             "715/1038");
        put("income_taxes",        "627.5/1038");
        put("railroad_1",          "540/1038");
        put("cyan_1",              "452.5/1038");
        put("lucky_1",             "365/1038");
        put("cyan_2",              "277.5/1038");
        put("cyan_3",              "190/1038");
        put("jail_free",           "140/1056");
        put("purple_1",            "68/870");
        put("electric_company",    "68/782.5");
        put("purple_2",            "68/695");
        put("purple_3",            "68/607.5");
        put("railroad_2",          "68/520");
        put("orange_1",            "68/432.5");
        put("community_chest_2",   "68/345");
        put("orange_2",            "68/257.5");
        put("orange_3",            "68/170");
        put("free_parking",        "135/100");
        put("red_1",               "192/42");
        put("lucky_2",             "279.5/42");
        put("red_2",               "367/42");
        put("red_3",               "454.5/42");
        put("railroad_3",          "542/42");
        put("yellow_1",            "629.5/42");
        put("yellow_2",            "717/42");
        put("water_company",       "804.5/42");
        put("yellow_3",            "892/42");
        put("go_to_jail",          "1005/120");
        put("green_1",             "1055/170");
        put("green_2",             "1055/257.5");
        put("community_chest_3",   "1055/345");
        put("green_3",             "1055/432.5");
        put("railroad_4",          "1055/520");
        put("lucky_3",             "1055/607.5");
        put("blue_1",              "1055/695");
        put("luxury_tax",          "1055/782.5");
        put("blue_2",              "1055/870");
        put("jail",                "140/1010");
    }};

    private Map<String, String> doublePlayerOnTileMap2 = new HashMap<>() {{
        put("start",               "1050/960");
        put("brown_1",             "930/1038");          
        put("community_chest_1",   "842.5/1038");   
        put("brown_2",             "755/1038");
        put("income_taxes",        "667.5/1038");
        put("railroad_1",          "580/1038");
        put("cyan_1",              "492.5/1038");
        put("lucky_1",             "405/1038");
        put("cyan_2",              "317.5/1038");
        put("cyan_3",              "230/1038");
        put("jail_free",           "95/1056");
        put("purple_1",            "68/910");
        put("electric_company",    "68/822.5");
        put("purple_2",            "68/735");
        put("purple_3",            "68/647.5");
        put("railroad_2",          "68/560");
        put("orange_1",            "68/472.5");
        put("community_chest_2",   "68/385");
        put("orange_2",            "68/297.5");
        put("orange_3",            "68/210");
        put("free_parking",        "135/50");
        put("red_1",               "232/42");
        put("lucky_2",             "319.5/42");
        put("red_2",               "407/42");
        put("red_3",               "494.5/42");
        put("railroad_3",          "582/42");
        put("yellow_1",            "669.5/42");
        put("yellow_2",            "757/42");
        put("water_company",       "844.5/42");
        put("yellow_3",            "932/42");
        put("go_to_jail",          "1055/120");
        put("green_1",             "1055/210");
        put("green_2",             "1055/297.5");
        put("community_chest_3",   "1055/385");
        put("green_3",             "1055/472.5");
        put("railroad_4",          "1055/560");
        put("lucky_3",             "1055/647.5");
        put("blue_1",              "1055/735");
        put("luxury_tax",          "1055/822.5");
        put("blue_2",              "1055/910");
        put("jail",                "95/1010");
    }};

    private Map<String, String> triplePlayerOnTileMap1 = new HashMap<>() {{
        put("start",               "1000/960");
        put("brown_1",             "890/1038");
        put("community_chest_1",   "802.5/1038");
        put("brown_2",             "715/1038");
        put("income_taxes",        "627.5/1038");
        put("railroad_1",          "540/1038");
        put("cyan_1",              "452.5/1038");
        put("lucky_1",             "365/1038");
        put("cyan_2",              "277.5/1038");
        put("cyan_3",              "190/1038");
        put("jail_free",           "140/1056");
        put("purple_1",            "68/870");
        put("electric_company",    "68/782.5");
        put("purple_2",            "68/695");
        put("purple_3",            "68/607.5");
        put("railroad_2",          "68/520");
        put("orange_1",            "68/432.5");
        put("community_chest_2",   "68/345");
        put("orange_2",            "68/257.5");
        put("orange_3",            "68/170");
        put("free_parking",        "135/100");
        put("red_1",               "192/42");
        put("lucky_2",             "279.5/42");
        put("red_2",               "367/42");
        put("red_3",               "454.5/42");
        put("railroad_3",          "542/42");
        put("yellow_1",            "629.5/42");
        put("yellow_2",            "717/42");
        put("water_company",       "804.5/42");
        put("yellow_3",            "892/42");
        put("go_to_jail",          "1005/120");
        put("green_1",             "1055/170");
        put("green_2",             "1055/257.5");
        put("community_chest_3",   "1055/345");
        put("green_3",             "1055/432.5");
        put("railroad_4",          "1055/520");
        put("lucky_3",             "1055/607.5");
        put("blue_1",              "1055/695");
        put("luxury_tax",          "1055/782.5");
        put("blue_2",              "1055/870");
        put("jail",                "140/1010");
    }};

    private Map<String, String> triplePlayerOnTileMap2 = new HashMap<>() {{
        put("start",               "1050/960");
        put("brown_1",             "930/1038");          
        put("community_chest_1",   "842.5/1038");   
        put("brown_2",             "755/1038");
        put("income_taxes",        "667.5/1038");
        put("railroad_1",          "580/1038");
        put("cyan_1",              "492.5/1038");
        put("lucky_1",             "405/1038");
        put("cyan_2",              "317.5/1038");
        put("cyan_3",              "230/1038");
        put("jail_free",           "95/1056");
        put("purple_1",            "68/910");
        put("electric_company",    "68/822.5");
        put("purple_2",            "68/735");
        put("purple_3",            "68/647.5");
        put("railroad_2",          "68/560");
        put("orange_1",            "68/472.5");
        put("community_chest_2",   "68/385");
        put("orange_2",            "68/297.5");
        put("orange_3",            "68/210");
        put("free_parking",        "135/50");
        put("red_1",               "232/42");
        put("lucky_2",             "319.5/42");
        put("red_2",               "407/42");
        put("red_3",               "494.5/42");
        put("railroad_3",          "582/42");
        put("yellow_1",            "669.5/42");
        put("yellow_2",            "757/42");
        put("water_company",       "844.5/42");
        put("yellow_3",            "932/42");
        put("go_to_jail",          "1055/120");
        put("green_1",             "1055/210");
        put("green_2",             "1055/297.5");
        put("community_chest_3",   "1055/385");
        put("green_3",             "1055/472.5");
        put("railroad_4",          "1055/560");
        put("lucky_3",             "1055/647.5");
        put("blue_1",              "1055/735");
        put("luxury_tax",          "1055/822.5");
        put("blue_2",              "1055/910");
        put("jail",                "95/1010");
    }};

    private Map<String, String> triplePlayerOnTileMap3 = new HashMap<>() {{
        put("start",               "1000/960");
        put("brown_1",             "910/1018");
        put("community_chest_1",   "822.5/1018");   
        put("brown_2",             "735/1018");
        put("income_taxes",        "647.5/1018");
        put("railroad_1",          "560/1018");
        put("cyan_1",              "472.5/1018");
        put("lucky_1",             "385/1018");
        put("cyan_2",              "297.5/1018");
        put("cyan_3",              "210/1018");
        put("jail_free",           "45/1056");
        put("purple_1",            "88/890");
        put("electric_company",    "88/802.5");
        put("purple_2",            "88/715");
        put("purple_3",            "88/627.5");
        put("railroad_2",          "88/540");
        put("orange_1",            "88/452.5");
        put("community_chest_2",   "88/365");
        put("orange_2",            "88/277.5");
        put("orange_3",            "88/190");
        put("free_parking",        "90/100");
        put("red_1",               "212/62");
        put("lucky_2",             "299.5/62");
        put("red_2",               "387/62");
        put("red_3",               "474.5/62");
        put("railroad_3",          "562/62");
        put("yellow_1",            "649.5/62");
        put("yellow_2",            "737/62");
        put("water_company",       "824.5/62");
        put("yellow_3",            "912/62");
        put("go_to_jail",          "1005/120");
        put("green_1",             "1035/190");
        put("green_2",             "1035/277.5");
        put("community_chest_3",   "1035/365");
        put("green_3",             "1035/452.5");
        put("railroad_4",          "1035/540");
        put("lucky_3",             "1035/627.5");
        put("blue_1",              "1035/715");
        put("luxury_tax",          "1035/802.5");
        put("blue_2",              "1035/890");
        put("jail",                "140/960");
    }};

    private Map<String, String> quadruplePlayerOnTileMap1 = new HashMap<>() {{
        put("start",               "1000/960");
        put("brown_1",             "890/1038");
        put("community_chest_1",   "802.5/1038");
        put("brown_2",             "715/1038");
        put("income_taxes",        "627.5/1038");
        put("railroad_1",          "540/1038");
        put("cyan_1",              "452.5/1038");
        put("lucky_1",             "365/1038");
        put("cyan_2",              "277.5/1038");
        put("cyan_3",              "190/1038");
        put("jail_free",           "140/1056");
        put("purple_1",            "68/870");
        put("electric_company",    "68/782.5");
        put("purple_2",            "68/695");
        put("purple_3",            "68/607.5");
        put("railroad_2",          "68/520");
        put("orange_1",            "68/432.5");
        put("community_chest_2",   "68/345");
        put("orange_2",            "68/257.5");
        put("orange_3",            "68/170");
        put("free_parking",        "135/100");
        put("red_1",               "192/42");
        put("lucky_2",             "279.5/42");
        put("red_2",               "367/42");
        put("red_3",               "454.5/42");
        put("railroad_3",          "542/42");
        put("yellow_1",            "629.5/42");
        put("yellow_2",            "717/42");
        put("water_company",       "804.5/42");
        put("yellow_3",            "892/42");
        put("go_to_jail",          "1005/120");
        put("green_1",             "1055/170");
        put("green_2",             "1055/257.5");
        put("community_chest_3",   "1055/345");
        put("green_3",             "1055/432.5");
        put("railroad_4",          "1055/520");
        put("lucky_3",             "1055/607.5");
        put("blue_1",              "1055/695");
        put("luxury_tax",          "1055/782.5");
        put("blue_2",              "1055/870");
        put("jail",                "140/1010");
    }};

    private Map<String, String> quadruplePlayerOnTileMap2 = new HashMap<>() {{
        put("start",               "1050/960");
        put("brown_1",             "930/1038");          
        put("community_chest_1",   "842.5/1038");   
        put("brown_2",             "755/1038");
        put("income_taxes",        "667.5/1038");
        put("railroad_1",          "580/1038");
        put("cyan_1",              "492.5/1038");
        put("lucky_1",             "405/1038");
        put("cyan_2",              "317.5/1038");
        put("cyan_3",              "230/1038");
        put("jail_free",           "95/1056");
        put("purple_1",            "68/910");
        put("electric_company",    "68/822.5");
        put("purple_2",            "68/735");
        put("purple_3",            "68/647.5");
        put("railroad_2",          "68/560");
        put("orange_1",            "68/472.5");
        put("community_chest_2",   "68/385");
        put("orange_2",            "68/297.5");
        put("orange_3",            "68/210");
        put("free_parking",        "135/50");
        put("red_1",               "232/42");
        put("lucky_2",             "319.5/42");
        put("red_2",               "407/42");
        put("red_3",               "494.5/42");
        put("railroad_3",          "582/42");
        put("yellow_1",            "669.5/42");
        put("yellow_2",            "757/42");
        put("water_company",       "844.5/42");
        put("yellow_3",            "932/42");
        put("go_to_jail",          "1055/120");
        put("green_1",             "1055/210");
        put("green_2",             "1055/297.5");
        put("community_chest_3",   "1055/385");
        put("green_3",             "1055/472.5");
        put("railroad_4",          "1055/560");
        put("lucky_3",             "1055/647.5");
        put("blue_1",              "1055/735");
        put("luxury_tax",          "1055/822.5");
        put("blue_2",              "1055/910");
        put("jail",                "95/1010");
    }};

    private Map<String, String> quadruplePlayerOnTileMap3 = new HashMap<>() {{
        put("start",               "1000/960");
        put("brown_1",             "890/993");
        put("community_chest_1",   "802.5/993");
        put("brown_2",             "715/993");
        put("income_taxes",        "627.5/993");
        put("railroad_1",          "540/993");
        put("cyan_1",              "452.5/993");
        put("lucky_1",             "365/993");
        put("cyan_2",              "277.5/993");
        put("cyan_3",              "190/993");
        put("jail_free",           "45/1056");
        put("purple_1",            "113/870");
        put("electric_company",    "113/782.5");
        put("purple_2",            "113/695");
        put("purple_3",            "113/607.5");
        put("railroad_2",          "113/520");
        put("orange_1",            "113/432.5");
        put("community_chest_2",   "113/345");
        put("orange_2",            "113/257.5");
        put("orange_3",            "113/170");
        put("free_parking",        "90/100");
        put("red_1",               "192/87");
        put("lucky_2",             "279.5/87");
        put("red_2",               "367/87");
        put("red_3",               "454.5/87");
        put("railroad_3",          "542/87");
        put("yellow_1",            "629.5/87");
        put("yellow_2",            "717/87");
        put("water_company",       "804.5/87");
        put("yellow_3",            "892/87");
        put("go_to_jail",          "1005/120");
        put("green_1",             "1010/170");
        put("green_2",             "1010/257.5");
        put("community_chest_3",   "1010/345");
        put("green_3",             "1010/432.5");
        put("railroad_4",          "1010/520");
        put("lucky_3",             "1010/607.5");
        put("blue_1",              "1010/695");
        put("luxury_tax",          "1010/782.5");
        put("blue_2",              "1010/870");
        put("jail",                "140/960");
    }};

    private Map<String, String> quadruplePlayerOnTileMap4 = new HashMap<>() {{
        put("start",               "1050/960");
        put("brown_1",             "930/993");          
        put("community_chest_1",   "842.5/993");   
        put("brown_2",             "755/993");
        put("income_taxes",        "667.5/993");
        put("railroad_1",          "580/993");
        put("cyan_1",              "492.5/993");
        put("lucky_1",             "405/993");
        put("cyan_2",              "317.5/993");
        put("cyan_3",              "230/993");
        put("jail_free",           "45/1010");
        put("purple_1",            "113/910");
        put("electric_company",    "113/822.5");
        put("purple_2",            "113/735");
        put("purple_3",            "113/647.5");
        put("railroad_2",          "113/560");
        put("orange_1",            "113/472.5");
        put("community_chest_2",   "113/385");
        put("orange_2",            "113/297.5");
        put("orange_3",            "113/210");
        put("free_parking",        "90/50");
        put("red_1",               "232/87");
        put("lucky_2",             "319.5/87");
        put("red_2",               "407/87");
        put("red_3",               "494.5/87");
        put("railroad_3",          "582/87");
        put("yellow_1",            "669.5/87");
        put("yellow_2",            "757/87");
        put("water_company",       "844.5/87");
        put("yellow_3",            "932/87");
        put("go_to_jail",          "1010/120");
        put("green_1",             "1010/210");
        put("green_2",             "1010/297.5");
        put("community_chest_3",   "1010/385");
        put("green_3",             "1010/472.5");
        put("railroad_4",          "1010/560");
        put("lucky_3",             "1010/647.5");
        put("blue_1",              "1010/735");
        put("luxury_tax",          "1010/822.5");
        put("blue_2",              "1010/910");
        put("jail",                "95/960");
    }};

    List<Circle> playerCircles = new ArrayList<>();

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

    public int getRotation(int location) {
        if (location <= 10) return 0;
        else if (location <= 20) return 90;
        else if (location <= 30) return 180;
        else if (location <= 39) return 270;

        return 0;
    }

    public void moveTokens(int numPlayers, int playerPos , String name, Player player, int rotation) {
        int indexCircle = 8;
        if (player.getName() == GameManager.getInstance().getPlayerSelf().getName()) {
            indexCircle = 0;
        } else {
            for (int i = 0; i <= GameManager.getInstance().getPlayers().size(); i++) {
                if (player.getName() == GameManager.getInstance().getPlayers().get(i).getName()){
                    indexCircle = i + 1;
                }
            }
        }
        String value = "";
        String[] result;

        switch (numPlayers) {
            case 1:
                value = singlePlayerOnTileMap.get(name);
                result = value.split("/");
                PlayerToken.getInstance().getCircle().get(indexCircle).setCenterX(Double.parseDouble(result[0]));
                PlayerToken.getInstance().getCircle().get(indexCircle).setCenterY(Double.parseDouble(result[1]));
                PlayerToken.getInstance().getCircle().get(indexCircle).setRotate(rotation);
                break;
            case 2:
                if (playerPos == 1) value = doublePlayerOnTileMap1.get(name);
                if (playerPos == 2) value = doublePlayerOnTileMap2.get(name);
                result = value.split("/");
                PlayerToken.getInstance().getCircle().get(indexCircle).setCenterX(Double.parseDouble(result[0]));
                PlayerToken.getInstance().getCircle().get(indexCircle).setCenterY(Double.parseDouble(result[1]));
                PlayerToken.getInstance().getCircle().get(indexCircle).setRotate(rotation);
                break;
            case 3:
                if (playerPos == 1) value = triplePlayerOnTileMap1.get(name);
                if (playerPos == 2) value = triplePlayerOnTileMap2.get(name);
                if (playerPos == 3) value = triplePlayerOnTileMap3.get(name);
                result = value.split("/");
                PlayerToken.getInstance().getCircle().get(indexCircle).setCenterX(Double.parseDouble(result[0]));
                PlayerToken.getInstance().getCircle().get(indexCircle).setCenterY(Double.parseDouble(result[1]));
                PlayerToken.getInstance().getCircle().get(indexCircle).setRotate(rotation);
                break;
            case 4:
                if (playerPos == 1) value = quadruplePlayerOnTileMap1.get(name);
                if (playerPos == 2) value = quadruplePlayerOnTileMap2.get(name);
                if (playerPos == 3) value = quadruplePlayerOnTileMap3.get(name);
                if (playerPos == 4) value = quadruplePlayerOnTileMap4.get(name);
                result = value.split("/");
                PlayerToken.getInstance().getCircle().get(indexCircle).setCenterX(Double.parseDouble(result[0]));
                PlayerToken.getInstance().getCircle().get(indexCircle).setCenterY(Double.parseDouble(result[1]));
                PlayerToken.getInstance().getCircle().get(indexCircle).setRotate(rotation);
                break;
        
            default:
                break;
        }

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
