package com.jpmorgan.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scala.util.Random;

public class Player2 {

    private static Player2 instance;

    PInfo player1 = new PInfo();
    PInfo player2 = new PInfo();
    PInfo player3 = new PInfo();
    PInfo player4 = new PInfo();
    PInfo player5 = new PInfo();
    PInfo player6 = new PInfo();

    private Map<String, PInfo> playersMap = new HashMap<>() {{
        put("Player1", player1);
        put("Player2", player2);
        put("Player3", player3);
        put("Player4", player4);
        put("Player5", player5);
        put("Player6", player6);
    }};

    public PInfo getPlayerInstance(String playersName) {
        if (!playersMap.containsKey(playersName)) {
            throw new IllegalArgumentException("Could not find player " + playersName);
        }

        PInfo root = playersMap.get(playersName);

        return root;
    }
   
    public static Player2 getInstance() {
        if (instance == null) {
            instance = new Player2();
        }

        return instance;
    }

    public int roll_dice() {
        Random random = new Random();
        return random.nextInt(6)+1;
    }

}
