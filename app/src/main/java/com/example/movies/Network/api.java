package com.example.movies.Network;

import com.example.movies.model.MovieModel;
import com.example.movies.model.screenshots.Sceernshots;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface api {
    @GET("list_movies.json")
    Call<MovieModel> getmovie(@Query("page") int page);

    @GET("list_movies.json?sort_by=rating")
    Call<MovieModel> getRankMovies(@Query("page") int page);

    @GET("movie_details.json?with_images=true&with_cast=true")
    Call<Sceernshots> getMovieDetails(@Query("movie_id") int id);

    @GET("list_movies.json")
    Observable<MovieModel> getMoviesBasedOnQuery(@Query("query_term")String search);



}
