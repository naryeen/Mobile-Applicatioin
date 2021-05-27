package edu.bt.todo22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ntitleText, nauthorText;
    private EditText nBookInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ntitleText = (TextView) findViewById(R.id.titleText);
        nauthorText = (TextView) findViewById(R.id.authorText);
        nBookInput = (EditText) findViewById(R.id.bookInput);

    }

    public void search(View v) {
        String queryString = nBookInput.getText().toString();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(v.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            new FetchBook(ntitleText, nauthorText).execute(queryString);
            nauthorText.setText("");
            ntitleText.setText(R.string.loading);
        } else {
            if (queryString.length() == 0) {
                nauthorText.setText("");
                ntitleText.setText(R.string.noSearch_term);
            } else {
                nauthorText.setText("");
                ntitleText.setText(R.string.network);
            }
        }
    }


}