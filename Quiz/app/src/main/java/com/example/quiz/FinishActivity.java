package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//<!-- Created by Harshita Bhardwaj and Gerald Kyro Tungol-->
public class FinishActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView score;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);

        score = (TextView) findViewById(R.id.score);
        score.setText(MainActivity.getScore() + "/" + MainActivity.getNumQs());

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent reset = new Intent(FinishActivity.this, MainActivity.class);
        startActivity(reset);
    }
}
