package com.adarshjayakumar.gridlayout;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void buttonTapped(View view)
    {
        int id = view.getId();
        String ourId = "";
        ourId = view.getResources().getResourceEntryName(id);
        int resourceId = getResources().getIdentifier(ourId,"raw","com.adarshjayakumar.gridlayout");
        MediaPlayer mediaPlayer = MediaPlayer.create(this,resourceId);
        mediaPlayer.start();
        Log.i("Button tapped",ourId);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
