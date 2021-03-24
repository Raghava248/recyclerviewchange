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

    ArrayList<DynamicRVModel> items , items1 = new ArrayList();
    DynamicRVAdapter dynamicRVAdapter;

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
        items1 = new ArrayList<>();
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

        recyclerView2 = findViewById(R.id.rv_2);
        dynamicRVAdapter = new DynamicRVAdapter(items);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView2.setAdapter(dynamicRVAdapter);

    }

    @Override
    public void callback(StaticRvModel clickedItem) {
        ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
        if(clickedItem.getText() == "male"){
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
                dynamicRVAdapter = new DynamicRVAdapter(items);
                dynamicRVAdapter.notifyDataSetChanged();
                recyclerView2.setAdapter(dynamicRVAdapter);
            }else if(clickedItem.getText() == "female"){
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
            dynamicRVAdapter = new DynamicRVAdapter(items);
            dynamicRVAdapter.notifyDataSetChanged();
            recyclerView2.setAdapter(dynamicRVAdapter);
            }else if(clickedItem.getText() == "results"){


            items1.add(new DynamicRVModel("",R.drawable.blank));
            dynamicRVAdapter = new DynamicRVAdapter(items1);
            dynamicRVAdapter.notifyDataSetChanged();
            recyclerView2.setAdapter(dynamicRVAdapter);

        }

    }
}