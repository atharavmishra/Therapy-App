package com.example.therapyapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.therapyapp.Model.Datum;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    Context context;
    ArrayList<Datum> arraylist;
    public Adapter(Context context, ArrayList<Datum> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Glide.with(context).load(arraylist.get(position).getProfile()).into(holder.imageview);
        holder.textview.setText(arraylist.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView textview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview= itemView.findViewById(R.id.image);
            textview = itemView.findViewById(R.id.myImageViewText);


        }
    }
}
