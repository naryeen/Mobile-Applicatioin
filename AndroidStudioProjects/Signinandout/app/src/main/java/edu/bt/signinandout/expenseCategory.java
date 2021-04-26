package edu.bt.signinandout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class expenseCategory extends AppCompatActivity {
    private EditText Ccalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_category);
        Ccalculator=findViewById(R.id.expenseCal);

        Ccalculator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcu();
            }

            private void calcu() {
                Intent intent = new Intent(expenseCategory.this,Calculator.class);
                startActivity(intent);
            }

        });
    }



}
