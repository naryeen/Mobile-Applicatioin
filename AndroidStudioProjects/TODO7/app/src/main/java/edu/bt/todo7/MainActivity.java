package edu.bt.todo7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int nCount =0;
    private TextView Count_up;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Count_up =findViewById(R.id.countUp);
        button = findViewById(R.id.button);

        if(savedInstanceState != null){
            nCount = savedInstanceState.getInt("count");
            Count_up.setText(String.valueOf(nCount));
        }
    }

    public void clickactivity(View view) {
        nCount++;
        if (Count_up != null)
            Count_up.setText(Integer.toString(nCount));
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",nCount);

    }
}