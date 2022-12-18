package com.example.movies.fragment.Rack.refresh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.movies.R;
import com.example.movies.model.Movie;


public class Ranck extends Fragment {

 public   static SwipeRefreshLayout  swipeRefreshLayout;

    public Ranck() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ranck, container, false);
    }
    ItemViewModel itemViewModel;
    //creating the Adapter
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

          swipeRefreshLayout=view.findViewById(R.id.refreshMoviesList_rank);

       itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        final ItemAdapter adapter = new ItemAdapter(getActivity());
        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(@Nullable PagedList<Movie> items) {
                swipeRefreshLayout.setRefreshing(false);

                //in case of any changes
                //submitting the items to adapter
                adapter.submitList(items);
            }
        });
        RecyclerView recyclerView=view.findViewById(R.id.Recycle_Rank);

        recyclerView.setAdapter(adapter);
//         RecyclerView recyclerView=view.findViewById(R.id.Recycle_Rank);
//        final adapter_movie_Ranck adapter=new adapter_movie_Ranck();
//        recyclerView.setAdapter(adapter);
//
//        postmovie.RankMoviesLiveData.observe(getActivity(), new Observer<MovieModel>() {
//        @Override
//        public void onChanged(MovieModel movieModel) {
//            adapter.setlist((ArrayList<Movie>) movieModel.getData().getMovies());
//        }
//    });

    }



    }

