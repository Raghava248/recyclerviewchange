package com.example.matching;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DynamicRVFemaleAdapter extends RecyclerView.Adapter<DynamicRVFemaleAdapter.DynamicRvHolder>{

    public ArrayList<DynamicRVModel> dynamicRVModels;

    public DynamicRVFemaleAdapter(ArrayList<DynamicRVModel> dynamicRVModels){
        this.dynamicRVModels = dynamicRVModels;
    }

    public class DynamicRvHolder extends RecyclerView.ViewHolder {

        public EditText editText;
        public TextView textView;

        public DynamicRvHolder(@NonNull View itemView) {
            super(itemView);

            //imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.name);
            editText = itemView.findViewById(R.id.editText);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    dynamicRVModels.get(getAdapterPosition()).setEditTextValue(editText.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }
    }

    @NonNull
    @Override
    public DynamicRVFemaleAdapter.DynamicRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_item_layout,parent,false);
        return new DynamicRvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRVFemaleAdapter.DynamicRvHolder holder, int position) {
            DynamicRVModel currentItem = dynamicRVModels.get(position);
            holder.textView.setText(currentItem.getName());
            holder.editText.setText(dynamicRVModels.get(position).getEditTextValue());

    }

    @Override
    public int getItemCount() {
        return dynamicRVModels.size();
    }


}
