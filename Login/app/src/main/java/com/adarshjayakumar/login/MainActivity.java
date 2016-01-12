package com.adarshjayakumar.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    public void login(View view)
    {
        ImageView myImage =(ImageView) findViewById(R.id.imageView);
        myImage.setImageResource(R.drawable.cat1);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
