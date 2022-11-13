package com.jpmorgan;

enum action {
    GET_A_LUCKY_CARD,
    GET_A_COMMUNITY_CARD,
    GO_TO_JAIL,
    IN_JAIL,
    GET_PARKING_SPOT_MONEY,
    ACTION_ERROR
}

enum player_ownership {
    PLAYER_1,
    PLAYER_2,
    PLAYER_3,
    PLAYER_4,
    PLAYER_5,
    PLAYER_6,
    PLAYER_7,
    PLAYER_8,
    BANK
}

class Actions {
    player_ownership ownership;
    boolean mortage;
    int bank_sale_price;
    class Rent_Price {
        public int    single_tile;
        public int    group;
        public int    one_house;
        public int    two_house; 
        public int    three_house;
        public int    four_house;
        public int    hotel; 
    };

    int rent() {
       
        return 0;
    }
    action action() {
       
        return action.ACTION_ERROR;
    }
    void set_owner(player_ownership owner) {
        ownership = owner;
    }
    player_ownership get_owner() {
        return player_ownership.BANK;
    }
    int value() {
        return 0;
    }
    void set_mortage() {
        mortage = true;
    }
    void set_unmortage() {
        mortage = false;
    }
}

public class Properties extends Actions {
    public static void main(String[] args)   {
        Properties brown_1 = new Properties();
        brown_1.set_unmortage();
        Properties community_chest_1 = new Properties();
        Properties brown_2 = new Properties();
        brown_2.set_unmortage();
        Properties income_taxes = new Properties();
        Properties railroad_1 = new Properties();
        railroad_1.set_unmortage();
        Properties cyan_1 = new Properties();
        cyan_1.set_unmortage();
        Properties lucky_1 = new Properties();
        Properties cyan_2 = new Properties();
        cyan_2.set_unmortage();
        Properties cyan_3 = new Properties();
        cyan_3.set_unmortage();
        Properties jail = new Properties();
        Properties purple_1 = new Properties();
        purple_1.set_unmortage();
        Properties electric_company = new Properties();
        electric_company.set_unmortage();
        Properties purple_2 = new Properties();
        purple_2.set_unmortage();
        Properties purple_3 = new Properties();
        purple_3.set_unmortage();
        Properties railroad_2 = new Properties();
        railroad_2.set_unmortage();
        Properties orange_1 = new Properties();
        orange_1.set_unmortage();
        Properties community_chest_2 = new Properties();
        Properties orange_2 = new Properties();
        orange_2.set_unmortage();
        Properties orange_3 = new Properties();
        orange_3.set_unmortage();
        Properties free_parking = new Properties();
        Properties red_1 = new Properties();
        red_1.set_unmortage();
        Properties lucky_2 = new Properties();
        Properties red_2 = new Properties();
        red_2.set_unmortage();
        Properties red_3 = new Properties();
        red_3.set_unmortage();
        Properties railroad_3 = new Properties();
        railroad_3.set_unmortage();
        Properties yellow_1 = new Properties();
        yellow_1.set_unmortage();
        Properties yellow_2 = new Properties();
        yellow_2.set_unmortage();
        Properties water_company = new Properties();
        water_company.set_unmortage();
        Properties yellow_3 = new Properties();
        yellow_3.set_unmortage();
        Properties go_to_jail = new Properties();
        Properties green_1 = new Properties();
        green_1.set_unmortage();
        Properties green_2 = new Properties();
        green_2.set_unmortage();
        Properties community_chest_3 = new Properties();
        Properties green_3 = new Properties();
        green_3.set_unmortage();
        Properties railroad_4 = new Properties();
        railroad_4.set_unmortage();
        Properties lucky_3 = new Properties();
        Properties blue_1 = new Properties();
        blue_1.set_unmortage();
        Properties luxury_tax = new Properties();
        Properties blue_2 = new Properties();
        blue_2.set_unmortage();
        Properties start = new Properties();
    }
}
