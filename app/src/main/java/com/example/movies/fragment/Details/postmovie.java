package com.example.movies.fragment.Details;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movies.Network.Retroficlient;
import com.example.movies.Network.api;
import com.example.movies.model.MovieModel;
import com.example.movies.model.screenshots.Sceernshots;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class postmovie extends ViewModel {
    public postmovie() {

    }

   public MutableLiveData<MovieModel> movieMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Sceernshots> movieMutableLiveDetails = new MutableLiveData<>();

    public void getpost() {
        Retroficlient.getRetrofit().create(api.class).getmovie(1).enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Log.d("ddddddddd",t.getMessage()+"");
            }
        });


    }
//    public void getRankMovies(){
//        Retroficlient.getRetrofit().create(api.class)
//                .getRankMovies(1).enqueue(new Callback<MovieModel>() {
//            @Override
//            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
//                RankMoviesLiveData.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<MovieModel> call, Throwable t) {
//                Log.e("aliii", "onFailure: "+ t.getMessage() );
//
//            }
//        });
//    }

    public void getMovieDetails(int id){

        post_client_java.getInstance()
                .getMovieDetails(id).enqueue(new Callback<Sceernshots>() {
            @Override
            public void onResponse(Call<Sceernshots> call, Response<Sceernshots> response) {
                movieMutableLiveDetails.setValue(response.body());
            }
            @Override
            public void onFailure(Call<Sceernshots> call, Throwable t) {
                Log.e("aliii", "onFailure: "+ t.getMessage() );

            }
        });
    }

//    public void getpost_two() {
//        Retroficlient.getInstance().getmovie_two().enqueue(new Callback<MovieModel>() {
//            @Override
//            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
//                movieMutableLiveData_two.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<MovieModel> call, Throwable t) {
//                Log.d("ddddddddd",t.getMessage()+"");
//
//            }
//        });
//    }
    }

