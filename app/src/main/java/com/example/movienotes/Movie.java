package com.example.movienotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Movie {

    private int id;
    private String title;
    private String date;
    private String genre;
    private String comments;

    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    public Movie() {
    }

    public Movie(String title, String date, String genre, String comments) {
        this.title = title;
        this.date = date;
        this.genre = genre;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void save(Context context) {
        this.dbHelper = new SQLiteHelper(context);
        database = this.dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", this.title);
        values.put("date", this.date);
        values.put("genre", this.genre);
        values.put("comments", this.comments);
        database.insert("movies", null, values);
    }
}
