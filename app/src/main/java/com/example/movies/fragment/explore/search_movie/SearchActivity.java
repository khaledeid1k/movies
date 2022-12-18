package com.example.movies.fragment.explore.search_movie;

import android.app.SearchManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.model.Movie;
import com.example.movies.model.MovieModel;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements SearchViewInterface{
    SearchPresenter searchPresenter;
    private SearchView searchView;
    private adabper_movie_Explore_search adapter;
    RecyclerView rvQueryResult;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mToolbar=findViewById(R.id.toolbarr);
        setSupportActionBar(mToolbar);
        rvQueryResult = findViewById(R.id.rvQueryResult);
        rvQueryResult.setLayoutManager(new LinearLayoutManager(this));
        searchPresenter = new SearchPresenter(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_movie,menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.searhicon).getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Enter Movie name..");


            searchPresenter.getResultsBasedOnQuery(searchView);



        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.searhicon){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void displayResult(MovieModel movieResponse) {
        adapter = new adabper_movie_Explore_search((ArrayList<Movie>) movieResponse.getData().getMovies(),SearchActivity.this);
        rvQueryResult.setAdapter(adapter);

    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void showToast(String str) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
