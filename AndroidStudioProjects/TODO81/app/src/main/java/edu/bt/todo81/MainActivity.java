package edu.bt.todo81;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
    }

    public void onclick(View view) {
        String message = editText.getText().toString();
        Uri url=Uri.parse(message);
        Intent intent=new Intent(Intent.ACTION_VIEW,url);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }

    public void openLocation(View view) {
        String location = editText1.getText().toString();
        Uri url=Uri.parse(location);
        Intent intent = new Intent(Intent.ACTION_VIEW,url);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else{
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void billing(View view) {
        String message = editText2.getText().toString();
        String minType= "text/plain";
        ShareCompat.IntentBuilder.from(this).setType(minType).setChooserTitle(R.string.share_text_with)
                .setText(message)
                .startChooser();

    }
}