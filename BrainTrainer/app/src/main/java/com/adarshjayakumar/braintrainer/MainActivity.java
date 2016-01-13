package com.adarshjayakumar.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView resultText;
    TextView gameTitle;
    TextView timerText;
    RelativeLayout dummyLayout;
    TextView questionText;
    TextView scoreText;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score =0;
    int totalQuestion =0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    RelativeLayout playAgainLayout;

    Button playAgain;


    public void generateQuestion()
    {
        Random rand = new Random();
        int value1 = rand.nextInt(48)+1;
        int value2= rand.nextInt(48)+1;
        String result = Integer.toString(value1)+"+"+Integer.toString(value2);
        questionText.setText(result);
        locationOfCorrectAnswer = rand.nextInt(4);
        int incorrectAnswer;
        answers.clear();
        for(int i=0 ;i<4;i++)
        {
            if(i == locationOfCorrectAnswer)
            {
                answers.add(value1 + value2);
            }else {
                incorrectAnswer = rand.nextInt(98)+1;
                while(incorrectAnswer == value1+value2)
                    answers.add(rand.nextInt(98)+1);
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }


    public void play()
    {
        dummyLayout.setVisibility(View.INVISIBLE);
        playAgainLayout.setVisibility(View.INVISIBLE);
        score =0;
        totalQuestion = 0;
        questionText.setText("");
        resultText.setText("");
        String timer ="30s";
        timerText.setText(timer);
        scoreText.setText("0/0");
        new CountDownTimer(5100,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText(String.valueOf((millisUntilFinished)/1000));
            }

            @Override
            public void onFinish() {
                timerText.setText("0s");
                Toast.makeText(getApplicationContext(),"Game Over , Your socre is "+score,Toast.LENGTH_LONG).show();
                dummyLayout.setVisibility(View.VISIBLE);
                playAgainLayout.setVisibility(View.VISIBLE);
            }
        }.start();
        generateQuestion();
    }
    public void chooseAnswer(View view)
    {
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
        {
            score ++;
            resultText.setText("Correct");

        }
        else
        {
            resultText.setText("Incorrect");

        }
        totalQuestion++;
        scoreText.setText(Integer.toString(score) + "/" + Integer.toString(totalQuestion));
        generateQuestion();

    }



    public void start(View view)
    {
        startButton.setVisibility(view.INVISIBLE);
        gameTitle.setVisibility(view.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.result1);
        button1 = (Button) findViewById(R.id.result2);
        button2 = (Button) findViewById(R.id.result3);
        button3 = (Button) findViewById(R.id.result4);
        startButton = (Button) findViewById(R.id.startButton);
        gameTitle = (TextView) findViewById(R.id.gameTitle);
        questionText = (TextView) findViewById(R.id.questionText);
        resultText = (TextView) findViewById(R.id.resultText);
        scoreText = (TextView) findViewById(R.id.scoreText);
        timerText = (TextView) findViewById(R.id.timerText);
        dummyLayout = (RelativeLayout) findViewById(R.id.dummyLayout);
        dummyLayout.setVisibility(View.INVISIBLE);
        playAgainLayout = (RelativeLayout) findViewById(R.id.playAgainLayout);
        playAgainLayout.setVisibility(View.INVISIBLE);
       playAgain =(Button) findViewById(R.id.playAgain);
       // generateQuestion();
        play();

}





}
