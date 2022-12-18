package com.example.movies.fragment.explore.refresh;

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

public class adapter_Explore extends PagedListAdapter<Movie, adapter_Explore.ItemViewHolderd> {

    public Context mCtx;
onclick onclick;
public     interface  onclick{
        void click(Movie movie);
    }
    public void  onclick_item(onclick onclick){
        this.onclick=onclick;
    }

//    public interface FragmentCommunication {
//        void respond(int position,String name,String job);
//    }
//    private FragmentCommunication mCommunicator;
    public adapter_Explore(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
      //  mCommunicator=communication;



    }


    @NonNull
    @Override
    public ItemViewHolderd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.model_movie, parent, false);
        return new ItemViewHolderd(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderd holder, int position) {

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
//            holder.cardView.setOnClickListener(
//                    Navigation.createNavigateOnClickListener(R.id.details2));
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
            //mComminication=Communicator;

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(mlistener!=null){
//                        int postion=getAdapterPosition();
//                        if(postion!=RecyclerView.NO_POSITION) {
//                            mlistener.click(postion);
//                        }
//                    }
//                }
//            });
        }
//        @Override
//        public void onClick(View view) {
////            mComminication.respond(getAdapterPosition(),
////                    MovieRancklisitt.get(getAdapterPosition()).getTitle()
////                    ,MovieRancklisitt.get(getAdapterPosition()).getLanguage());
//        }
    }
}
