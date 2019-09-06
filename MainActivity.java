package com.hfad.tennis;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewScore;
    MainViewModel viewModel;
    Button buttonNewGame;
    Button buttonPlayerOne;
    Button buttonPlayerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewScore = findViewById(R.id.textViewScore);
        buttonNewGame = findViewById(R.id.buttonNewGame);
        buttonPlayerOne = findViewById(R.id.buttonPlayerOne);
        buttonPlayerTwo = findViewById(R.id.buttonPlayerTwo);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Observer<String> scoreObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String score) {
                textViewScore.setText(score);
            }
        };

        viewModel.getScore().observe(this, scoreObserver);

        Observer<Boolean> canStartNewGameObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean canStartNewGame) {
                buttonNewGame.setEnabled(canStartNewGame);
                buttonPlayerOne.setEnabled(!canStartNewGame);
                buttonPlayerTwo.setEnabled(!canStartNewGame);
            }
        };

        viewModel.canStartNewGame().observe(this, canStartNewGameObserver);

    }

    public void onClickPlayerOneScores(View view) {
        viewModel.playerOneScore();
    }

    public void onClickPlayerTwoScores(View view) {
        viewModel.playerTwoScore();
    }

    public void onClickNewGame(View view) {
        viewModel.newGame();
    }

}
