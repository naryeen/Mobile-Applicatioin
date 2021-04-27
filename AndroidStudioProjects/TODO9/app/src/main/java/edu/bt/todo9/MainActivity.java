package edu.bt.todo9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private EditText editTextView1;
    private EditText editTextView2;
    private TextView editTextView3;
    public Ccalculator ccalculator;
    Ccalculator ress=new Ccalculator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextView1=findViewById(R.id.editTextView1);
        editTextView2 = findViewById(R.id.editTextView2);
        editTextView3 = findViewById(R.id.editTextView3);


    }

    public void Add(View view) {
        String value1=editTextView1.getText().toString();
        String value2 =editTextView2.getText().toString();
        Double add= ress.add(Double.valueOf(value1),Double.valueOf( value2));
        editTextView3.setText(String.valueOf(add));

    }


    public void Sub(View view) {
        String value1=editTextView1.getText().toString();
        String value2 =editTextView2.getText().toString();
        Double sub = ress.sub(Double.valueOf(value1),Double.valueOf( value2));
        editTextView3.setText(String.valueOf(sub));
        Log.d("Debugging:","Operation failed");

    }

    public void mul(View view) {
        String value1=editTextView1.getText().toString();
        String value2 =editTextView2.getText().toString();
        Double mul = ress.mul(Double.valueOf(value1),Double.valueOf( value2));
        editTextView3.setText(String.valueOf(mul));
    }

    public void Div(View view) {
        String value1=editTextView1.getText().toString();
        String value2 =editTextView2.getText().toString();
        Double div = ress.div(Double.valueOf(value1),Double.valueOf( value2));
        editTextView3.setText(String.valueOf(div));
    }
}