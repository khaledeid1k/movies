package com.example.movies.fragment.explore.search_movie;


import com.example.movies.model.MovieModel;

public interface SearchViewInterface {

    void displayResult(MovieModel movieResponse);
    void displayError(String s);
    void showToast(String str);
    void showProgressBar();
    void hideProgressBar();
}