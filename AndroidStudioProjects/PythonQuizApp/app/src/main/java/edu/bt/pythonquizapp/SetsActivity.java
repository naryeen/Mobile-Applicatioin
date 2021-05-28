package edu.bt.pythonquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

public class SetsActivity extends AppCompatActivity {
    private GridView sets_grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

//        Toolbar toolbar = findViewById(R.id.sets_toolbar);
//        setSupportActionBar(toolbar);

//        String title = getIntent().getStringExtra("Category");
//        getSupportActionBar().setTitle(title);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sets_grid =findViewById(R.id.sets_gridView);

        SetsAdapter adapter = new SetsAdapter(6);
        sets_grid.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            SetsActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}