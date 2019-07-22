package com.example.movienotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class NewMovie extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    TextView txtVw_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movie);

        TextView txtVw_newMovie = findViewById(R.id.txtVw_newMovie);
        final EditText edtxt_movieTitle = findViewById(R.id.edtxt_movieTitle);
        Button btn_datePicker = findViewById(R.id.btn_selectDate);
        txtVw_date = findViewById(R.id.txtVw_date);
        final Spinner spn_genre = findViewById(R.id.spn_genre);
        final EditText edtxt_comments = findViewById(R.id.edtxt_comments);
        Button btn_save = findViewById(R.id.btn_save);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genres, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_genre.setAdapter(adapter);

        btn_datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((edtxt_movieTitle.getText().toString().equals("")) || (txtVw_date.getText().toString().equals("")) || (spn_genre.getSelectedItem().toString().equals("Select Genre")) || (edtxt_comments.getText().toString().equals("")))
                    Toast.makeText(NewMovie.this, "Please fill in all fields and select genre", Toast.LENGTH_LONG).show();
                else {
                    Movie movie = new Movie(edtxt_movieTitle.getText().toString(), txtVw_date.getText().toString(), spn_genre.getSelectedItem().toString(), edtxt_comments.getText().toString());
                    movie.save(NewMovie.this);

                    NewMovie.this.finish();
                }
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                NewMovie.this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + month + "/" + year;
        txtVw_date.setText(date);
    }
}
