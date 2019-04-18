package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Intent intent = getIntent();
//        String id = intent.getStringExtra("homescreen_meeting");
//        Log.d("asdasd", id);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView_internship);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        InternshipAdapter clothesAdapter=new InternshipAdapter();
        recyclerView.setAdapter(clothesAdapter);

    }
}
