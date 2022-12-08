package com.jpmorgan;

import scala.util.Random;

class PInfo {

    //Variables
    int money = 0;
    player_list player_number;
    String username;

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

    void buy_property(Actions property_to_buy, player_list player_buying) {

        property_to_buy.set_owner(player_number);
        sub_money(property_to_buy.get_bank_sale_price());
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
