package com.jpmorgan;

enum action_list {
    GET_A_LUCKY_CARD,
    GET_A_COMMUNITY_CARD,
    GO_TO_JAIL,
    IN_JAIL,
    JUST_VISITING,
    GET_PARKING_SPOT_MONEY,
    ACTION_ERROR,
    GET_START_MONEY
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
    action_list action;
    class Rent_Price {
        public int    single_tile;
        public int    group;
        public int    one_house;
        public int    two_house; 
        public int    three_house;
        public int    four_house;
        public int    hotel; 
    };
    Rent_Price rent = new Rent_Price();

    int rent() {
       
        return 0;
    }
    void set_action(action_list action_set) {
       
        action = action_set;
    }
    action_list get_action() {
       
        return action;
    }
    void set_owner(player_ownership owner) {
        ownership = owner;
    }
    player_ownership get_owner() {
        return player_ownership.BANK;
    }
    void set_rent(int houses, int price) {
        switch(houses) {
            case 0:
              rent.group = price;
              break;
            case 1:
              rent.one_house = price;
              break;
            case 2:
              rent.two_house = price;
              break;
            case 3:
              rent.three_house = price;
              break;
            case 4:
              rent.four_house = price;
              break;
            case 5:
              rent.hotel = price;
              break;
            case 6:
              rent.single_tile = price;
              break;
            default:
              break;
          }
    }
    int get_rent(int houses) {
        switch(houses) {
            case 0:
              return rent.group;
            case 1:
              return rent.one_house;
            case 2:
              return rent.two_house;
            case 3:
              return rent.three_house;
            case 4:
              return rent.four_house;
            case 5:
              return rent.hotel;
            case 6:
              return rent.single_tile;
            default:
              return 0;
          }
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

class Properties {
    Actions brown_1           = new Actions();
    Actions community_chest_1 = new Actions();
    Actions brown_2           = new Actions();
    Actions income_taxes      = new Actions();
    Actions railroad_1        = new Actions();
    Actions cyan_1            = new Actions();
    Actions lucky_1           = new Actions();
    Actions cyan_2            = new Actions();
    Actions cyan_3            = new Actions();
    Actions purple_1          = new Actions();
    Actions electric_company  = new Actions();
    Actions purple_2          = new Actions();
    Actions purple_3          = new Actions();
    Actions railroad_2        = new Actions();
    Actions orange_1          = new Actions();
    Actions community_chest_2 = new Actions();
    Actions orange_2          = new Actions();
    Actions orange_3          = new Actions();
    Actions free_parking      = new Actions();
    Actions red_1             = new Actions();
    Actions lucky_2           = new Actions();
    Actions red_2             = new Actions();
    Actions red_3             = new Actions();
    Actions railroad_3        = new Actions();
    Actions yellow_1          = new Actions();
    Actions yellow_2          = new Actions();
    Actions water_company     = new Actions();
    Actions yellow_3          = new Actions();
    Actions go_to_jail        = new Actions();
    Actions green_1           = new Actions();
    Actions green_2           = new Actions();
    Actions community_chest_3 = new Actions();
    Actions green_3           = new Actions();
    Actions railroad_4        = new Actions();
    Actions lucky_3           = new Actions();
    Actions blue_1            = new Actions();
    Actions luxury_tax        = new Actions();
    Actions blue_2            = new Actions();
    Actions start             = new Actions();


    public void setup()   {
        brown_1.set_unmortage();
        brown_1.set_rent(0, 4);
        brown_1.set_rent(1, 10);
        brown_1.set_rent(2, 30);
        brown_1.set_rent(3, 90);
        brown_1.set_rent(4, 160);
        brown_1.set_rent(5, 250);
        brown_1.set_rent(6, 2);
        community_chest_1.set_action(action_list.GET_A_COMMUNITY_CARD);
        brown_2.set_unmortage();
        brown_2.set_rent(0, 8);
        brown_2.set_rent(1, 20);
        brown_2.set_rent(2, 60);
        brown_2.set_rent(3, 180);
        brown_2.set_rent(4, 320);
        brown_2.set_rent(5, 450);
        brown_2.set_rent(6, 4);
        income_taxes.set_rent(0, 200);
        railroad_1.set_unmortage();
        railroad_1.set_rent(1, 25);
        railroad_1.set_rent(2, 50);
        railroad_1.set_rent(3, 100);
        railroad_1.set_rent(4, 200);
        cyan_1.set_unmortage();
        cyan_1.set_rent(0, 12);
        cyan_1.set_rent(1, 30);
        cyan_1.set_rent(2, 90);
        cyan_1.set_rent(3, 270);
        cyan_1.set_rent(4, 400);
        cyan_1.set_rent(5, 550);
        cyan_1.set_rent(6, 6);
        lucky_1.set_action(action_list.GET_A_LUCKY_CARD);
        cyan_2.set_unmortage();
        cyan_2.set_rent(0, 12);
        cyan_2.set_rent(1, 30);
        cyan_2.set_rent(2, 90);
        cyan_2.set_rent(3, 270);
        cyan_2.set_rent(4, 400);
        cyan_2.set_rent(5, 550);
        cyan_2.set_rent(6, 6);
        cyan_3.set_unmortage();
        cyan_3.set_rent(0, 16);
        cyan_3.set_rent(1, 40);
        cyan_3.set_rent(2, 100);
        cyan_3.set_rent(3, 300);
        cyan_3.set_rent(4, 450);
        cyan_3.set_rent(5, 600);
        cyan_3.set_rent(6, 8);       
        purple_1.set_unmortage();
        purple_1.set_rent(0, 20);
        purple_1.set_rent(1, 50);
        purple_1.set_rent(2, 150);
        purple_1.set_rent(3, 450);
        purple_1.set_rent(4, 625);
        purple_1.set_rent(5, 750);
        purple_1.set_rent(6, 10);
        electric_company.set_unmortage();
        electric_company.set_rent(1, 4);
        electric_company.set_rent(2, 10);
        purple_2.set_unmortage();
        purple_2.set_rent(0, 20);
        purple_2.set_rent(1, 50);
        purple_2.set_rent(2, 150);
        purple_2.set_rent(3, 450);
        purple_2.set_rent(4, 625);
        purple_2.set_rent(5, 750);
        purple_2.set_rent(6, 10);
        purple_3.set_unmortage();
        purple_3.set_rent(0, 24);
        purple_3.set_rent(1, 60);
        purple_3.set_rent(2, 180);
        purple_3.set_rent(3, 500);
        purple_3.set_rent(4, 700);
        purple_3.set_rent(5, 900);
        purple_3.set_rent(6, 12);
        railroad_2.set_unmortage();
        railroad_2.set_rent(1, 25);
        railroad_2.set_rent(2, 50);
        railroad_2.set_rent(3, 100);
        railroad_2.set_rent(4, 200);
        orange_1.set_unmortage();
        orange_1.set_rent(0, 28);
        orange_1.set_rent(1, 70);
        orange_1.set_rent(2, 200);
        orange_1.set_rent(3, 550);
        orange_1.set_rent(4, 750);
        orange_1.set_rent(5, 950);
        orange_1.set_rent(6, 14);
        community_chest_2.set_action(action_list.GET_A_COMMUNITY_CARD);
        orange_2.set_unmortage();
        orange_2.set_rent(0, 28);
        orange_2.set_rent(1, 70);
        orange_2.set_rent(2, 200);
        orange_2.set_rent(3, 550);
        orange_2.set_rent(4, 750);
        orange_2.set_rent(5, 950);
        orange_2.set_rent(6, 14);
        orange_3.set_unmortage();
        orange_3.set_rent(0, 32);
        orange_3.set_rent(1, 80);
        orange_3.set_rent(2, 220);
        orange_3.set_rent(3, 600);
        orange_3.set_rent(4, 800);
        orange_3.set_rent(5, 1000);
        orange_3.set_rent(6, 16);
        free_parking.set_action(action_list.GET_PARKING_SPOT_MONEY);
        red_1.set_unmortage();
        red_1.set_rent(0, 36);
        red_1.set_rent(1, 90);
        red_1.set_rent(2, 250);
        red_1.set_rent(3, 700);
        red_1.set_rent(4, 875);
        red_1.set_rent(5, 1050);
        red_1.set_rent(6, 18);
        lucky_2.set_action(action_list.GET_A_LUCKY_CARD);
        red_2.set_unmortage();
        red_2.set_rent(0, 36);
        red_2.set_rent(1, 90);
        red_2.set_rent(2, 250);
        red_2.set_rent(3, 700);
        red_2.set_rent(4, 875);
        red_2.set_rent(5, 1050);
        red_2.set_rent(6, 18);
        red_3.set_unmortage();
        red_3.set_rent(0, 40);
        red_3.set_rent(1, 100);
        red_3.set_rent(2, 300);
        red_3.set_rent(3, 750);
        red_3.set_rent(4, 925);
        red_3.set_rent(5, 1100);
        red_3.set_rent(6, 20);
        railroad_3.set_unmortage();
        railroad_3.set_rent(1, 25);
        railroad_3.set_rent(2, 50);
        railroad_3.set_rent(3, 100);
        railroad_3.set_rent(4, 200);
        yellow_1.set_unmortage();
        yellow_1.set_rent(0, 44);
        yellow_1.set_rent(1, 110);
        yellow_1.set_rent(2, 330);
        yellow_1.set_rent(3, 800);
        yellow_1.set_rent(4, 975);
        yellow_1.set_rent(5, 1150);
        yellow_1.set_rent(6, 22);
        yellow_2.set_unmortage();
        yellow_2.set_rent(0, 44);
        yellow_2.set_rent(1, 110);
        yellow_2.set_rent(2, 330);
        yellow_2.set_rent(3, 800);
        yellow_2.set_rent(4, 975);
        yellow_2.set_rent(5, 1150);
        yellow_2.set_rent(6, 22);
        water_company.set_unmortage();
        water_company.set_rent(1, 4);
        water_company.set_rent(2, 10);
        yellow_3.set_unmortage();
        yellow_3.set_rent(0, 48);
        yellow_3.set_rent(1, 120);
        yellow_3.set_rent(2, 360);
        yellow_3.set_rent(3, 850);
        yellow_3.set_rent(4, 1025);
        yellow_3.set_rent(5, 1200);
        yellow_3.set_rent(6, 24);
        go_to_jail.set_action(action_list.GO_TO_JAIL);
        green_1.set_unmortage();
        green_1.set_rent(0, 52);
        green_1.set_rent(1, 130);
        green_1.set_rent(2, 390);
        green_1.set_rent(3, 900);
        green_1.set_rent(4, 1100);
        green_1.set_rent(5, 1275);
        green_1.set_rent(6, 26);
        green_2.set_unmortage();
        green_2.set_rent(0, 52);
        green_2.set_rent(1, 130);
        green_2.set_rent(2, 390);
        green_2.set_rent(3, 900);
        green_2.set_rent(4, 1100);
        green_2.set_rent(5, 1275);
        green_2.set_rent(6, 26);
        community_chest_3.set_action(action_list.GET_A_COMMUNITY_CARD);
        green_3.set_unmortage();
        green_3.set_rent(0, 56);
        green_3.set_rent(1, 150);
        green_3.set_rent(2, 450);
        green_3.set_rent(3, 1000);
        green_3.set_rent(4, 1200);
        green_3.set_rent(5, 1400);
        green_3.set_rent(6, 28);
        railroad_4.set_unmortage();
        railroad_4.set_rent(1, 25);
        railroad_4.set_rent(2, 50);
        railroad_4.set_rent(3, 100);
        railroad_4.set_rent(4, 200);
        lucky_3.set_action(action_list.GET_A_LUCKY_CARD);
        blue_1.set_unmortage();
        blue_1.set_rent(0, 70);
        blue_1.set_rent(1, 175);
        blue_1.set_rent(2, 500);
        blue_1.set_rent(3, 1100);
        blue_1.set_rent(4, 1300);
        blue_1.set_rent(5, 1500);
        blue_1.set_rent(6, 35);
        luxury_tax.set_rent(0, 100);
        blue_2.set_unmortage();
        blue_2.set_rent(0, 100);
        blue_2.set_rent(1, 200);
        blue_2.set_rent(2, 600);
        blue_2.set_rent(3, 1400);
        blue_2.set_rent(4, 1700);
        blue_2.set_rent(5, 2000);
        blue_2.set_rent(6, 50);
        start.set_action(action_list.GET_START_MONEY);
        //System.out.println("Hello " + free_parking.get_action());
    }
}
