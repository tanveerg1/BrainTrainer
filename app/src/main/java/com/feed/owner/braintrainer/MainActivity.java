package com.feed.owner.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;

    boolean gameIsActive = false;

    RelativeLayout gameLayout;
    Button goButton;

    public void startGame(View view){

        gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);

        gameLayout.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.INVISIBLE);

    }

    public void answerClick(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = (Button)findViewById(R.id.goButton);
    }
}
