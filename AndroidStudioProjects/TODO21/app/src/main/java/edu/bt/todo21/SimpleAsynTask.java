package edu.bt.todo21;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsynTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> nTextView;

    public SimpleAsynTask(TextView tv){
        nTextView = new WeakReference<>(tv);

    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n =r.nextInt(12);
        int s = n*200;
        try{
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake after sleeping "+ s +"millisecond!";
    }

    @Override
    protected void onPostExecute(String s) {
        nTextView.get().setText(s);
    }
}
