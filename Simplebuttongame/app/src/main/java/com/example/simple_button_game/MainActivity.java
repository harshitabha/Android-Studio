/**
 * Team Members: Riya Jaitly, Harshita Bhardwaj, 
 */



package com.example.simple_button_game; // change the project name in comp

import androidx.appcompat.app.AppCompatActivity; // this line is different on Mac

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.simple_button_game.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // For now the teams scores are hard coded as variables,
    // but it would probably work better as an object of Score class
    int team1Score = 0;
    int team2Score = 0;

    //increase the score of the teams when the appropriate button is pressed
    // try this format for passing a parameter
    // android:onClick="@{(parameter) -> activity.methodName(parameter names)}"
    public void increase(View view, int team)
    {
        // if team 1's button is pressed increase their score
        if(team == 1)
        {
            team1Score++;
            displayTeam1(team1Score); //change team 1's score
        }
        else
        {
            team2Score++;
            displayTeam2(team2Score); // change team 2's score
        }
    }

    /**
     * Displays team 1's score
     * @param score : team 1's score
     */
    private void displayTeam1(int score) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.team1_score); // id of the text view holding team 1's score
        quantityTextView.setText(score);
    }

    /**
     * Displays team 2's score
     * @param score : team 2's score
     */
    private void displayTeam2(int score) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.team2_score); // id of the text view holding team 2's score
        quantityTextView.setText(score);
    }

    /**
     * This method displays a countdown timer.
     * Once the timer finishes a message is displayed
     * @param view
     * @param secs : number of seconds the timer will run
     * try this format for passing a parameter
     * android:onClick="@{(parameter) -> activity.methodName(parameter names)}"
     */
    public void timer(View view, int secs) {
        TextView timer = (TextView) findViewById(R.id.timer); // change the id of the textview of needed
        TextView results = (TextView) findViewById(R.id.result); // textview for the result of the game

        new CountDownTimer(secs*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(millisUntilFinished / 1000 + " s");
            }

            public void onFinish() {
                results.setText(win());
            }
        }.start();
    }

    /**
     * This method calculates which team won the game
     * @return the team that won the game
     */
    private String win() {
        if(team1Score > team2Score) return "✨ Player 1 Wins! ✨";
        else if(team2Score > team1Score) return "✨ Player 2 Wins! ✨";
        else return "Congratulations it's a tie 👔";
    }
}