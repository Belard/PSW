package com.jpmorgan;

import com.jpmorgan.model.properties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class PropertiesTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        //Prep
        Properties properties = new Properties();
        //Pre-Setup
        assertEquals(properties.red_3.get_rent(), 0);
        assertEquals(properties.orange_2.get_rent(), 0);
        assertEquals(properties.brown_1.get_rent(), 0);
        assertEquals(properties.purple_1.get_rent(), 0);
        assertEquals(properties.cyan_3.get_rent(), 0);
        assertEquals(properties.yellow_1.get_rent(), 0);
        assertEquals(properties.blue_2.get_rent(), 0);
        assertEquals(properties.green_3.get_bank_sale_price(), 0);
        properties.green_3.set_mortage();
        assertTrue(properties.green_3.get_mortage());
        properties.green_3.unset_mortage();
        assertFalse(properties.green_3.get_mortage());
        //Setup
        properties.setup();
        //After Setup

        assertEquals(properties.red_2.get_rent(), 18);
        assertEquals(properties.orange_3.get_rent(), 16);
        assertEquals(properties.brown_2.get_rent(), 4);
        assertEquals(properties.purple_2.get_rent(), 10);
        assertEquals(properties.cyan_1.get_rent(), 6);
        assertEquals(properties.yellow_3.get_rent(), 24);
        assertEquals(properties.blue_1.get_rent(), 35);

        properties.red_2.set_group_tile();
        assertEquals(properties.red_2.get_rent(), 36);
        properties.orange_3.set_group_tile();
        properties.orange_3.add_house();
        assertEquals(properties.orange_3.get_rent(), 80);
        properties.brown_2.set_group_tile();
        properties.brown_2.add_house();
        properties.brown_2.add_house();
        assertEquals(properties.brown_2.get_rent(), 60);
        properties.purple_2.set_group_tile();
        properties.purple_2.add_house();
        properties.purple_2.add_house();
        properties.purple_2.add_house();
        assertEquals(properties.purple_2.get_rent(), 450);
        properties.cyan_1.set_group_tile();
        properties.cyan_1.add_house();
        properties.cyan_1.add_house();
        properties.cyan_1.add_house();
        properties.cyan_1.add_house();
        assertEquals(properties.cyan_1.get_rent(), 400);
        properties.yellow_3.set_group_tile();
        properties.yellow_3.add_house();
        properties.yellow_3.add_house();
        properties.yellow_3.add_house();
        properties.yellow_3.add_house();
        properties.yellow_3.add_house();
        assertEquals(properties.yellow_3.get_rent(), 1200);
        assertEquals(properties.blue_1.get_rent(), 35);
        assertEquals(properties.green_2.get_bank_sale_price(), 300);
        assertFalse(properties.green_1.get_mortage());
        properties.railroad_3.set_mortage();
        assertTrue(properties.railroad_3.get_mortage());
        //Jail
        properties.jail.SetJail(player_list.PLAYER_2);
        assertFalse(properties.jail.TurnOnJail(player_list.PLAYER_2));
        assertFalse(properties.jail.TurnOnJail(player_list.PLAYER_2));
        assertFalse(properties.jail.TurnOnJail(player_list.PLAYER_2));
        assertTrue(properties.jail.TurnOnJail(player_list.PLAYER_2));
        assertEquals(properties.jail.player2.turns_in_jail, 0);
        assertFalse(properties.jail.player2.in_jail);
    }
}
