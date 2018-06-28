package com.example.android.audiotesting;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer myMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myMediaPlayer = MediaPlayer.create(MainActivity.this.getApplicationContext(),R.raw.mytune);

        Button play = (Button) MainActivity.this.findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                myMediaPlayer.start();
            }
        });

        Button pause = (Button) MainActivity.this.findViewById(R.id.pause_button);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMediaPlayer.pause();
            }
        });
    }




    /*
    public void start(View view)
    {
        myMediaPlayer.start();
    }

    public void pause(View view)
    {
        myMediaPlayer.pause();
    }
*/

}
