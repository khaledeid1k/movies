package com.example.movies.fragment.explore.search_movie;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;

import com.example.movies.Network.Retroficlient;
import com.example.movies.Network.api;
import com.example.movies.model.MovieModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
//import in.androidmate.anujgupta.movify.models.MovieResponse;
//import in.androidmate.anujgupta.movify.network.NetworkClient;
//import in.androidmate.anujgupta.movify.network.NetworkInterface;

public class SearchPresenter implements SearchPresenterInterface {

    private String TAG = "SearchPresenter";
    SearchViewInterface searchviewInterface;
    public SearchPresenter(SearchViewInterface searchViewInterface) {
        this.searchviewInterface = searchViewInterface;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void getResultsBasedOnQuery(SearchView searchView) {

        getObservableQuery(searchView)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(@NonNull String s) throws Exception {
                        if(s.equals("")){
                            return false;
                        }else{
                            return true;
                        }
                    }
                })
                .debounce(2, TimeUnit.SECONDS)
                .distinctUntilChanged()
                .switchMap(new Function<String, ObservableSource<MovieModel>>() {
                    @Override
                    public Observable<MovieModel> apply(@NonNull String s) throws Exception {
                        return   Retroficlient.getRetrofit().create(api.class)
                                .getMoviesBasedOnQuery(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver());


    }

    private Observable<String> getObservableQuery(androidx.appcompat.widget.SearchView searchView){

        final PublishSubject<String> publishSubject = PublishSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                publishSubject.onNext(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                publishSubject.onNext(newText);
                return true;
            }
        });

        return publishSubject;
    }

    public DisposableObserver<MovieModel> getObserver(){
        return new DisposableObserver<MovieModel>() {

            @Override
            public void onNext(@NonNull MovieModel MovieResponse) {
                Log.d(TAG,"OnNext"+MovieResponse.getData().getMovies());
                searchviewInterface.displayResult(MovieResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                searchviewInterface.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }

}

