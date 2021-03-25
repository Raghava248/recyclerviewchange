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

    ArrayList<DynamicRVModel> items , items1 ;
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

        items = new ArrayList<>();
        items.add(new DynamicRVModel("Education Details"));
        items.add(new DynamicRVModel("pizza 3"));
        items.add(new DynamicRVModel("pizza 4"));
        items.add(new DynamicRVModel("pizza 5"));
        items.add(new DynamicRVModel("pizza 6"));
        items.add(new DynamicRVModel("pizza 7"));
        items.add(new DynamicRVModel("pizza 8"));
        items.add(new DynamicRVModel("pizza 9"));
        items.add(new DynamicRVModel("pizza 10"));
        items.add(new DynamicRVModel("pizza 11"));
        items.add(new DynamicRVModel("pizza 12"));
        items.add(new DynamicRVModel("pizza 13"));
        items.add(new DynamicRVModel("pizza 14"));

        recyclerView2 = findViewById(R.id.rv_2);
        dynamicRVAdapter = new DynamicRVAdapter(items);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView2.setAdapter(dynamicRVAdapter);

        items1 = new ArrayList<>();
        items1.add(new DynamicRVModel("burger 1"));
        items1.add(new DynamicRVModel("burger 2"));
        items1.add(new DynamicRVModel("burger 3"));
        items1.add(new DynamicRVModel("burger 4"));
        items1.add(new DynamicRVModel("burger 5"));
        items1.add(new DynamicRVModel("burger 6"));
        items1.add(new DynamicRVModel("burger 7"));
        items1.add(new DynamicRVModel("burger 8"));
        items1.add(new DynamicRVModel("burger 9"));
        items1.add(new DynamicRVModel("burger 10"));
        items1.add(new DynamicRVModel("burger 11"));
        items1.add(new DynamicRVModel("burger 12"));
        items1.add(new DynamicRVModel("burger 13"));
        items1.add(new DynamicRVModel("burger 14"));
        dynamicRVFemalAdapter = new DynamicRVFemaleAdapter(items1);
        dynamicRVFemalAdapter.notifyDataSetChanged();

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