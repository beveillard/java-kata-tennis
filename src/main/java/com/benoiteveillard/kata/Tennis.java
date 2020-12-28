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

public class Tennis {

    public enum Player {PLAYER1, PLAYER2}

    private int player1points = 0;
    private int player2points = 0;
    private int player1games = 0;
    private int player2games = 0;

    public void score(Player player) {
        switch (player) {
            case PLAYER1:
                player1points++;
                if ((player1points > 3) && ((player1points - player2points) > 1)) {
                    player1games++;
                    resetGame();
                }
                break;
            case PLAYER2:
                player2points++;
                if ((player2points > 3) && ((player2points - player1points) > 1)) {
                    player2games++;
                    resetGame();
                }
                break;
        }
    }

    public String displayScore() {
        return displayGame() + " " + displaySet();
    }

    private String displayGame() {
        if ((player1points == player2points) && (player1points >= 3)) {
            return "Game: Deuce";
        }
        if ((player1points < 3) || (player2points < 3)) {
            return "Game: " + displayPoints0to3(player1points) + "-" + displayPoints0to3(player2points);
        }
        if (player1points > player2points) {
            return "Game: A-40";
        } else {
            return "Game: 40-A";
        }
    }

    private String displaySet() {
        return "Set: " + player1games + "-" + player2games;
    }

    private String displayPoints0to3(int points) {
        switch (points) {
            case 0:
                return "0";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                return "?";
        }
    }

    private void resetGame() {
        player1points = 0;
        player2points = 0;
    }
}
