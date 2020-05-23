package com.codehub.pfacademy12;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        List<Object> array = new ArrayList<Object>();
        array.add("hello");
        array.add("from");
        array.add("the");
        array.add("other");
        array.add("side");
        array.add("this");
        array.add("is");
        array.add("a");
        array.add("list");
        array.add("test");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setAdapter(new RecAdapter(array, new ItemClickListener() {
//            @Override
//            public void onItemClick(Object item) {
//                // object item
//            }
//        }));
      adapter = new CustomAdapter(new ItemClickListener() {
          @Override
          public void onItemClick(Object item) {
          }
      });
      recyclerView.setAdapter(adapter);
      adapter.submitList(array);
    }
}
