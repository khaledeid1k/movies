package com.example.movies.fragment.explore;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;

import java.util.ArrayList;
import java.util.List;

class Adabper_categry extends RecyclerView.Adapter<Adabper_categry.holder> {
    private List<Categories> categories;
//    boolean click = true;
//    private boolean multiSelect = false;
//    private ArrayList<String> selectedItems = new ArrayList<>();
int position;
    private ArrayList<Integer> selectedItems = new ArrayList<>();
    private int selectedPosition=-1;

    interface Click{
        void click_item(int position);
}
Click click;
public void Get_postion(Click click){
        this.click=click;
}

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_category, parent, false),click);
    }

    @Override
    public void onBindViewHolder(@NonNull final holder holder, final int position) {
        holder.textView.setText(categories.get(position).getCategory());

        if(selectedPosition==position)
            holder.textView.setBackgroundColor(Color.parseColor("#ffffff"));
        else
            holder.textView.setBackgroundColor(Color.parseColor("#757FB1"));

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition=position;
                notifyDataSetChanged();

            }
        });

//        holder.update(position);
//
//
//        holder.textView.setTag(position);
//        holder.textView.setId(position);
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onClick(View v) {
//
//                if (click) {
//                    holder.textView.setBackgroundColor(Color.RED);
//                    click = false;
//                } else {
//                    holder.textView.setBackgroundColor(Color.parseColor("#757FB1"));
//                    click = true;
//                }
//                notifyDataSetChanged();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return categories != null ? categories.size() : 0;
    }

    public void setdata(List<Categories> categories) {
        this.categories = categories;
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView textView;

        public holder(@NonNull View itemView, final Click click) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_category);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click!=null){
                     position=getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        click.click_item(position);
                    }
                }


            }
        });

        }
    }
}
