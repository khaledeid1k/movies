package com.example.movies.fragment.Details.Cast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.model.screenshots.Cast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter_cast extends RecyclerView.Adapter<Adapter_cast.ViewHolderr> {

    private List<Cast> data=new ArrayList<>();

    public Adapter_cast(List<Cast> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public Adapter_cast.ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderr(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_cast,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_cast.ViewHolderr holder, int position) {
        Picasso.get().load(data.get(position).getUrlSmallImage()).into(holder.imageView);
        holder.textView.setText(data.get(position).getName());
    }



    @Override
    public int getItemCount() {
        return data==null?0 :data.size() ;
    }

    public class ViewHolderr extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolderr(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_cast);
            textView=itemView.findViewById(R.id.name_cast);
        }
    }
}