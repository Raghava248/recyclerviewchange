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

    ArrayList<DynamicRVModel> items , items1 ,items2 = new ArrayList();
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

    }

    @Override
    public void callback(StaticRvModel clickedItem) {

        if(clickedItem.getText() == "male"){
                dynamicRVAdapter = new DynamicRVAdapter(items);
                dynamicRVAdapter.notifyDataSetChanged();
                recyclerView2.setAdapter(dynamicRVAdapter);
            }else if(clickedItem.getText() == "female"){
            items2.add(new DynamicRVModel("burger 1"));
                items2.add(new DynamicRVModel("burger 2"));
                items2.add(new DynamicRVModel("burger 3"));
                items2.add(new DynamicRVModel("burger 4"));
                items2.add(new DynamicRVModel("burger 5"));
                items2.add(new DynamicRVModel("burger 6"));
                items2.add(new DynamicRVModel("burger 7"));
                items2.add(new DynamicRVModel("burger 8"));
                items2.add(new DynamicRVModel("burger 9"));
                items2.add(new DynamicRVModel("burger 10"));
                items2.add(new DynamicRVModel("burger 11"));
                items2.add(new DynamicRVModel("burger 12"));
                items2.add(new DynamicRVModel("burger 13"));
                items2.add(new DynamicRVModel("burger 14"));
            dynamicRVFemalAdapter = new DynamicRVFemaleAdapter(items2);
            dynamicRVFemalAdapter.notifyDataSetChanged();
            recyclerView2.setAdapter(dynamicRVFemalAdapter);
            }else if(clickedItem.getText() == "results"){
            items1 = new ArrayList<>();
            items1.add(new DynamicRVModel(""));
            dynamicRVAdapter = new DynamicRVAdapter(items1);
            dynamicRVAdapter.notifyDataSetChanged();
            recyclerView2.setAdapter(dynamicRVAdapter);

        }

    }
}