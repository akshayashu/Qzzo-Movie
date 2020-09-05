package com.example.qzzomovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView poster;
    TextView title, rating, overview, language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        poster = findViewById(R.id.moviePoster);
        title = findViewById(R.id.movieTitle);
        rating = findViewById(R.id.moviesRating);
        overview = findViewById(R.id.movieOverview);
        language = findViewById(R.id.movieLang);

        String url = "https://image.tmdb.org/t/p/original" + i.getStringExtra("backdrop_path");
        String movieTitle = i.getStringExtra("original_title");
        String movieRating = String.valueOf(i.getDoubleExtra("vote_average", 0.0));
        String movieOverview = i.getStringExtra("overview");
        String movieLang = i.getStringExtra("original_language");

        Glide.with(getApplicationContext()).load(url).into(poster);
        title.setText(movieTitle);
        rating.setText(movieRating);
        overview.setText(movieOverview);
        language.setText(movieLang);

    }
}