package com.example.movienotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Extended extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extended);

        ActionBar bar = getSupportActionBar();
        bar.hide();
        TextView txtVw_Movie = findViewById(R.id.txtVw_Movie);
        TextView txtVw_title = findViewById(R.id.txtVw_title);
        TextView txtVw_comments = findViewById(R.id.txtVw_comments);
        TextView txtVw_date = findViewById(R.id.txtVw_date);
        TextView txtVw_genre = findViewById(R.id.txtVw_genre);

        String title = getIntent().getExtras().getString("title", "default value");
        String comments = getIntent().getExtras().getString("comments", "default value");
        String date = getIntent().getExtras().getString("date", "default value");
        String genre = getIntent().getExtras().getString("genre", "default value");

        txtVw_title.setText(title);
        txtVw_comments.setText(comments);
        txtVw_date.setText("Movie watched on: " + date);
        txtVw_genre.setText("Genre: " + genre);
    }
}
