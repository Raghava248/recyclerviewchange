package com.example.matching;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DynamicRVAdapter extends RecyclerView.Adapter<DynamicRVAdapter.DynamicRvHolder>{

    public ArrayList<DynamicRVModel> dynamicRVModels;

    public DynamicRVAdapter(ArrayList<DynamicRVModel> dynamicRVModels){
        this.dynamicRVModels = dynamicRVModels;
    }

    public class DynamicRvHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        ConstraintLayout constraintLayout;
        public DynamicRvHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.name);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }

    @NonNull
    @Override
    public DynamicRVAdapter.DynamicRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_item_layout,parent,false);
        DynamicRvHolder dynamicRvHolder = new DynamicRvHolder(view);
        return dynamicRvHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRVAdapter.DynamicRvHolder holder, int position) {
            DynamicRVModel currentItem = dynamicRVModels.get(position);
            holder.imageView.setImageResource(currentItem.getImage());
            holder.textView.setText(currentItem.getName());

    }

    @Override
    public int getItemCount() {
        return dynamicRVModels.size();
    }


}


