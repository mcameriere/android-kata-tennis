package package com.example.tennis;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> score;
    private TennisGame game;
    private MutableLiveData<Boolean> canStartNewGame;

    public MutableLiveData<String> getScore() {
        if (score == null) {
            score = new MutableLiveData<String>();
            game = new TennisGame();
            score.setValue(game.getDisplayedScore());
        }
        return score;
    }

    public MutableLiveData<Boolean> canStartNewGame() {
        if (canStartNewGame == null) {
            canStartNewGame = new MutableLiveData<Boolean>();
            canStartNewGame.setValue(false);
        }
        return canStartNewGame;
    }

    public void playerOneScore() {
        game.playerOneScores();
        score.setValue(game.getDisplayedScore());
        canStartNewGame.setValue(game.hasWinner());
    }

    public void playerTwoScore() {
        game.playerTwoScores();
        score.setValue(game.getDisplayedScore());
        canStartNewGame.setValue(game.hasWinner());
    }

    public void newGame() {
        game = new TennisGame();
        score.setValue(game.getDisplayedScore());
        canStartNewGame.setValue(game.hasWinner());
    }
}
