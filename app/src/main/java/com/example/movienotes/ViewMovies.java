package com.example.movienotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewMovies extends AppCompatActivity {

    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    TextView txtVw_choose;
    TextView txtVw_allMovies;
    ListView listView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movies);

        listView = findViewById(R.id.listvw);
        txtVw_choose = findViewById(R.id.txtVw_choose);
        txtVw_allMovies = findViewById(R.id.txtVw_allMovies);
        spinner = findViewById(R.id.spinner);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        ArrayAdapter<CharSequence> spinadapt = ArrayAdapter.createFromResource(this, R.array.selectbygenre, android.R.layout.simple_spinner_item);
        spinadapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapt);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String label = spinner.getSelectedItem().toString();

                switch (label) {
                    case "All Available Movies":
                        txtVw_allMovies.setText("All Available Movies");
                        DataSource allsource = new DataSource(ViewMovies.this);
                        allsource.open();
                        ArrayList<Movie> allmovies = allsource.getAllMovies();
                        allsource.close();
                        MyAdapter alladapter = new MyAdapter(ViewMovies.this, allmovies);
                        listView.setAdapter(alladapter);
                        break;
                    case "Action":
                        txtVw_allMovies.setText("All Action Movies");
                        DataSource actionsource = new DataSource(ViewMovies.this);
                        actionsource.open();
                        ArrayList<Movie> actionmovies = actionsource.getMoviesByGenre("Action");
                        actionsource.close();
                        MyAdapter actionadapter = new MyAdapter(ViewMovies.this, actionmovies);
                        listView.setAdapter(actionadapter);
                        break;
                    case "Adventure":
                        txtVw_allMovies.setText("All Adventure Movies");
                        DataSource adventuresource = new DataSource(ViewMovies.this);
                        adventuresource.open();
                        ArrayList<Movie> adventuremovies = adventuresource.getMoviesByGenre("Adventure");
                        adventuresource.close();
                        MyAdapter adventureadapter = new MyAdapter(ViewMovies.this, adventuremovies);
                        listView.setAdapter(adventureadapter);
                        break;
                    case "Comedy":
                        txtVw_allMovies.setText("All Comedy Movies");
                        DataSource comedysource = new DataSource(ViewMovies.this);
                        comedysource.open();
                        ArrayList<Movie> comedymovies = comedysource.getMoviesByGenre("Comedy");
                        comedysource.close();
                        MyAdapter comedyadapter = new MyAdapter(ViewMovies.this, comedymovies);
                        listView.setAdapter(comedyadapter);
                        break;
                    case "Drama":
                        txtVw_allMovies.setText("All Drama Movies");
                        DataSource dramasource = new DataSource(ViewMovies.this);
                        dramasource.open();
                        ArrayList<Movie> dramamovies = dramasource.getMoviesByGenre("Drama");
                        dramasource.close();
                        MyAdapter dramaadapter = new MyAdapter(ViewMovies.this, dramamovies);
                        listView.setAdapter(dramaadapter);
                        break;
                    case "Fantasy":
                        txtVw_allMovies.setText("All Fantasy Movies");
                        DataSource fantasysource = new DataSource(ViewMovies.this);
                        fantasysource.open();
                        ArrayList<Movie> fantasymovies = fantasysource.getMoviesByGenre("Fantasy");
                        fantasysource.close();
                        MyAdapter fantasyadapter = new MyAdapter(ViewMovies.this, fantasymovies);
                        listView.setAdapter(fantasyadapter);
                        break;
                    case "Mystery":
                        txtVw_allMovies.setText("All Mystery Movies");
                        DataSource mysterysource = new DataSource(ViewMovies.this);
                        mysterysource.open();
                        ArrayList<Movie> mysterymovies = mysterysource.getMoviesByGenre("Mystery");
                        mysterysource.close();
                        MyAdapter mysteryadapter = new MyAdapter(ViewMovies.this, mysterymovies);
                        listView.setAdapter(mysteryadapter);
                        break;
                    case "Romance":
                        txtVw_allMovies.setText("All Romance Movies");
                        DataSource romancesource = new DataSource(ViewMovies.this);
                        romancesource.open();
                        ArrayList<Movie> romancemovies = romancesource.getMoviesByGenre("Romance");
                        romancesource.close();
                        MyAdapter romanceadapter = new MyAdapter(ViewMovies.this, romancemovies);
                        listView.setAdapter(romanceadapter);
                        break;
                    case "Sci-Fi":
                        txtVw_allMovies.setText("All Sci-Fi Movies");
                        DataSource scifisource = new DataSource(ViewMovies.this);
                        scifisource.open();
                        ArrayList<Movie> scifimovies = scifisource.getMoviesByGenre("Sci-Fi");
                        scifisource.close();
                        MyAdapter scifiadapter = new MyAdapter(ViewMovies.this, scifimovies);
                        listView.setAdapter(scifiadapter);
                        break;
                    case "Thriller":
                        txtVw_allMovies.setText("All Thriller Movies");
                        DataSource thrillersource = new DataSource(ViewMovies.this);
                        thrillersource.open();
                        ArrayList<Movie> thrillermovies = thrillersource.getMoviesByGenre("Thriller");
                        thrillersource.close();
                        MyAdapter thrilleradapter = new MyAdapter(ViewMovies.this, thrillermovies);
                        listView.setAdapter(thrilleradapter);
                        break;
                        default:
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
}

