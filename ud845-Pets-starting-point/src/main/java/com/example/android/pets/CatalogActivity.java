/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.pets;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.test.PerformanceTestCase;
import android.text.Selection;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.pets.data.PetProvider;
import com.example.android.pets.data.PetsContract;
import com.example.android.pets.data.PetsContract.PetsEntry;
import com.example.android.pets.data.PetDBHelper;

/**
 * Displays list of pets that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity //implements LoaderManager.LoaderCallbacks<Cursor>
 {
    //private static final int PET_LOADER = 4; // U CAN CHOOSE ANY NUMBER
    //MyCursorAdapter myGlobalCursorAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this,EditorActivity.class);
                startActivity(intent);
            }
        });
        displayDatabaseInfo();

        //PetDBHelper mDbHelper = new PetDBHelper(this);
        //SQLiteDatabase db = mDbHelper.getReadableDatabase();


        /*myGlobalCursorAdapter = new MyCursorAdapter(CatalogActivity.this,null);
        ListView petListView = (ListView) CatalogActivity.this.findViewById(R.id.list_view);
        petListView.setAdapter(myGlobalCursorAdapter);
*/
        //kick off the loader
        //CatalogActivity.this.getLoaderManager().initLoader(PET_LOADER,null,);

        ListView petListView = (ListView) CatalogActivity.this.findViewById(R.id.list_view);
        petListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent intent = new Intent(CatalogActivity.this,EditorActivity.class);

                Uri currentPetUri = ContentUris.withAppendedId(PetsContract.CONTENT_URI,id);

                intent.setData(currentPetUri);
                CatalogActivity.this.startActivity(intent);

            }
        });


    }






    /**
          * Temporary helper method to display information in the onscreen TextView about the state of
          * the pets database.
          */

    private void displayDatabaseInfo()
    {
        Cursor cursor = null;
        String[] projection = {};

                cursor = CatalogActivity.this.getContentResolver().query(PetsContract.CONTENT_URI,projection,null,null,null);

                int noOfPets = cursor.getCount();
                TextView textView = (TextView) CatalogActivity.this.findViewById(R.id.text_view_pet);
                textView.setText("No of pets in the database is " + noOfPets);

                // Find the ListView which will be populated with the pet data
                ListView petListView = (ListView) findViewById(R.id.list_view);

                // Setup an Adapter to create a list item for each row of pet data in the Cursor.
                MyCursorAdapter myCursorAdapter = new MyCursorAdapter(CatalogActivity.this, cursor);

                // Attach the adapter to the ListView.
                petListView.setAdapter(myCursorAdapter);

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        //displayDatabaseInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                ContentValues contentValues = new ContentValues();
                contentValues.put(PetsEntry.COULMN_NAME,"Toto");
                contentValues.put(PetsEntry.COLUMN_BREED,"Terrier");
                contentValues.put(PetsEntry.COLUMN_GENDER,PetsEntry.GENDER_MALE);
                contentValues.put(PetsEntry.COLUMN_WEIGHT,7);

                /*PetDBHelper dbHelper = new PetDBHelper(CatalogActivity.this);
                SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
                long ans = sqLiteDatabase.insert(PetsEntry.TABLE_NAME,null,contentValues);
                */

                Uri uri = CatalogActivity.this.getContentResolver().insert(PetsContract.CONTENT_URI,contentValues);
                Toast.makeText(CatalogActivity.this, "New Pet Uri is " + uri, Toast.LENGTH_SHORT).show();
                Log.i("CatalogActivity.java","New Pet uri is " + uri);
                displayDatabaseInfo();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                int rows = CatalogActivity.this.getContentResolver().delete(PetsContract.CONTENT_URI, "1", null);
                if(rows != 0)
                {
                    Toast.makeText(CatalogActivity.this, "Database cleared.", Toast.LENGTH_LONG).show();
                    Log.i("CatalogActivity","Database cleared.");
                }
                displayDatabaseInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args)
    {
        String[] projection = {PetsEntry.COLUMN_ID,PetsEntry.TABLE_NAME,PetsEntry.COLUMN_BREED};

        return (new CursorLoader(CatalogActivity.this, PetsContract.CONTENT_URI,projection,null,null,null));
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data)
    {
        myGlobalCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader)
    {
        myGlobalCursorAdapter.swapCursor(null);
    }*/
}
