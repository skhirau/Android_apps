package com.example.android.pets.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetsContract.PetsEntry ;

/**
 * Created by skh on 10-05-2017.
 */
public class PetDBHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PetsDatabase.db";

    private static final String SQL_CREATE_ENTERIES = "CREATE TABLE " + PetsContract.PetsEntry.TABLE_NAME +
            " (" + PetsEntry.COLUMN_ID + " INTEGER," +
            PetsEntry.COULMN_NAME + " TEXT," +
            PetsEntry.COLUMN_BREED + " TEXT," +
            PetsEntry.COLUMN_GENDER + " INTEGER," +
            PetsEntry.COLUMN_WEIGHT + " INTEGER," +
            "PRIMARY KEY (" + PetsEntry.COLUMN_ID
            + "));" ;

    private static final String SQL_DELETE_ENTERIES = "DROP TABLE IF EXISTS " + PetsEntry.TABLE_NAME + ";";

    public PetDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTERIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTERIES);
        onCreate(sqLiteDatabase);
    }
}
