package edu.bt.pythonquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {
    private TextView textViewSplash;
    private ImageView imageViewSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textViewSplash = findViewById(R.id.textViewSplash);
        imageViewSplash = findViewById(R.id.imageViewSplash);

        Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        textViewSplash.setTypeface(typeface);
        Animation ani = AnimationUtils.loadAnimation(this,R.anim.myanimation);
        textViewSplash.setAnimation(ani);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }).start();
    }
}