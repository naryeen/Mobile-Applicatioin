package gcit.edu.bt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static gcit.edu.bt.myapplication.R.id.btn_reset;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtCounter;
    private Button btnCount, btnReset,btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCounter =findViewById(R.id.txt_counter);
        btnCount=findViewById(R.id.btn_count);
        btnReset = findViewById(R.id.btn_reset);
        btnToast=findViewById(R.id.btn_toast);

        btnToast.setOnClickListener(this);
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(txtCounter.getText().toString());
                counter++;
                //update the value in the textCounter
                txtCounter.setText(counter+"");
            }
        });
            btnReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                txtCounter.setText("0");

                }
            });
    }

    @Override
    public void onClick(View v)
    {
        Toast.makeText(this,"Hello Toast!",Toast.LENGTH_SHORT).show();
    }
}
