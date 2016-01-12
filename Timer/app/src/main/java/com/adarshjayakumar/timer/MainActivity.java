package com.adarshjayakumar.timer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.util.Log;

import java.util.concurrent.CountDownLatch;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisecondsUntilDone) {
                // countdown is counting down
                Log.i("Seconds Left", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish() {
                // counter is finished after 10 second
                Log.i("Done!", "Countdown Timer Finished");
            }
        }.start();
    }
}

/*

        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {

              Log.i("Runnable has run ! ", "  a second must be passed");

              handler.postDelayed(this, 1000);



            }
        };


    }
}*/
