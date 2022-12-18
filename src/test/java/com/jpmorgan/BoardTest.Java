package com.jpmorgan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class BoardTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        Board board = new Board();

        board.blue_2.set_position(player_list.PLAYER_1);
        board.blue_2.set_position(player_list.PLAYER_2);
        board.blue_2.set_position(player_list.PLAYER_6);

        Position position = board.blue_2.get_position();

        assertTrue(position.PLAYER_1);
        assertTrue(position.PLAYER_2);
        assertFalse(position.PLAYER_3);
        assertFalse(position.PLAYER_4);
        assertFalse(position.PLAYER_5);
        assertTrue(position.PLAYER_6);

        board.blue_2.unset_position(player_list.PLAYER_1);

        position = board.blue_2.get_position();

        assertFalse(position.PLAYER_1);
        assertTrue(position.PLAYER_2);
        assertFalse(position.PLAYER_3);
        assertFalse(position.PLAYER_4);
        assertFalse(position.PLAYER_5);
        assertTrue(position.PLAYER_6);

    }
}

