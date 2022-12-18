package com.example.movies.fragment.explore;

import android.app.SearchManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.movies.R;
import com.example.movies.fragment.explore.refresh.ItemViewModel_explor;
import com.example.movies.fragment.explore.refresh.adapter_Explore;
import com.example.movies.fragment.explore.search_movie.SearchPresenter;
import com.example.movies.fragment.explore.search_movie.SearchViewInterface;
import com.example.movies.fragment.explore.search_movie.adabper_movie_Explore_search;
import com.example.movies.model.Movie;
import com.example.movies.model.MovieModel;

import java.util.ArrayList;
import java.util.List;


public class Explore extends Fragment implements SearchViewInterface   {

    Adabper_categry adabper_categry;
    SearchPresenter searchPresenter;
    Toolbar mToolbar;
    ItemViewModel_explor itemViewModelz;
    adapter_Explore adabper;
    public static SwipeRefreshLayout refreshMoviesList;
    RecyclerView recyclerView_category;
    RecyclerView recyclerView;
    private SearchView searchView;
    private NavController navigation;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_explor, container, false);

    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigation = Navigation.findNavController(view);
        mToolbar=view.findViewById(R.id.toolbare);
         refreshMoviesList=view.findViewById(R.id.refreshMoviesList);
        recyclerView = view.findViewById(R.id.recycle_movie_items);
        recyclerView_category = view.findViewById(R.id.recycle_category_items);
        setupMVP();
        put_data_recycle();

        Category_Movie();

    }

    private void put_data_recycle() {
        //toolbar
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        // for view model and put data in recycle
        itemViewModelz = ViewModelProviders.of(this).get(ItemViewModel_explor.class);
        adabper = new adapter_Explore(getActivity());

        itemViewModelz.itemPagedList.observe(getViewLifecycleOwner(),
                new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(@Nullable PagedList<Movie> items) {
                refreshMoviesList.setRefreshing(false);


                //in case of any changes
                //submitting the items to adapter
                adabper.submitList(items);


            }
        });
        adabper.onclick_item(new adapter_Explore.onclick() {
            @Override
            public void click(Movie movie) {
//                movie=new Movie(movie.getTitle(),movie.getRating(),movie.getGenres(),movie.getYear(),
//                        movie.getDescriptionFull(),movie.getLanguage(),movie.getSmallCoverImage(),movie.getLargeCoverImage());
                movie=new Movie(movie.getId());
                Bundle bundle=new Bundle();
//                bundle.putString("title",movie.getTitle());
//                bundle.putDouble("rate",movie.getRating());
                bundle.putParcelable("key",movie);



//                bundle.put("cato",movie.getGenres().get(0));
//                bundle.putDouble("rate",movie.getRating());

                    navigation.navigate(R.id.action_fragmentExplor2_to_details2,bundle);
            }
        });

        recyclerView.setAdapter(adabper);

    }
//    adapter_Explore.FragmentCommunication communication=new adapter_Explore.FragmentCommunication() {
//        @Override
//        public void respond(int position,String name,String job) {
//            Details fragmentB=new Details();
//            Bundle bundle=new Bundle();
//            bundle.putString("NAME",name);
//            bundle.putString("JOB",job);
//            fragmentB.setArguments(bundle);
//            FragmentManager manager=getFragmentManager();
//            FragmentTransaction transaction=manager.beginTransaction();
//            transaction.replace(R.id.fragmentExplor2,fragmentB).commit();
//        }
//
//    };
    private void Category_Movie() {
        // for recycle category items
        adabper_categry = new Adabper_categry();
        recyclerView_category.setAdapter(adabper_categry);
        getDataSource_category();
    }

    public void getDataSource_category() {
        String category[] = {"All", "Comedy", "Science fiction", "Horror", "Romance", "Action",
                "Thriller", "Drama", "Mystery", "Crime", "Animation", "Adventure", "Fantasy",
                "Comedy", "Romance", "Action", "Comedy", "Superhero"};
        List<Categories> categories = new ArrayList<>();
        for (int i = 0; i < category.length; i++) {
            categories.add(new Categories(category[i]));
        }
        adabper_categry.setdata(categories);
        adabper_categry.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       getActivity().getMenuInflater().inflate(R.menu.search_movie,menu);
        SearchManager searchManager = (SearchManager)getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.searhicon).getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Enter Movie name..");
        searchPresenter.getResultsBasedOnQuery(searchView);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.searhicon){
            return true;
        }
        return super.onOptionsItemSelected(item); }

    private void setupMVP(){
        searchPresenter = new SearchPresenter(this);
    }

    @Override
    public void displayResult(MovieModel movieResponse) {
        adabper_movie_Explore_search adabper = new adabper_movie_Explore_search((ArrayList<Movie>) movieResponse.getData().getMovies(), getActivity());

        recyclerView.setAdapter(adabper);
    }
    @Override
    public void displayError(String s) {
        showToast(s);
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
