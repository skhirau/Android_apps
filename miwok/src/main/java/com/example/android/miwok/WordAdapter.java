package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by skh on 13-04-2017.
 */
public class WordAdapter extends ArrayAdapter<Word>
{
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    private int activityBackgroundColor = R.color.category_numbers;


    /**
     * This is our own custom constructor
     (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout
     file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context.
    Used to inflate the layout file.
     * @param words
    A List of word objects to display in a list
     */

    public WordAdapter(Activity context,ArrayList<Word> words,int activityBackgroundColor)
    {
        // Here, we initialize the
        // WordAdapter's internal storage for the context and the list.
        // the second argument is used when the WordAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.activityBackgroundColor = activityBackgroundColor ;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Check if the existing view is being  reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
                // 2 TextViews daal rahe hain list_item.xml se .
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view //version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
                //nameTextView
                                    //first TextView ko dhoonda by using its id (in list_item.xml)

        // Get the miwok word from the currentWord object and
        // set this text on the miwokTextView
        miwokTextView.setText(currentWord.getMiwokWord());
        //miwokTextView.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID default_text_view //version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
                //numberTextView
                                    //first TextView ko dhoonda by using its id (in list_item.xml)

        // Get the default word from the currentWord object and
        // set this text on the defaultTextView
        defaultTextView.setText(currentWord.getDefaultWord());
        //defaultTextView.setBackgroundColor(color);

        /*if(currentWord.getImageResourceId() == 0)
            return listItemView;

                //R.id.resource_name returns 0 if no such resource is found.
                //b.t.w. 0 is a invalid(say.null) resource id.

        // Find the ImageView in the list_item.xml layout with the ID image_view
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        // Get the image resource ID from the current Word object and
        // set the image to imageView
        imageView.setImageResource(currentWord.getImageResourceId());
        // Return the whole list item layout (containing 2 TextViews and an ImageView)

*/

        int color = ContextCompat.getColor(getContext(),this.activityBackgroundColor);
        View textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(color);



        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        if(currentWord.getImageResourceId() == 0)
        {
            imageView.setVisibility(View.GONE);
            return listItemView;
        }

        imageView.setVisibility(View.VISIBLE);

        //R.id.resource_name returns 0 if no such resource is found.
        //b.t.w. 0 is a invalid(say.null) resource id.

        // Find the ImageView in the list_item.xml layout with the ID image_view
        // Get the image resource ID from the current Word object and
        // set the image to imageView
        imageView.setImageResource(currentWord.getImageResourceId());
        // Return the whole list item layout (containing 2 TextViews and an ImageView)


        //Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
