package com.example.movies.fragment.Details.Screenshots;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class screenshots_Adapter extends RecyclerView.Adapter<screenshots_Adapter.ViewHolder> {

    private List<String> data=new ArrayList<>();

    public screenshots_Adapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.model_screenshots, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Glide.with(holder.itemView.getContext())
//                .load(data.get(position).getData().getMovie().getLargeScreenshotImage1())
//                .into(holder.image);
        Picasso.get().load(data.get(position)).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return  data.size();
        //data==null ? 0 :
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_for_item);
        }
    }
}