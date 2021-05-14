package edu.bt.firebaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.BarChart;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Graph extends AppCompatActivity {
    EditText xValue,yValue;
    Button btn_insert;
    FirebaseFirestore database;
    DocumentReference reference;
    BarChart bar_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        xValue = (EditText)findViewById(R.id.xValue);
        yValue = (EditText)findViewById(R.id.yValue);




    }
}