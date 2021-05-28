package edu.bt.todo23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CustomReceiver nReceiver;
    private static final String CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".CUSTOM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nReceiver = new CustomReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);

        this.registerReceiver(nReceiver, filter);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(nReceiver,new IntentFilter(CUSTOM_BROADCAST));
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(nReceiver);
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(nReceiver);
        super.onDestroy();
    }

    public void sendCustomBroadcast(View view) {
        Intent  customBroadcastIntent = new Intent(CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}