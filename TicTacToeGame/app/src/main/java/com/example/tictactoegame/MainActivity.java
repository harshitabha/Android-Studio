/**
 * Project by Riya Jaitly, Harshita Bhardwaj, and Shania Dhanaraj
 */

package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tictactoegame.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView playerOneScore, playerTwoScore, playerStatus;
    private Button [] buttons = new Button[9];
    private Button resetGame;

    private int playerOneScoreCount, playerTwoScoreCount, roundCount;
    boolean activePlayer;

    /**
     * p1 => 0 (X)
     * p2 => 1 (O)
     * empty button => 2
     */
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // combos that create a win
    int [][] winningPositions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8} // row combos
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8} // columns
            {0, 4, 8}, {2, 4, 6} //crosses
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing all the variables
        playerOneScore = (TextView) findViewById(R.id.playerOneScore); // please make sure to use the same id names
        playerTwoScore = (TextView) findViewById(R.id.playerTwoScore);
        playerStatus = (TextView) findViewById(R.id.playerStatus);

        resetGame = (Button) findViewById(R.id.resetGame);

        for(int i = 0; i < buttons.length; i++) {
            // cant just use this string in the find view by ide function because it doesn't accept a string
            String btnID = "btn_" + i;

            //this part of code is to get a button by an id that we determine using the string above
            int resourceID = getResources().getIdentifier(btnID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            //what to do when the button is pressed
            buttons[i].setOnClickListener(this);
        }

        roundCount = 0;

        //scores of players 1 and 2
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;

        // true = player 1 turn
        // false = player 2 turn
        activePlayer = true;
    }

    //what happens when a button is clicked
    @Override
    public void onClick(View v) {
        // making it so if a button has been pressed it's value can't be changed

        // if the button is not empty (it has not already been played)
        if(!((Button)v).getText().toString().equals(""))
        {
            return; // nothing should change
        }

        // identifying which button has been pressed and changing its value based on the player's turn

        //retrieve the id of the button pressed
        String btnID = v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer = Integer.parseInt(btnID.substring(btnID.length() - 1)); //get the last character of the id (this will be a number)

        //check which player is playing
        if(activePlayer) {
            ((Button) v).setText("X");
            ((Button) v).setTextColor(Color.parseColor("#E1341E")); //red
            gameState[gameStatePointer] = 0; // change the array for game state to show this button has been played
        } else {
            ((Button) v).setText("O");
            ((Button) v).setTextColor(Color.parseColor("#1ECBE1")); //blue
            gameState[gameStatePointer] = 1; // change the array for game state to show this button has been played
        }
        roundCount++;
    }
}