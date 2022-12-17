package com.jpmorgan.model;



public class PInfo {

    //Variables
    int money = 0;
    player_list player_number;
    String username;

    //Methods
    public void set_player_username(String get_username) {

        username = get_username;
    }
    
    public String get_player_username() {

        return username;
    }

    public void set_player_number(player_list new_player) {

        player_number = new_player;
    }

    public player_list get_player_number() {

        return player_number;
    }

    public void buy_property(Actions property_to_buy, player_list player_buying) {

        property_to_buy.set_owner(player_number);
        sub_money(property_to_buy.get_bank_sale_price());
    }

    public void add_money(int money_new) {
        money = money + money_new;
    }

    public void sub_money(int money_new) {
        money = money - money_new;
    }

    public int get_money() {
        return money;
    }

    public void pay_rent(PInfo player_renting, int rent) {

        sub_money(rent);
        player_renting.add_money(rent);
    }

    public void build_house(Actions property_to_build_house) {

        property_to_build_house.add_house();
    }

}
