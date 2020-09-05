package com.example.qzzomovies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.qzzomovies.model.MoviesList;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    List<MoviesList> list;
    Context context;

    public Adapter(List<MoviesList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final MoviesList movies = list.get(position);

        holder.title.setText(movies.title);
        holder.rating.setText(String.valueOf(movies.vote_average));

        Glide.with(context).load("https://image.tmdb.org/t/p/original"+movies.poster_path).into(holder.image);

        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("popularity", movies.popularity);
                i.putExtra("vote_count", movies.vote_count);
                i.putExtra("poster_path",movies.poster_path);
                i.putExtra("adult",movies.adult);
                i.putExtra("backdrop_path",movies.backdrop_path);
                i.putExtra("original_title", movies.original_title);
                i.putExtra("vote_average",movies.vote_average);
                i.putExtra("overview",movies.overview);
                i.putExtra("original_language", movies.original_language);
                i.putExtra("release_date",movies.release_date);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, rating;
        ImageView image;
        ConstraintLayout select;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.movieTitle);
            rating = itemView.findViewById(R.id.moviesRating);
            image = itemView.findViewById(R.id.movieImage);
            select = itemView.findViewById(R.id.movieItem);

        }
    }
}
