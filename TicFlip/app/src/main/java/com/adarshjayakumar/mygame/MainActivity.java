package com.adarshjayakumar.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer =0; // if its 0 -> Cross , if its 1 -> circle
    boolean gameActive = true;
    int[] gameState ={2,2,2,2,2,2,2,2,2};
    int[][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    public void dropIn (View view) {

        //ImageView myImage =(ImageView) findViewById(R.id.imageCenter);
        ImageView counter = (ImageView) view;

        System.out.println(counter.getTag().toString());
        int tapCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tapCounter] == 2 && gameActive) {
            gameState[tapCounter] = activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.o);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.a);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(600);
            for(int[] winningPositions : winningPosition)
            {
                if(gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState[winningPositions[2]]
                        && gameState[winningPositions[1]] != 2)
                {
                    String winner = "Player 1";
                    gameActive = false;
                    if(gameState[winningPositions[0]] == 1)
                    {
                        winner = "Player 2";
                    }

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + " has won !");
                    LinearLayout hiddenLayout = (LinearLayout)findViewById(R.id.playAgainLayout);
                    hiddenLayout.setVisibility(View.VISIBLE);

                   /*int playerDesc =gameState[winningPositions[0]];
                    if(playerDesc ==1)
                        Toast.makeText(this,"Player 2 has won ",Toast.LENGTH_LONG);
                    else
                        Toast.makeText(this,"Player 1 has won ",Toast.LENGTH_LONG);*/
                }
                else
                {
                    boolean gameOver = true;
                    for(int counterState : gameState)
                    {

                        if(counterState == 2)
                            gameOver = false;

                    }
                    if(gameOver)
                    {
                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                        winnerMessage.setText("Its a draw");
                        LinearLayout hiddenLayout = (LinearLayout)findViewById(R.id.playAgainLayout);
                        hiddenLayout.setVisibility(View.VISIBLE);

                    }
                }
            }
        }
    }
    public void playAgain(View view)
    {
        LinearLayout hiddenLayout = (LinearLayout)findViewById(R.id.playAgainLayout);
        hiddenLayout.setVisibility(View.INVISIBLE);
        activePlayer =0;
        gameActive=true;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        GridLayout tableGrid = (GridLayout) findViewById(R.id.tableBorder);
        for(int i=0;i<tableGrid.getChildCount();i++)
        {
            ((ImageView) tableGrid.getChildAt(i)).setImageResource(0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
