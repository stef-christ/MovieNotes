package com.example.movienotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class ViewMovies extends AppCompatActivity {

    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    TextView txtVw_choose;
    TextView txtVw_allMovies;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movies);

        listView = findViewById(R.id.listvw);
        txtVw_choose = findViewById(R.id.txtVw_choose);
        registerForContextMenu(txtVw_choose);
        txtVw_allMovies = findViewById(R.id.txtVw_allMovies);

        DataSource source = new DataSource(ViewMovies.this);

        source.open();
        final ArrayList<Movie> movies = source.getAllMovies();
        source.close();

        MyAdapter adapter = new MyAdapter(ViewMovies.this, movies);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtVw_title = view.findViewById(R.id.txtVw_title);
                TextView txtVw_comments = view.findViewById(R.id.txtVw_comments);
                TextView txtVw_date = view.findViewById(R.id.txtVw_date);
                TextView txtVw_genre = view.findViewById(R.id.txtVw_genre);

                Intent intent = new Intent(ViewMovies.this, Extended.class);
                intent.putExtra("title", txtVw_title.getText().toString());
                intent.putExtra("comments", txtVw_comments.getText().toString());
                intent.putExtra("date", txtVw_date.getText().toString());
                intent.putExtra("genre", txtVw_genre.getText().toString());

                startActivity(intent);
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.allMovies:
                txtVw_allMovies.setText("All Available Movies");
                DataSource allsource = new DataSource(ViewMovies.this);
                allsource.open();
                ArrayList<Movie> allmovies = allsource.getAllMovies();
                allsource.close();
                MyAdapter alladapter = new MyAdapter(ViewMovies.this, allmovies);
                listView.setAdapter(alladapter);
                break;
            case R.id.action:
                txtVw_allMovies.setText("All Action Movies");
                DataSource actionsource = new DataSource(ViewMovies.this);
                actionsource.open();
                ArrayList<Movie> actionmovies = actionsource.getMoviesByGenre("Action");
                actionsource.close();
                MyAdapter actionadapter = new MyAdapter(ViewMovies.this, actionmovies);
                listView.setAdapter(actionadapter);
                break;
            case R.id.adventure:
                txtVw_allMovies.setText("All Adventure Movies");
                DataSource adventuresource = new DataSource(ViewMovies.this);
                adventuresource.open();
                ArrayList<Movie> adventuremovies = adventuresource.getMoviesByGenre("Adventure");
                adventuresource.close();
                MyAdapter adventureadapter = new MyAdapter(ViewMovies.this, adventuremovies);
                listView.setAdapter(adventureadapter);
                break;
            case R.id.comedy:
                txtVw_allMovies.setText("All Comedy Movies");
                DataSource comedysource = new DataSource(ViewMovies.this);
                comedysource.open();
                ArrayList<Movie> comedymovies = comedysource.getMoviesByGenre("Comedy");
                comedysource.close();
                MyAdapter comedyadapter = new MyAdapter(ViewMovies.this, comedymovies);
                listView.setAdapter(comedyadapter);
                break;
            case R.id.drama:
                txtVw_allMovies.setText("All Drama Movies");
                DataSource dramasource = new DataSource(ViewMovies.this);
                dramasource.open();
                ArrayList<Movie> dramamovies = dramasource.getMoviesByGenre("Drama");
                dramasource.close();
                MyAdapter dramaadapter = new MyAdapter(ViewMovies.this, dramamovies);
                listView.setAdapter(dramaadapter);
                break;
            case R.id.fantasy:
                txtVw_allMovies.setText("All Fantasy Movies");
                DataSource fantasysource = new DataSource(ViewMovies.this);
                fantasysource.open();
                ArrayList<Movie> fantasymovies = fantasysource.getMoviesByGenre("Fantasy");
                fantasysource.close();
                MyAdapter fantasyadapter = new MyAdapter(ViewMovies.this, fantasymovies);
                listView.setAdapter(fantasyadapter);
                break;
            case R.id.mystery:
                txtVw_allMovies.setText("All Mystery Movies");
                DataSource mysterysource = new DataSource(ViewMovies.this);
                mysterysource.open();
                ArrayList<Movie> mysterymovies = mysterysource.getMoviesByGenre("Mystery");
                mysterysource.close();
                MyAdapter mysteryadapter = new MyAdapter(ViewMovies.this, mysterymovies);
                listView.setAdapter(mysteryadapter);
                break;
            case R.id.romance:
                txtVw_allMovies.setText("All Romance Movies");
                DataSource romancesource = new DataSource(ViewMovies.this);
                romancesource.open();
                ArrayList<Movie> romancemovies = romancesource.getMoviesByGenre("Romance");
                romancesource.close();
                MyAdapter romanceadapter = new MyAdapter(ViewMovies.this, romancemovies);
                listView.setAdapter(romanceadapter);
                break;
            case R.id.scifi:
                txtVw_allMovies.setText("All Sci-Fi Movies");
                DataSource scifisource = new DataSource(ViewMovies.this);
                scifisource.open();
                ArrayList<Movie> scifimovies = scifisource.getMoviesByGenre("Sci-Fi");
                scifisource.close();
                MyAdapter scifiadapter = new MyAdapter(ViewMovies.this, scifimovies);
                listView.setAdapter(scifiadapter);
                break;
            case R.id.thriller:
                txtVw_allMovies.setText("All Thriller Movies");
                DataSource thrillersource = new DataSource(ViewMovies.this);
                thrillersource.open();
                ArrayList<Movie> thrillermovies = thrillersource.getMoviesByGenre("Thriller");
                thrillersource.close();
                MyAdapter thrilleradapter = new MyAdapter(ViewMovies.this, thrillermovies);
                listView.setAdapter(thrilleradapter);
                break;
        }
        return true;
    }
}

