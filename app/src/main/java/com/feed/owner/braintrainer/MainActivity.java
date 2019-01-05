package com.feed.owner.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Boolean gameActive = true;
    int score = 0;
    int numberOfQuestions = 0;

    RelativeLayout relativeLayout;
    Button goButton;
    Button playAgainButton;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    TextView questionTextView;
    TextView answerTextView;
    TextView timeTextView;
    TextView pointTextView;

    CountDownTimer countDownTimer;

    public void startGame(View view){

        //gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);

        //gameLayout.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.INVISIBLE);
        relativeLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));
    }

    public void answerClick(View view){

        if (gameActive) {
            if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
                score++;
                answerTextView.setText("Correct!");
            } else {
                answerTextView.setText("Incorrect!");
            }

            numberOfQuestions++;
            pointTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
            generateQuestion();
        }
    }

    public void generateQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        questionTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        int incorrectAnswer;

        for (int i = 0; i < 4; i++){
            if (i == locationOfCorrectAnswer){
                answers.add(a + b);
            }else {
                incorrectAnswer = rand.nextInt(41);

                while(incorrectAnswer == a + b){
                    incorrectAnswer = rand.nextInt(41);
                }

                answers.add(incorrectAnswer);
            }
        }

        button.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void playAgain(View view){
        gameActive = true;
        score = 0;
        numberOfQuestions = 0;

        timeTextView.setText("30s");
        pointTextView.setText("0/0");
        answerTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        generateQuestion();

        countDownTimer = new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millIsUntilFinished){
                timeTextView.setText(String.valueOf(millIsUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish(){
                playAgainButton.setVisibility(View.VISIBLE);
                timeTextView.setText("0s");
                answerTextView.setText("Your Score: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                gameActive = false;
            }
        };

        countDownTimer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        goButton = (Button)findViewById(R.id.goButton);
        questionTextView = (TextView)findViewById(R.id.questionTextView);
        answerTextView = (TextView)findViewById(R.id.answerTextView);
        timeTextView = (TextView) findViewById(R.id.timeTextView);
        pointTextView = (TextView) findViewById(R.id.pointTextView);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);

    }
}
