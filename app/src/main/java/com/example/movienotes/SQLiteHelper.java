package com.example.movienotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movies_db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_MOVIES = "movies";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_COMMENTS = "comments";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " + TABLE_MOVIES + " ( " +
                COLUMN_ID + " integer primary key autoincrement, " +
                COLUMN_TITLE + " text not null, " +
                COLUMN_DATE + " text not null, " +
                COLUMN_GENRE + " text not null, " +
                COLUMN_COMMENTS + " text not null)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
