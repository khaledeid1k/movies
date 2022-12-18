package com.example.movies.fragment.Rack.refresh;

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
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.model.Movie;
import com.squareup.picasso.Picasso;


public class ItemAdapter extends PagedListAdapter<Movie,ItemAdapter.ItemViewHolderd> {

    public Context mCtx;


    public ItemAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolderd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.model_ranks, parent, false);
        return new ItemViewHolderd(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderd holder, int position) {

        Movie MovieRancklist = getItem(position);
        if (MovieRancklist != null) {
            Picasso.get().load(MovieRancklist.getLargeCoverImage()).into(holder.cover_film1);
            holder.Rate1.setText(MovieRancklist.getRating()+"");
            holder.category_film1.setText(MovieRancklist.getGenres().get(0));
            holder.title_film1.setText(MovieRancklist.getTitle());
            holder.Poisition_film_in_list1.setText(position+1+"");
            holder.year_film1.setText(MovieRancklist.getYear()+"");
            holder.ratingBar.setRating((float)(MovieRancklist.getRating()/2));
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


        TextView Poisition_film_in_list1,Rate1,title_film1,category_film1,year_film1;
        ImageView cover_film1;
        RatingBar ratingBar;
        public ItemViewHolderd(View itemView) {
            super(itemView);
            cover_film1=itemView.findViewById(R.id.cover_film);
            Rate1=itemView.findViewById(R.id.Rate);
            Poisition_film_in_list1=itemView.findViewById(R.id.Poisition_film_in_list);
            title_film1=itemView.findViewById(R.id.title_film);
            category_film1=itemView.findViewById(R.id.category_film);
            year_film1=itemView.findViewById(R.id.year_film);
            ratingBar=itemView.findViewById(R.id.ratingBar2);
        }
    }
}
