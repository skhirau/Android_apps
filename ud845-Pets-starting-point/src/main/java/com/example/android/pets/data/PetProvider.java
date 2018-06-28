package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.example.android.pets.data.PetsContract.PetsEntry;

/**
 * Created by skh on 12-05-2017.
 */
public class PetProvider extends ContentProvider
{
    public static final String LOG_TAG = PetProvider.class.getSimpleName();
    private PetDBHelper petDBHelper ;

    /** URI matcher code for the content URI for the pets table */
    private static final int PETS = 100;

    /** URI matcher code for the content URI for a single pet in the pets table */
    private static final int PET_ID = 101;

    /**
     * UriMatcher object to match a content URI to a corresponding code.
     * The input passed into the constructor represents the code to return for the root URI.
     * It's common to use NO_MATCH as the input for this case.
     */
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // Static initializer. This is run the first time anything is called from this class.
    static {
        // The calls to addURI() go here, for all of the content URI patterns that the provider
        // should recognize. All paths added to the UriMatcher have a corresponding code to return
        // when a match is found.

        // TODO: Add 2 content URIs to URI matcher
        sUriMatcher.addURI(PetsContract.CONTENT_AUTHORITY,PetsContract.PATH_PETS,PetProvider.PETS);
        sUriMatcher.addURI(PetsContract.CONTENT_AUTHORITY,PetsContract.PATH_PETS + "/#",PetProvider.PET_ID);
    }


    @Override
    public boolean onCreate() {

        petDBHelper = new PetDBHelper(PetProvider.this.getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        SQLiteDatabase sqLiteDatabase = PetProvider.this.petDBHelper.getReadableDatabase();

        // This cursor will hold the result of the query
        Cursor cursor = null;

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher.match(uri);

        switch (match)
        {
            case PetProvider.PETS :
                // For the PETS code, query the pets table directly with the given
                // projection, selection, selection arguments, and sort order. The cursor
                // could contain multiple rows of the pets table.
                // TODO: Perform database query on pets table
                cursor = sqLiteDatabase.query(PetsContract.PetsEntry.TABLE_NAME,projection,null,null,null,null,null);
                //return cursor;
                break;

            case PetProvider.PET_ID :
                // For the PET_ID code, extract out the ID from the URI.
                // For an example URI such as "content://com.example.android.pets/pets/3",
                // the selection will be "_id=?" and the selection argument will be a
                // String array containing the actual ID of 3 in this case.
                //
                // For every "?" in the selection, we need to have an element in the selection
                // arguments that will fill in the "?". Since we have 1 question mark in the
                // selection, we have 1 String in the selection arguments' String array.
                selection = PetsContract.PetsEntry.COLUMN_ID + "=?" ;
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};

                // This will perform a query on the pets table where the _id equals 3 to return a
                // Cursor containing that row of the table.
                cursor = sqLiteDatabase.query(PetsContract.PetsEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                //return cursor;
                break;
            default:
                throw new IllegalArgumentException("Wrong Uri Entered - " + uri);
                //Toast.makeText(PetProvider.this.getContext(), "Wrong Uri entered", Toast.LENGTH_LONG).show();
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues)
    {
        String name = contentValues.getAsString(PetsEntry.COULMN_NAME);
        if(name == null || name.length() == 0)
        {
            Toast.makeText(PetProvider.this.getContext(), "Please enter a valid pet name.", Toast.LENGTH_LONG).show();
            Log.i("PetProvider.java","Invalid Pet name entered.");
            return null ;
        }

        long row;
        int match = sUriMatcher.match(uri);
        if(match == PetProvider.this.PETS)
        {
            SQLiteDatabase sqLiteDatabase = PetProvider.this.petDBHelper.getWritableDatabase();
            row = sqLiteDatabase.insert(PetsEntry.TABLE_NAME,null,contentValues);
            uri = Uri.withAppendedPath(uri,"" + row);
            return uri;
        }
        else
        {
            throw new IllegalArgumentException("Wrong uri entered.");
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] stringArgs) 
    {
        int rows = 0;
        SQLiteDatabase sqliteDatabase = PetProvider.this.petDBHelper.getWritableDatabase();
        int match = PetProvider.sUriMatcher.match(uri);
        if(match == PetProvider.PETS)
        {
            rows = sqliteDatabase.delete(PetsEntry.TABLE_NAME,selection,stringArgs);
        }
        else if(match == PetProvider.PET_ID)
        {
            rows = sqliteDatabase.delete(PetsEntry.TABLE_NAME,selection,stringArgs);
        }
        else
        {
            Toast.makeText(PetProvider.this.getContext(), "Wrong uri entered.", Toast.LENGTH_SHORT).show();
            Log.i("PetProvider.java","Wrong uri entered.");
        }
        return rows;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] stringArgs)
    {
        String name = contentValues.getAsString(PetsEntry.COULMN_NAME);
        if(name == null || name.length() == 0)
        {
            Toast.makeText(PetProvider.this.getContext(), "Please enter a valid name", Toast.LENGTH_LONG).show();
            Log.i("PetProvider.java","Invalid name entered.");
            return 0;
        }
        
        int match = PetProvider.sUriMatcher.match(uri);
        if(match == PetProvider.PET_ID)
        {
            SQLiteDatabase sqliteDatabase = PetProvider.this.petDBHelper.getWritableDatabase();
            int rows = sqliteDatabase.update(PetsEntry.TABLE_NAME, contentValues, selection, stringArgs);
            return rows;
        }
        else
        {
            Toast.makeText(PetProvider.this.getContext(), "Wrong uri entered", Toast.LENGTH_SHORT).show();
            Log.i("PetProvider.java","Wrong uri entered.");
            return 0;
        }
    }

}
