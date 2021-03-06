package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetsContract;

/**
 * {@link MyCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of pet data as its data source. This adapter knows
 * how to create list items for each row of pet data in the {@link Cursor}.
 */
public class MyCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link MyCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public MyCursorAdapter (Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View listViewItem = null;
        listViewItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return listViewItem ;
    }

    /**
     * This method binds the pet data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current pet can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name_TextView = (TextView) view.findViewById(R.id.item_pet_name);
        TextView breed_TextView = (TextView) view.findViewById(R.id.item_pet_breed);

        String petName = cursor.getString(cursor.getColumnIndex(PetsContract.PetsEntry.COULMN_NAME));
        String petBreed = cursor.getString(cursor.getColumnIndex(PetsContract.PetsEntry.COLUMN_BREED));

        name_TextView.setText(petName);
        breed_TextView.setText(petBreed);
    }
}