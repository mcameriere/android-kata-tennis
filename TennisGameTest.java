package com.hfad.tennis;

import org.junit.Test;

import static org.junit.Assert.*;

public class TennisGameTest {

    @Test
    public void getDisplayedScore_returns0_0_forNewGame() {
        TennisGame newGame = new TennisGame();
        assertEquals("0 : 0", newGame.getDisplayedScore());
    }

    @Test
    public void getDisplayedScore_returns15_0() {
        TennisGame game = new TennisGame();
        setScore(game, 1,0);
        assertEquals("15 : 0", game.getDisplayedScore());
    }

    @Test
    public void getDisplayedScore_returns30_0() {
        TennisGame game = new TennisGame();
        setScore(game, 2, 0);
        assertEquals("30 : 0", game.getDisplayedScore());
    }

    @Test
    public void getDisplayedScore_returns40_0() {
        TennisGame game = new TennisGame();
        setScore(game, 3, 0);
        assertEquals("40 : 0", game.getDisplayedScore());
    }

    @Test
    public void getDisplayedScore_returnsPlayerOneWins() {
        TennisGame game = new TennisGame();
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();
        assertEquals("PLAYER ONE WINS", game.getDisplayedScore());
    }

    @Test
    public void getDisplayedScore_returns40_30() {
        TennisGame game = new TennisGame();
        setScore(game, 3, 2);
        assertEquals("40 : 30", game.getDisplayedScore());
    }

    @Test
    public void getPlayerTwoScore_returns40_afterPlayerTwoWinsThreePoints() {
        TennisGame game = new TennisGame();
        setScore(game, 0, 3);
        assertEquals("0 : 40", game.getDisplayedScore());
    }

    @Test
    public void isDeuce_returnsTrue_whenBothPlayersHave40() {
        TennisGame game = new TennisGame();
        setScore(game, 3, 3);
        assertEquals("DEUCE", game.getDisplayedScore());
    }

    @Test
    public void isDeuce_when5_5() {
        TennisGame game = new TennisGame();
        setScore(game, 3, 3);
        game.playerOneScores();
        game.playerTwoScores();
        game.playerOneScores();
        game.playerTwoScores();
        assertEquals("DEUCE", game.getDisplayedScore());
    }

    @Test
    public void isDeuce_returnsFalse_when30_all() {
        TennisGame game = new TennisGame();
        setScore(game, 2, 2);
        assertEquals("30 : 30", game.getDisplayedScore());
    }

    @Test
    public void hasPlayerOneAdvantage_returnsTrue_when4_3() {
        TennisGame game = new TennisGame();
        setScore(game, 3, 3);
        game.playerOneScores();
        assertEquals("ADVANTAGE PLAYER ONE", game.getDisplayedScore());
    }
    @Test
    public void hasPlayerTwoAdvantage_returnsTrue_when3_4() {
        TennisGame game = new TennisGame();
        setScore(game, 3, 4);
        assertEquals("ADVANTAGE PLAYER TWO", game.getDisplayedScore());
    }

    @Test
    public void hasWinner_returnsTrue_when5_3() {
        TennisGame game = new TennisGame();
        setScore(game, 5, 3);
        assertEquals("PLAYER ONE WINS", game.getDisplayedScore());
    }

    @Test
    public void hasWinner_returnsTrue_when3_5() {
        TennisGame game = new TennisGame();
        setScore(game, 3, 5);
        assertEquals("PLAYER TWO WINS", game.getDisplayedScore());
    }

    private void setScore(TennisGame game, int scorePlayerOne, int scorePlayerTwo) {
        for (int i = 0; i < scorePlayerOne; i++) {
            game.playerOneScores();
        }
        for (int i = 0; i < scorePlayerTwo; i++) {
            game.playerTwoScores();
        }
    }
}
