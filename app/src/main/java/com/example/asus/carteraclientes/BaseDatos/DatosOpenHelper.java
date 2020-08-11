package com.example.asus.carteraclientes.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.asus.carteraclientes.BaseDatos.FeedReaderContract.FeedEntry;

public class DatosOpenHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry.COLUMN_NAME + " VARCHAR(250), " +
                    FeedEntry.COLUMN_DIREC + " VARCHAR(250), " +
                    FeedEntry.COLUMN_EMAIL + " VARCHAR(200), " +
                    FeedEntry.COLUMN_NUMBER + " VARCHAR(20))";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DATOS.db";

    public DatosOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }

}
