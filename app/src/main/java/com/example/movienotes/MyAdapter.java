package com.example.movienotes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Movie> movies;

    public MyAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return this.movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movies.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtVw_title = convertView.findViewById(R.id.txtVw_title);
        TextView txtVw_comments = convertView.findViewById(R.id.txtVw_comments);
        TextView txtVw_date = convertView.findViewById(R.id.txtVw_date);
        TextView txtVw_genre = convertView.findViewById(R.id.txtVw_genre);

        Movie movie_pos = movies.get(position);

        txtVw_title.setText(movie_pos.getTitle());
        txtVw_comments.setText(movie_pos.getComments());
        txtVw_date.setText(movie_pos.getDate());
        txtVw_genre.setText(movie_pos.getGenre());

        return convertView;
    }
}
