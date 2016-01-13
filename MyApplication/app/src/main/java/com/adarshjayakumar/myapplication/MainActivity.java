package com.adarshjayakumar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mytext;


    public void hideText(View view)
    {
        mytext.setVisibility(view.VISIBLE);
    }
    public void showText(View view)
    {
        mytext.setVisibility(view.INVISIBLE);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytext = (TextView) findViewById(R.id.textView);


    }
}
