package com.jpmorgan;

import scala.util.Random;

class PInfo {

    //Variables
    int money = 0;
    player_list player_number;
    String username;

    properties_in_possession possessions = new properties_in_possession();

    class properties_in_possession{

        boolean brown_1 = false;
        boolean brown_2 = false;
        boolean railroad_1 = false;
        boolean cyan_1 = false;
        boolean cyan_2 = false;
        boolean cyan_3 = false;
        boolean purple_1 = false;
        boolean electric_company = false;
        boolean purple_2 = false;
        boolean purple_3 = false;
        boolean railroad_2 = false;
        boolean orange_1 = false;
        boolean orange_2 = false;
        boolean orange_3 = false;
        boolean red_1 = false;
        boolean red_2 = false;
        boolean red_3 = false;
        boolean railroad_3 = false;
        boolean yellow_1 = false;
        boolean yellow_2 = false;
        boolean water_company = false;
        boolean yellow_3 = false;
        boolean green_1 = false;
        boolean green_2 = false;
        boolean green_3 = false;
        boolean railroad_4 = false;
        boolean blue_1 = false;
        boolean blue_2 = false;
    }

    //Methods
    void set_player_username(String get_username) {

        username = get_username;
    }

    String get_player_username() {

        return username;
    }

    void set_player_number(player_list new_player) {

        player_number = new_player;
    }

    player_list get_player_number() {

        return player_number;
    }

    int roll_dice() {

        Random random = new Random();
        return random.nextInt(6)+1;
    }

    int roll_dice_final() {
        int i = roll_dice();
        int x = roll_dice();
        return x + i;
    }

    void set_property(properties_list property) {

        switch (property) {
            case Brown_1:
                possessions.brown_1 = true;
                break;
            case Brown_2:
                possessions.brown_2 = true;
                break;
            case Railroad_1:
                possessions.railroad_1 = true;
                break;
            case Cyan_1:
                possessions.cyan_1 = true;
                break;
            case Cyan_2:
                possessions.cyan_2 = true;
                break;
            case Cyan_3:
                possessions.cyan_3 = true;
                break;
            case Purple_1:
                possessions.purple_1 = true;
                break;
            case Electric_company:
                possessions.electric_company = true;
                break;
            case Purple_2:
                possessions.purple_2 = true;
                break;
            case Purple_3:
                possessions.purple_3 = true;
                break;
            case Railroad_2:
                possessions.railroad_2 = true;
                break;
            case Orange_1:
                possessions.orange_1 = true;
                break;
            case Orange_2:
                possessions.orange_2 = true;
                break;
            case Orange_3:
                possessions.orange_3 = true;
                break;
            case Red_1:
                possessions.red_1 = true;
                break;
            case Red_2:
                possessions.red_2 = true;
                break;
            case Red_3:
                possessions.red_3 = true;
                break;
            case Railroad_3:
                possessions.railroad_3 = true;
                break;
            case Yellow_1:
                possessions.yellow_1 = true;
                break;
            case Yellow_2:
                possessions.yellow_2 = true;
                break;
            case Water_company:
                possessions.water_company = true;
                break;
            case Yellow_3:
                possessions.yellow_3 = true;
                break;
            case Green_1:
                possessions.green_1 = true;
                break;
            case Green_2:
                possessions.green_2 = true;
                break;
            case Green_3:
                possessions.green_3 = true;
                break;
            case Railroad_4:
                possessions.railroad_4 = true;
                break;
            case Blue_1:
                possessions.blue_1 = true;
                break;
            case Blue_2:
                possessions.blue_2 = true;
                break;
        }
    }

    void buy_property(Actions property_to_buy, player_list player_buying) {

        property_to_buy.set_owner(player_number);
        sub_money(property_to_buy.get_bank_sale_price());
        set_property(property_to_buy.get_property_name());
    }

    void add_money(int money_new) {
        money = money + money_new;
    }

    void sub_money(int money_new) {
        money = money - money_new;
    }

    int get_money() {
        return money;
    }

    void pay_rent(PInfo player_renting, int rent) {

        sub_money(rent);
        player_renting.add_money(rent);
    }

    void build_house(Actions property_to_build_house) {

        property_to_build_house.add_house();
    }

}

public class Player {

    Actions player1 = new Actions();
    Actions player2 = new Actions();
    Actions player3 = new Actions();
    Actions player4 = new Actions();
    Actions player5 = new Actions();
    Actions player6 = new Actions();

}
