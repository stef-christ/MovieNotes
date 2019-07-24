package com.example.movienotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtVw_title = findViewById(R.id.txtVw_title);
        Button btn_newMovie = findViewById(R.id.btn_addmovie);
        Button btn_viewMovies = findViewById(R.id.btn_viewmovies);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        btn_newMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewMovie.class);
                startActivity(intent);
            }
        });

        btn_viewMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewMovies.class);
                startActivity(intent);
            }
        });
    }
}
