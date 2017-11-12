package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Model> list;
    private Model m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageList();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyRecyclerAdapter(list, this));
    }

    private void imageList() {
        list = new ArrayList<>();
        m = new Model();
        for (int i = 0; i < 10; i++) {
            m.setImg1(R.drawable.nkar1);
            m.setImg2(R.drawable.nkar2);
            m.setImg3(R.drawable.nkar4);
            m.setImgMec(R.drawable.nkar7);
            list.add(m);
        }
    }
}
