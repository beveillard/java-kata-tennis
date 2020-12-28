/*
 * A tennis game is composed of points, games and sets. Below are exposed rules
 * of counting points within a game.
 * Your task is to write the logic witch outputs the correct score as a string
 * for display on the scoreboard. When a player scores a point, it triggers a
 * method 'score()' to be called on your class letting you know who scored the
 * point. Later, you will get call 'displayScore()' from the scoreboard asking
 * what it should display. This method should return a string with the current
 * score.
 *
 * - Each player can have either of these points in one game: 0, 15, 30 and 40.
 * - If you have 40 and you win the ball, you win the game.
 * - However:
 *      If both have 40 the players are "deuce".
 *      If the game is deuce, the winner of a ball will have "advantage".
 *      If the player with advantage wins the ball he wins the game.
 *      If the player without advantage wins they are back at deuce.
 */

package com.benoiteveillard.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisTests {

    @Test
    @DisplayName("Test match initialization")
    void testMatchInitialization() {
        Tennis tennis = new Tennis();
        assertEquals("Game: 0-0 Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 1 scores 15")
    void testPlayer1Scores15() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER1);
        assertEquals("Game: 15-0 Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 1 scores 30")
    void testPlayer1Scores30() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        assertEquals("Game: 30-0 Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 1 scores 40")
    void testPlayer1Scores40() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        assertEquals("Game: 40-0 Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 1 wins the game")
    void testPlayer1WinsTheGame() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        assertEquals("Game: 0-0 Set: 1-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 2 scores 40")
    void testPlayer2Scores40() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        assertEquals("Game: 0-40 Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 2 wins the game")
    void testPlayer2WinsTheGame() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        assertEquals("Game: 0-0 Set: 0-1", tennis.displayScore());
    }

    @Test
    @DisplayName("Test players are deuce")
    void testPlayersAreDeuce() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        assertEquals("Game: Deuce Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 1 has advantage")
    void testPlayer1HasAdvantage() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        assertEquals("Game: A-40 Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 2 has advantage")
    void testPlayer2HasAdvantage() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        assertEquals("Game: 40-A Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test players are deuce again")
    void testPlayersAreDeuceAgain() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER1);
        assertEquals("Game: Deuce Set: 0-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 1 has advantage then wins")
    void testPlayer1HasAdvantageThenWins() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        assertEquals("Game: 0-0 Set: 1-0", tennis.displayScore());
    }

    @Test
    @DisplayName("Test player 2 has advantage then wins")
    void testPlayer2HasAdvantageThenWins() {
        Tennis tennis = new Tennis();
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER1);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        tennis.score(Tennis.Player.PLAYER2);
        assertEquals("Game: 0-0 Set: 0-1", tennis.displayScore());
    }
}
