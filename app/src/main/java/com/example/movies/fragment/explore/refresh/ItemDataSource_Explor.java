package com.example.movies.fragment.explore.refresh;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.movies.Network.Retroficlient;
import com.example.movies.Network.api;
import com.example.movies.fragment.explore.Explore;
import com.example.movies.model.Movie;
import com.example.movies.model.MovieModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ItemDataSource_Explor extends PageKeyedDataSource<Integer, Movie> {
    //the size of a page that we want
    public static final int PAGE_SIZE = 3;

    //we will start from the first page which is 1
    private static final int FIRST_PAGE = 1;

    //we need to fetch from stackoverflow
    private static final String SITE_NAME = "YTS";


    @Override
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Movie> callback) {
        Retroficlient.getRetrofit().create(api.class).getmovie(FIRST_PAGE).enqueue(
                new Callback<MovieModel>() {
                    @Override
                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        Explore.refreshMoviesList.setRefreshing(false);

                        if (response.body() != null) {
                            callback.onResult(response.body().getData().getMovies(),
                                    null, FIRST_PAGE + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {

                    }

                });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {
        Explore.refreshMoviesList.setRefreshing(true);

        Retroficlient.getRetrofit().create(api.class).getmovie(params.key)
                .enqueue(new Callback<MovieModel>() {
                    @Override
                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        Explore.refreshMoviesList.setRefreshing(false);

                        //if the current page is greater than one
                        //we are decrementing the page number
                        //else there is no previous page
                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {

                            //passing the loaded data
                            //and the previous page key
                            callback.onResult(response.body().getData().getMovies(), adjacentKey);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {

                    }
                });
    }


    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {
        Handler refresh = new Handler(Looper.getMainLooper());
        refresh.post(new Runnable() {
            public void run()
            {
                Explore.refreshMoviesList.setRefreshing(true);
            }
        });
        Retroficlient.getRetrofit().create(api.class)
                .getmovie(params.key)
                .enqueue(new Callback<MovieModel>() {
                    @Override

                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        Explore.refreshMoviesList.setRefreshing(false);

                        if (response.body() != null) {
                            //if the response has next page
                            //incrementing the next page number

//                            Integer key = response.body(). ? params.key + 1 : null;
                            Integer key = params.key + 1;

                            //passing the loaded data and next page value
                            callback.onResult(response.body().getData().getMovies(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {

                    }
                });
    }


}