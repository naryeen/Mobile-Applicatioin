package edu.bt.todo82;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView text_uri_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_uri_message=findViewById(R.id.text_uri_message);
        Intent intent = getIntent();
        Uri url = intent.getData();
        if(url!=null){
            String string=getString(R.string.uri_label)
                    +url.toString();
            text_uri_message.setText(string);
        }
    }
}