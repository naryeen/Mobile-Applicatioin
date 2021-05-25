package edu.bt.todo21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView nTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nTextView = findViewById(R.id.textView);


    }

    public void startTask(View view) {
        // Put a message in the text view
        nTextView.setText("Maping:::......");

        new SimpleAsynTask(nTextView).execute();
    }
}