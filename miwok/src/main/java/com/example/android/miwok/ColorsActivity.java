package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        mediaPlayer = MediaPlayer.create(ColorsActivity.this,R.raw.color_black);

        ArrayList<Word> colors = new ArrayList<Word>();


/*        colors.add(new Word("red","weṭeṭṭi"));
        colors.add(new Word("green","chokokki"));
        colors.add(new Word("brown","ṭakaakki"));
        colors.add(new Word("gray","ṭopoppi"));
        colors.add(new Word("black", "kululli"));
        colors.add(new Word("white", "kelelli"));
        colors.add(new Word("dusty yellow", "ṭopiisә"));
        colors.add(new Word("mustard yellow", "chiwiiṭә"));
*/


/*
        colors.add(new Word("red","weṭeṭṭi",R.drawable.color_red));
        colors.add(new Word("green","chokokki",R.drawable.color_green));
        colors.add(new Word("brown","ṭakaakki",R.drawable.color_brown));
        colors.add(new Word("gray","ṭopoppi",R.drawable.color_gray));
        colors.add(new Word("black", "kululli",R.drawable.color_black));
        colors.add(new Word("white", "kelelli",R.drawable.color_white));
        colors.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow));
        colors.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow));
*/

        colors.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        colors.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        colors.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        colors.add(new Word("black", "kululli",R.drawable.color_black,R.raw.color_black));
        colors.add(new Word("white", "kelelli",R.drawable.color_white,R.raw.color_white));
        colors.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colors.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));


        WordAdapter colorsAdapter = new WordAdapter (ColorsActivity.this,colors,R.color.category_colors);
        final ListView colorsLV = (ListView) ColorsActivity.this.findViewById(R.id.numbers_list_view);
        colorsLV.setAdapter(colorsAdapter);

        colorsLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Word currentWord = (Word) colorsLV.getItemAtPosition(position);
                int audioFileId = currentWord.getAudioFileResourceId();

                mediaPlayer.reset();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this,audioFileId);
                mediaPlayer.start();
            }
        }
        );


    }
}
