package com.example.movies.fragment.Details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.fragment.Details.Cast.Adapter_cast;
import com.example.movies.fragment.Details.Screenshots.screenshots_Adapter;
import com.example.movies.model.Movie;
import com.example.movies.model.screenshots.Sceernshots;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;

import static androidx.navigation.fragment.NavHostFragment.findNavController;


public class Details extends Fragment {

public TextView title_details,rate_movie,Description,category,MpaRating;
ImageView small_cover,Bigcover;
    ArrayList list;
    DiscreteScrollView scrollView;
    RecyclerView recyclerView;
    postmovie postmovie;
    LikeButton heart;

    public Details() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new
                OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                findNavController(getParentFragment()).popBackStack();

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         scrollView = view.findViewById(R.id.discreteScrollView_details);
          recyclerView=view.findViewById(R.id.recycle_cast_items);
        postmovie= ViewModelProviders.of(getActivity()).get(postmovie.class);
        title_details=view.findViewById(R.id.title_details);
        rate_movie=view.findViewById(R.id.rate_movie_details);
        Description=view.findViewById(R.id.Description_movie);
        small_cover=view.findViewById(R.id.small_cover);
        category=view.findViewById(R.id.category_movie_deatails);
        Bigcover=view.findViewById(R.id.Big_cover);
        heart=view.findViewById(R.id.heart_movie);
        heart.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                likeButton.setLiked(true);


                Toast.makeText(getContext(), "liked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                Toast.makeText(getContext(), "unliked", Toast.LENGTH_SHORT).show();


            }
        });





    }
    public  void onStart() {
        super.onStart();
        Movie b = (Movie) getArguments().get("key");
        postmovie.getMovieDetails(b.getId());
        postmovie.movieMutableLiveDetails.
                observe(getViewLifecycleOwner(), new Observer<Sceernshots>() {
                    @Override
                    public void onChanged(Sceernshots movieModel) {
                        title_details.setText(movieModel.getData().getMovie().getTitle());
                        rate_movie.setText(movieModel.getData().getMovie().getRating().toString());
                        Description.setText(movieModel.getData().getMovie().getDescriptionFull());
                        category.setText(movieModel.getData().getMovie().getGenres().get(0));
                        Picasso.get().load(movieModel.getData().getMovie().getBackgroundImage()).into(Bigcover);
                        Picasso.get().load(movieModel.getData().getMovie().getSmallCoverImage()).into(small_cover);
                        list = new ArrayList();
                        list.add(movieModel.getData().getMovie().getMediumScreenshotImage1());
                        list.add(movieModel.getData().getMovie().getMediumScreenshotImage2());
                        list.add(movieModel.getData().getMovie().getMediumScreenshotImage3());
                        scrollView.setAdapter(new screenshots_Adapter(list));
                        recyclerView.setAdapter(new Adapter_cast(movieModel.getData().getMovie().getCast()));


                    }
                });
    }


}