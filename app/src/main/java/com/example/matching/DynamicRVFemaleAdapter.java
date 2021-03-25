package com.example.matching;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
    ArrayList<String> ExpAmtArray = new ArrayList<String>();
    boolean isOnTextChanged = false;
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

        }
    }

    @NonNull
    @Override
    public DynamicRVFemaleAdapter.DynamicRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_item_layout,parent,false);
        DynamicRvHolder dynamicRvHolder = new DynamicRvHolder(view);
        return dynamicRvHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRVFemaleAdapter.DynamicRvHolder holder, int position) {
            DynamicRVModel currentItem = dynamicRVModels.get(position);

            holder.textView.setText(currentItem.getName());

            EditText editText = holder.editText;
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //using this boolean because sometime when user enter value in edittxt
                    //after Text changed runs twice to prevent this, i m making use of this variable.
                    isOnTextChanged = true;
                }

                @Override
                public void afterTextChanged(Editable s) {

                    if (isOnTextChanged) {
                    isOnTextChanged = false;
                    try {
                        for (int i = 0; i <= position; i++) {
                            int inposition1 = position;
                            if (i != position) {
                                //store 0  where user select position in not equal/
                                ExpAmtArray.add("0");
                            }else {
                                // store user entered value to Array list (ExpAmtArray) at particular position
                                ExpAmtArray.add("0");
                                System.out.println(editText.getText().toString());
                                ExpAmtArray.set(inposition1,editText.getText().toString());
                                System.out.println("I am printing array in female");
                                System.out.println(ExpAmtArray);
                                break;
                            }
                        }

                    }catch (NumberFormatException e)
                    {
                        // catch is used because, when user enter value in editText and remove the value it
                        // it will trigger NumberFormatException, so to prevent it and remove data value from array ExpAmtArray

                        for (int i = 0; i <= position; i++) {
                            Log.d("TimesRemoved", " : " + i);
                            int newposition = position;
                            if (i == newposition) {
                                ExpAmtArray.set(newposition,"0");
                            }
                        }

                    }
                }

                }
            });


    }

    @Override
    public int getItemCount() {
        return dynamicRVModels.size();
    }


}
