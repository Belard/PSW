package com.jpmorgan;

class Position {
  boolean PLAYER_1;
  boolean PLAYER_2;
  boolean PLAYER_3;
  boolean PLAYER_4;
  boolean PLAYER_5;
  boolean PLAYER_6;
}

class Information {

  Position position = new Position();

  void set_position(player_list player) {
      switch(player) {
          case PLAYER_1:
            position.PLAYER_1 = true;
            break;
          case PLAYER_2:
            position.PLAYER_2 = true;
            break;
          case PLAYER_3:
            position.PLAYER_3 = true;
            break;
          case PLAYER_4:
            position.PLAYER_4 = true;
            break;
          case PLAYER_5:
            position.PLAYER_5 = true;
            break;
          case PLAYER_6:
            position.PLAYER_6 = true;
            break;
          default:
            break;
        }
    }

    void unset_position(player_list player) {
        switch(player) {
            case PLAYER_1:
              position.PLAYER_1 = false;
              break;
            case PLAYER_2:
              position.PLAYER_2 = false;
              break;
            case PLAYER_3:
              position.PLAYER_3 = false;
              break;
            case PLAYER_4:
              position.PLAYER_4 = false;
              break;
            case PLAYER_5:
              position.PLAYER_5 = false;
              break;
            case PLAYER_6:
              position.PLAYER_6 = false;
              break;
            default:
              break;
          }
    }

    Position get_position() {
      return position;
    }
}

public class Board {
    Information brown_1           = new Information();
    Information community_chest_1 = new Information();
    Information brown_2           = new Information();
    Information income_taxes      = new Information();
    Information railroad_1        = new Information();
    Information cyan_1            = new Information();
    Information lucky_1           = new Information();
    Information cyan_2            = new Information();
    Information cyan_3            = new Information();
    Information jail              = new Information();
    Information jail_free         = new Information();
    Information purple_1          = new Information();
    Information electric_company  = new Information();
    Information purple_2          = new Information();
    Information purple_3          = new Information();
    Information railroad_2        = new Information();
    Information orange_1          = new Information();
    Information community_chest_2 = new Information();
    Information orange_2          = new Information();
    Information orange_3          = new Information();
    Information free_parking      = new Information();
    Information red_1             = new Information();
    Information lucky_2           = new Information();
    Information red_2             = new Information();
    Information red_3             = new Information();
    Information railroad_3        = new Information();
    Information yellow_1          = new Information();
    Information yellow_2          = new Information();
    Information water_company     = new Information();
    Information yellow_3          = new Information();
    Information go_to_jail        = new Information();
    Information green_1           = new Information();
    Information green_2           = new Information();
    Information community_chest_3 = new Information();
    Information green_3           = new Information();
    Information railroad_4        = new Information();
    Information lucky_3           = new Information();
    Information blue_1            = new Information();
    Information luxury_tax        = new Information();
    Information blue_2            = new Information();
    Information start             = new Information();
}
