package com.jpmorgan;

import scala.util.Random;

public class Player {

    //Variables
    int money = 0;
    player_list player_number;


    //Methods
    String get_player_username(String get_username) {

        String username = get_username;
        return username;
    }

    void setPlayer_number(player_list new_player) {

        player_number = new_player;
    }

    int roll_dice(){

        Random random = new Random();
        return random.nextInt(6)+1;
    }

    void buy_property(Actions property_to_buy, player_ownership player_buying) {

        property_to_buy.set_owner(player_buying);
        money = money - property_to_buy.get_bank_sale_price();
    }

    void pay_rent(Actions property_to_pay_rent, player_ownership player_receiving, Player owner) {

        money = money - property_to_pay_rent.get_rent();
        owner.money = owner.money + property_to_pay_rent.get_rent()
    }

    void build_house(Actions property_to_build_house) {

        property_to_build_house.add_house();
    }
    
}
