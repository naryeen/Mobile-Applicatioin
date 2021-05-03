package edu.bt.todo11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String[] color = {"purple_200","purple_700","teal_200","MistyRose","Bisque","PeachPuff","Gold",
            "LightSalmon","HotPink","Fuchsia","MintCream","Plum","Chocolate"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
    }

    public void change_color(View view) {
        Random random=new Random();
        String ColorName = color[random.nextInt(13)];
        int colorRes = getResources().getIdentifier(ColorName,"color",getApplicationContext().getPackageName());
        int colorRess= ContextCompat.getColor(this,colorRes);
        textView.setTextColor(colorRess);
    }

    public void clickDonut(View view) {
    }

    public void clickIceCream(View view) {
    }

    public void clickFroyo(View view) {
    }
}