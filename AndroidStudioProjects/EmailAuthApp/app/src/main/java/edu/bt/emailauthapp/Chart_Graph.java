  package edu.bt.emailauthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Chart_Graph extends AppCompatActivity {
    BarChart bar_chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart__graph);
        bar_chart = findViewById(R.id.bar_chart);


        //Pass values through arrays
        ArrayList<BarEntry>  data = new ArrayList<>();

        data.add(new BarEntry(1999,2500));
        data.add(new BarEntry(1998,2000));
        data.add(new BarEntry(1997,1500));
        data.add(new BarEntry(1996,1000));
        data.add(new BarEntry(1995,500));

       BarDataSet barDataSet = new BarDataSet(data,"Food Data");
       barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
       barDataSet.setValueTextColor(Color.GREEN);
       barDataSet.setValueTextSize(20f);

        BarData barData = new BarData(barDataSet);
        bar_chart.setFitBars(true);
        bar_chart.setData(barData);
        bar_chart.getDescription().setText("Data Values");
        bar_chart.animateY(2000);
    }
}