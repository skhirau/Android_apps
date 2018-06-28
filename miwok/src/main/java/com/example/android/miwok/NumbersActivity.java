package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        mediaPlayer = MediaPlayer.create(NumbersActivity.this,R.raw.number_one);

        /*ArrayList<String> numbers = new ArrayList<String>();

        //Log.i("NumbersActivity","Size of numbers ArrayList is " + numbers.size());

        numbers.add(0,"one");
        numbers.add(1,"two");
        numbers.add(2,"three");
        numbers.add(3,"Four");
        numbers.add(4,"Five");
        numbers.add(5,"Six");
        numbers.add(6,"Seven");
        numbers.add(7,"eight");
        numbers.add(8,"nine");
        numbers.add(9,"ten");
        numbers.add(10,"eleven");
        */

        ArrayList<Word> words = new ArrayList<Word>();
        //Word one = new Word("lutti","one");
        //words.add(0,one); //name for object word at index 0 is "one"

        /*words.add(new Word("one","lutti",R.mipmap.ic_launcher));
        words.add(new Word("two", "otiiko",R.mipmap.ic_launcher));
        words.add(new Word("three", "tolookosu",R.mipmap.ic_launcher));
        words.add(new Word("four", "oyyisa",R.mipmap.ic_launcher));
        words.add(new Word("five", "massokka",R.mipmap.ic_launcher));
        words.add(new Word("six", "temmokka",R.mipmap.ic_launcher));
        words.add(new Word("seven", "kenekaku",R.mipmap.ic_launcher));
        words.add(new Word("eight", "kawinta",R.mipmap.ic_launcher));
        words.add(new Word("nine", "wo’e",R.mipmap.ic_launcher));
        words.add(new Word("ten", "na’aacha",R.mipmap.ic_launcher));
        */

/*
        words.add(new Word("one","lutti",R.drawable.number_one));
        words.add(new Word("two", "otiiko",R.drawable.number_two));
        words.add(new Word("three", "tolookosu",R.drawable.number_three));
        words.add(new Word("four", "oyyisa",R.drawable.number_four));
        words.add(new Word("five", "massokka",R.drawable.number_five));
        words.add(new Word("six", "temmokka",R.drawable.number_six));
        words.add(new Word("seven", "kenekaku",R.drawable.number_seven));
        words.add(new Word("eight", "kawinta",R.drawable.number_eight));
        words.add(new Word("nine", "wo’e",R.drawable.number_nine));
        words.add(new Word("ten", "na’aacha",R.drawable.number_ten));
*/


        words.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five", "massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten));

        /*ArrayAdapter<String> numbersAdapter = new ArrayAdapter<String>(NumbersActivity.this,android.R.layout.simple_list_item_1,numbers);
        ListView numbersLV= (ListView) NumbersActivity.this.findViewById(R.id.numbers_list_view);
        numbersLV.setAdapter(numbersAdapter);
        */

        //GridView numbersGV = (GridView) NumbersActivity.this.findViewById(R.id.numbers_grid_view);
        //numbersGV.setAdapter(numbersAdapter);

        WordAdapter numbersAdapter = new WordAdapter (NumbersActivity.this,words,R.color.category_numbers);
        final ListView numbersLV = (ListView) NumbersActivity.this.findViewById(R.id.numbers_list_view);
        numbersLV.setAdapter(numbersAdapter);

        numbersLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = (Word) numbersLV.getItemAtPosition(position);
                int audioFileId = currentWord.getAudioFileResourceId();

                mediaPlayer.reset();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this,audioFileId);
                mediaPlayer.start();

            }
        });
/*
        //checking through logs
        Log.i("MainActivity","numbers.get(0) is " + numbers.get(0));
        Log.i("MainActivity","numbers.get(1) is " + numbers.get(1));
        Log.i("MainActivity","numbers.get(2) is " + numbers.get(2));
        Log.i("MainActivity","numbers.get(3) is " + numbers.get(3));
        Log.i("MainActivity","numbers.get(4) is " + numbers.get(4));
        Log.i("MainActivity","numbers.get(5) is " + numbers.get(5));
        Log.i("MainActivity","numbers.get(6) is " + numbers.get(6));
        Log.i("MainActivity","numbers.get(7) is " + numbers.get(7));
        Log.i("MainActivity","numbers.get(8) is " + numbers.get(8));
        Log.i("MainActivity","numbers.get(9) is " + numbers.get(9));

*/
    /*
        This method will be used for minimum API level >= 16
                Current minimum API level = 15;

     ArrayList<TextView> numTextViews = new ArrayList<TextView>();
        for(int i = 0 ; i < numbers.size() ; i++)
        {
            TextView tv = new TextView(NumbersActivity.this);
            tv.setText("" + numbers.get(i));
            numTextViews.add(0,tv);
        }

        LinearLayout numbersScroll = (LinearLayout) this.findViewById(R.id.numbersScroll);
        numbersScroll.addChildrenForAccessibility(numTextViews);
    */


        /*
        LinearLayout numbersScroll = (LinearLayout) NumbersActivity.this.findViewById(R.id.numbersScroll);

        for (int i = 0; i < numbers.size(); i++)
        {
            TextView tv = new TextView(NumbersActivity.this);
            tv.setText("" + numbers.get(i));

            numbersScroll.addView(tv);
        }*/




    }
}
