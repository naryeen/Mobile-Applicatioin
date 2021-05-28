package edu.bt.todo23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".CUSTOM_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String intentAction = intent.getAction();

        if(intentAction !=null){

            String toastms = "";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastms = "power connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastms = "power disconnected";
                    break;
                case CUSTOM_BROADCAST:
                    toastms = "custom broadcast received ";
                    break;
            }
            Toast.makeText(context, toastms, Toast.LENGTH_SHORT).show();
        }

    }
}