package com.example.movies.fragment.Favoritrs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.model.Movie;
import com.squareup.picasso.Picasso;

public class Adpter_favorite extends PagedListAdapter<Movie, Adpter_favorite.ItemViewHolderd> {

    public Context mCtx;
    Adpter_favorite.onclick onclick;
    public     interface  onclick{
        void click(Movie movie);
    }
    public void  onclick_item(Adpter_favorite.onclick onclick){
        this.onclick=onclick;
    }

    public Adpter_favorite(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;



    }


    @NonNull
    @Override
    public Adpter_favorite.ItemViewHolderd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.model_movie, parent, false);
        return new Adpter_favorite.ItemViewHolderd(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adpter_favorite.ItemViewHolderd holder, int position) {

        Movie  MovieRancklist = getItem(position);
        if (MovieRancklist != null) {
            Picasso.get().load( MovieRancklist.getLargeCoverImage()).into(holder.imageView);
            holder.name_movie.setText(MovieRancklist.getTitle());
            holder.rate_movie.setText(MovieRancklist.getRating()+"");
            holder.ratingBar.setRating((float)(MovieRancklist.getRating()/2));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclick.click(getItem(position));
                }
            });
        }else{
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }
    }

    private static DiffUtil.ItemCallback<Movie> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Movie>() {
                @Override
                public boolean areItemsTheSame(Movie oldItem, Movie newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(Movie oldItem, Movie newItem) {
                    return oldItem.equals(newItem);
                }
            };


    class ItemViewHolderd extends RecyclerView.ViewHolder {


        TextView name_movie,rate_movie;
        ImageView imageView;
        RatingBar ratingBar;
        CardView cardView;
        //    FragmentCommunication mComminication;

        public ItemViewHolderd(View itemView) {
            super(itemView);
            rate_movie=itemView.findViewById(R.id.rate_movie);
            name_movie=itemView.findViewById(R.id.name_movie);
            imageView=itemView.findViewById(R.id.film_photo);
            ratingBar=itemView.findViewById(R.id.ratingBar);
            cardView=itemView.findViewById(R.id.item_movie);

        }

    }
}
