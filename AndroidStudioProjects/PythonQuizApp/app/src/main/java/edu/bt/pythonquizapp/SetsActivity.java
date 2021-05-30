package edu.bt.pythonquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

public class SetsActivity extends AppCompatActivity {
     GridView sets_grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

//        getSupportActionBar().setTitle("Categories");
//        Toolbar toolbar = findViewById(R.id.sets_toolbar);
//        setSupportActionBar(toolbar);

//        String title = getIntent().getStringExtra("Category");
//        getSupportActionBar().setTitle(title);
//        Toolbar myToolbar = findViewById(R.id.sets_toolbar);
//        setSupportActionBar(myToolbar);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setLogo(R.mipmap.ic_launcher);
//            getSupportActionBar().setDisplayUseLogoEnabled(true);
//        }

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