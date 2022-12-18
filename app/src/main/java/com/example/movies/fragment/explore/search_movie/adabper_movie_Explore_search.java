package com.example.movies.fragment.explore.search_movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class adabper_movie_Explore_search extends RecyclerView.Adapter<adabper_movie_Explore_search.PostViewHolder>  implements Filterable {

    private ArrayList<Movie> movilist=new ArrayList<>();
    List<Movie> fullitems;
    Context context;
    public adabper_movie_Explore_search(ArrayList<Movie> movies, Context context) {
        movilist = movies;
        this.context = context;
    }

//    public  postadabper(Context context){
//        this.context=context;
//    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_movie,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull adabper_movie_Explore_search.PostViewHolder holder, int position) {
//        if(item.imageLink!=null && !item.imageLink.isEmpty()) {
//            Picasso.get().load().with(F.context)
//                    .load(item.imageLink)
//                    .placeholder(R.drawable.default_placeholder)
//                    .error(R.drawable.error_placeholder)
//                    // To fit image into imageView
//                    .fit()
//                    // To prevent fade animation
//                    .noFade()
//                    .into(viewHolder.postImage);
//        } else {
//            viewHolder.postImage.setImageDrawable(ContextCompat.getDrawable(F.context,R.drawable.default_placeholder));
//        }
        Picasso.get().load(  movilist.get(position).getLargeCoverImage()).into(holder.imageView);
        holder.name_movie.setText(movilist.get(position).getTitle());
        holder.rate_movie.setText(movilist.get(position).getRating()+"");
        holder.ratingBar.setRating((float)(movilist.get(position).getRating()/2));

    }

    @Override
    public int getItemCount() {
        return movilist!=null? movilist.size() :0;
    }

    public void setlist(ArrayList<Movie> movilist){
        this.movilist=movilist;
        fullitems=new ArrayList<>(movilist);

        notifyDataSetChanged();


    }



    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView name_movie,rate_movie;
        ImageView imageView;
        RatingBar ratingBar;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            rate_movie=itemView.findViewById(R.id.rate_movie);
            name_movie=itemView.findViewById(R.id.name_movie);
            imageView=itemView.findViewById(R.id.film_photo);
            ratingBar=itemView.findViewById(R.id.ratingBar);

        }
    }

    @Override
    public Filter getFilter() {
        return examplefilter;
    }
    private  Filter examplefilter=new Filter() {
        // work on background
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Movie> filteredlist=new ArrayList<>();
            if(constraint==null||constraint.length()==0){
                //لو مفيش كلام مكتوب للبحث عنه اعرض list كلها
                filteredlist.addAll(fullitems);
                // لو كتب حاجه ف مربع السيرش
            }else{
                String filterpattern=constraint.toString().toLowerCase().trim(); //trim عشات اسيب المسافه الي ف اول الكلام
                for(Movie v:fullitems){
                    if(v.getTitle().toLowerCase().contains(filterpattern)
                            ||v.getTitle().toLowerCase().contains(filterpattern)){
                        // لو هو العنصر الي ف list بيحتو علي الحرف الي هو كتبه ف السيرش حط item في list دي
                        filteredlist.add(v);
                    }
                }
            }
            FilterResults results=new FilterResults();
            // publishResult ده هيرجع list الي ظهرت من البحث ل
            results.values=filteredlist;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            movilist.clear();
            movilist.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };



}

