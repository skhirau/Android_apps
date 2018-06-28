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

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.pets.data.PetDBHelper;
import com.example.android.pets.data.PetsContract;
import com.example.android.pets.data.PetsContract.PetsEntry;
/**
 * Allows user to create a new pet or edit an existing one.
 */

public class EditorActivity extends AppCompatActivity {

    /** EditText field to enter the pet's name */
    private EditText mNameEditText;

    /** EditText field to enter the pet's breed */
    private EditText mBreedEditText;

    /** EditText field to enter the pet's weight */
    private EditText mWeightEditText;

    /** EditText field to enter the pet's gender */
    private Spinner mGenderSpinner;

    /**
     * Gender of the pet. The possible values are:
     * 0 for unknown gender, 1 for male, 2 for female.
     */
    private int mGender = 0;

    private byte intentCheck = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Intent intent = EditorActivity.this.getIntent();
        Uri currentPetUri = intent.getData();

        if(currentPetUri == null)
        {
            intentCheck = 1;
            EditorActivity.this.setTitle("Add a pet");
        }
        else
        {
            intentCheck = 2;
            EditorActivity.this.setTitle("Edit pet");

            long id = ContentUris.parseId(currentPetUri);
            String selection = "=?";
            String[] selectionArgs = {"" + id};
            Cursor cursor = EditorActivity.this.getContentResolver().query(currentPetUri, null, selection, selectionArgs, null);
            TextView nameTextView = (TextView) EditorActivity.this.findViewById(R.id.edit_pet_name);
            TextView breedTextView = (TextView) EditorActivity.this.findViewById(R.id.edit_pet_breed);
            TextView weightTextView = (TextView) EditorActivity.this.findViewById(R.id.edit_pet_weight);

            cursor.moveToNext();
            nameTextView.setText(cursor.getString(cursor.getColumnIndex(PetsEntry.COULMN_NAME)));
            breedTextView.setText(cursor.getString(cursor.getColumnIndex(PetsEntry.COLUMN_BREED)));
            weightTextView.setText(cursor.getString(cursor.getColumnIndex(PetsEntry.COLUMN_WEIGHT)));
            cursor.close();
        }


        // Find all relevant views that we will need to read user input from
        mNameEditText = (EditText) findViewById(R.id.edit_pet_name);
        mBreedEditText = (EditText) findViewById(R.id.edit_pet_breed);
        mWeightEditText = (EditText) findViewById(R.id.edit_pet_weight);
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);

        setupSpinner();
    }

    /**
     * Setup the dropdown spinner that allows the user to select the gender of the pet.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        //mGender = 1; // Male
                        mGender = PetsContract.PetsEntry.GENDER_MALE ;
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        //mGender = 2; // Female
                        mGender = PetsContract.PetsEntry.GENDER_FEMALE ;
                    } else {
                        //mGender = 0; // Unknown
                        mGender = PetsContract.PetsEntry.GENDER_UNKNOWN;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 0; // Unknown
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                long row = enterPet();
                if(row == -1)
                {
                    return true;
                }
                else
                {
                    EditorActivity.this.finish();
                    return true;
                }
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private long enterPet()
    {
        ContentValues contentValues = new ContentValues();

        EditText editText_Name  = (EditText) EditorActivity.this.findViewById(R.id.edit_pet_name);
        contentValues.put(PetsEntry.COULMN_NAME,editText_Name.getText().toString().trim());
        EditText editText_Breed = (EditText) EditorActivity.this.findViewById(R.id.edit_pet_breed);
        contentValues.put(PetsEntry.COLUMN_BREED,editText_Breed.getText().toString().trim());
        contentValues.put(PetsEntry.COLUMN_GENDER,mGender);
        EditText editText_Weight = (EditText) EditorActivity.this.findViewById(R.id.edit_pet_weight);
        contentValues.put(PetsEntry.COLUMN_WEIGHT,Integer.parseInt(("" + editText_Weight.getText()).trim()));

        /*PetDBHelper petDBHelper = new PetDBHelper(EditorActivity.this);
        SQLiteDatabase sqliteDatabase = petDBHelper.getWritableDatabase();
        long newPet_ID = sqliteDatabase.insert(PetsEntry.TABLE_NAME, null, contentValues);
        Toast.makeText(EditorActivity.this, "New pet id is " + newPet_ID, Toast.LENGTH_LONG).show();
        Log.i("EditorActivity.java","New pet id is " + newPet_ID);
        */

        Uri uri = EditorActivity.this.getContentResolver().insert(PetsContract.CONTENT_URI,contentValues);
        if(uri == null)
            return (-1);

        long row = Long.parseLong(String.valueOf(ContentUris.parseId(uri)));
        Toast.makeText(EditorActivity.this, "New pet uri is " + uri, Toast.LENGTH_LONG).show();
        Log.i("EditorActivity.java","New pet uri is " + uri);
        return row;
    }

}

