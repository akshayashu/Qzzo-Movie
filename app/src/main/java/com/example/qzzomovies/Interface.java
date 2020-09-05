package com.example.qzzomovies;

import com.example.qzzomovies.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {

    @GET("popular?api_key=4e44d9029b1270a757cddc766a1bcb63&language=en-US&page=1")
    Call<Movies> getMovies();
}
