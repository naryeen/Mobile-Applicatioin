package edu.bt.pythonquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.GridView;

public class SetsActivity extends AppCompatActivity {
    private GridView sets_grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        Toolbar toolbar = findViewById(R.id.toolbar);
        getActionBar(toolbar)
    }
}