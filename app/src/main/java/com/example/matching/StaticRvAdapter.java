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
            if(check){
                ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                items.add(new DynamicRVModel("burger 1",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 2",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 3",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 4",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 5",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 6",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 7",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 8",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 9",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 10",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 11",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 12",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 13",R.drawable.profile_pic));
                items.add(new DynamicRVModel("burger 14",R.drawable.profile_pic));

                updateRecyclerView.callback(position,items);

                check = false;

            }

            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_index = position;
                    notifyDataSetChanged();

                    if(position == 0){
                        ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                        items.add(new DynamicRVModel("burger 1",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 2",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 3",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 4",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 5",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 6",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 7",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 8",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 9",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 10",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 11",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 12",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 13",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("burger 14",R.drawable.profile_pic));

                        updateRecyclerView.callback(position,items);
                    }else if(position == 1){
                        ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                        items.add(new DynamicRVModel("pizza 1",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 2",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 3",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 4",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 5",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 6",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 7",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 8",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 9",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 10",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 11",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 12",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 13",R.drawable.profile_pic));
                        items.add(new DynamicRVModel("pizza 14",R.drawable.profile_pic));

                        updateRecyclerView.callback(position,items);
                    }
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
