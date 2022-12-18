package com.example.movies.fragment.Details;

import com.example.movies.model.screenshots.Sceernshots;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public  class post_client_java {

    public static final String bas="https://yts.mx/api/v2/";

    public com.example.movies.Network.api api;
    public  static post_client_java Instance;
    private static Retrofit Builder;
    public post_client_java(){
        Builder=new Retrofit.Builder()
                .baseUrl(bas)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api=Builder.create(com.example.movies.Network.api.class);

    }
    public static post_client_java getInstance() {
        if(Instance==null){
            Instance=new post_client_java();
        }
        return Instance;
    }
    //    public Call<MovieModel> getmovie(){
//        return api.getmovie();
//
//    }
    public Call<Sceernshots> getMovieDetails(int id){
        return api.getMovieDetails(id);
    }
}
