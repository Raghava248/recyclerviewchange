package com.example.matching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements UpdateRecyclerView {

    private RecyclerView recyclerView, recyclerView2;
    private StaticRvAdapter staticRvAdapter;

    public ArrayList<DynamicRVModel> items , items1 ;
    DynamicRVAdapter dynamicRVAdapter;
    DynamicRVFemaleAdapter dynamicRVFemalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.male,"male"));
        item.add(new StaticRvModel(R.drawable.female,"female"));
        item.add(new StaticRvModel(R.drawable.results,"results"));

        recyclerView = findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item, this,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(staticRvAdapter);

        items =  populateList();
        recyclerView2 = findViewById(R.id.rv_2);
        dynamicRVAdapter = new DynamicRVAdapter(items);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView2.setAdapter(dynamicRVAdapter);


        items1 = populateFemaleList();

        dynamicRVFemalAdapter = new DynamicRVFemaleAdapter(items1);
        dynamicRVFemalAdapter.notifyDataSetChanged();

    }

    private ArrayList<DynamicRVModel> populateFemaleList() {
        ArrayList<DynamicRVModel> female_list = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            DynamicRVModel dynamicRVModel = new DynamicRVModel();
            dynamicRVModel.setEditTextValue("");
            female_list.add(dynamicRVModel);
        }
        return female_list;
    }

    private ArrayList<DynamicRVModel> populateList() {
        ArrayList<DynamicRVModel> list =new ArrayList<>();

        for(int i = 0; i < 8; i++){
                DynamicRVModel dynamicRVModel = new DynamicRVModel();
                dynamicRVModel.setEditTextValue("");
                list.add(dynamicRVModel);
        }
        return list;
    }

    @Override
    public void callback(StaticRvModel clickedItem) {

        if(clickedItem.getText() == "male") {
            recyclerView2.setAdapter(dynamicRVAdapter);
        } else if(clickedItem.getText() == "female"){
            recyclerView2.setAdapter(dynamicRVFemalAdapter);
        } else if(clickedItem.getText() == "results"){
            /*dynamicResultsRVAdapter.dynamicRVModels.clear();
            dynamicResultsRVAdapter.dynamicRVModels.addAll(dynamicRVAdapter.getSelectedItemsList());
            dynamicResultsRVAdapter.dynamicRVModels.addAll(dynamicRVAdapter.getSelectedItemsList());
            recyclerView2.setAdapter(dynamicResultsRVAdapter);*/
        }

    }
}