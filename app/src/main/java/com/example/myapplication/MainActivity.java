package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        int id = intent.getIntExtra("internship_id", 0);
        if (id != 0) {
            String title = intent.getStringExtra("internship_title");
            if (id == 1) {
                Intent intentAnswers = new Intent(this, SettingsActivity.class);
                startActivity(intentAnswers);
                this.finish();
            } else {
                Toast.makeText(this, "You have applied to " + title, Toast.LENGTH_LONG).show();
                this.finish();
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_internship);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        InternshipAdapter clothesAdapter = new InternshipAdapter();
        recyclerView.setAdapter(clothesAdapter);

    }
}
