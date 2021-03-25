package com.example.matching;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StaticRVViewholder> {

    private ArrayList<StaticRvModel> items;
    int row_index = 0;
    UpdateRecyclerView updateRecyclerView;
    Activity activity;
    boolean check = true;
    boolean select = true;
    public StaticRvAdapter(ArrayList<StaticRvModel> items, Activity activity, UpdateRecyclerView updateRecyclerView){
            this.items = items;
            this.activity = activity;
            this.updateRecyclerView = updateRecyclerView;
    }

    @NonNull
    @Override
    public StaticRVViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StaticRVViewholder staticRVViewholder = new StaticRVViewholder(view);
        return  staticRVViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRVViewholder holder, int position) {
            StaticRvModel currentItem = items.get(position);
            holder.imageView.setImageResource(currentItem.getImage());
            holder.textView.setText(currentItem.getText());


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
                updateRecyclerView.callback(currentItem);
            }
        });

        if(row_index == position){
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
        }else{
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewholder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;
        public StaticRVViewholder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }
    }
}
