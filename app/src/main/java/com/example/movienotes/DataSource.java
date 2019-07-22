package com.example.movienotes;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataSource {

    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    private String[] allColumns = {SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_TITLE, SQLiteHelper.COLUMN_DATE, SQLiteHelper.COLUMN_GENRE, SQLiteHelper.COLUMN_COMMENTS};

    public DataSource(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public  void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        Cursor cursor = database.query(SQLiteHelper.TABLE_MOVIES, allColumns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Movie movie = new Movie();
            movie.setId(cursor.getInt(0));
            movie.setTitle(cursor.getString(1));
            movie.setDate(cursor.getString(2));
            movie.setGenre(cursor.getString(3));
            movie.setComments(cursor.getString(4));

            movies.add(movie);

            cursor.moveToNext();
        }
        return movies;
    }

    public ArrayList<Movie> getMoviesByGenre(String genre) {
        ArrayList<Movie> movies = new ArrayList<>();

        Cursor cursor = database.query(SQLiteHelper.TABLE_MOVIES, allColumns, "genre = ?", new String[]{genre}, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Movie movie = new Movie();
            movie.setId(cursor.getInt(0));
            movie.setTitle(cursor.getString(1));
            movie.setDate(cursor.getString(2));
            movie.setGenre(cursor.getString(3));
            movie.setComments(cursor.getString(4));

            movies.add(movie);

            cursor.moveToNext();
        }
        return movies;
    }
}
