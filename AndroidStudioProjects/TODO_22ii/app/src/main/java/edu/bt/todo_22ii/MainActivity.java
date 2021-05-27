package edu.bt.todo_22ii;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private TextView ntitleText, nauthorText;
    private EditText nBookInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ntitleText = (TextView) findViewById(R.id.titleText);
        nauthorText = (TextView) findViewById(R.id.authorText);
        nBookInput = (EditText) findViewById(R.id.bookInput);

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }

    }

    public void search(View v) {
        String queryString = nBookInput.getText().toString();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(v.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        // Check the status of the network connection.
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        // If the network is available, connected, and the search field
        // is not empty, start a BookLoader AsyncTask.
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {

            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            nauthorText.setText("");
            ntitleText.setText(R.string.loading);
        }
        else {
            if (queryString.length() == 0) {
                nauthorText.setText("No Such Term");

            } else {
                nauthorText.setText("No NetWork");

            }
        }
    }


    @NonNull
    @NotNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable @org.jetbrains.annotations.Nullable Bundle args) {
        String queryString = "";

        if (args != null) {
            queryString = args.getString("queryString");
        }

        return new BookLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull @NotNull Loader<String> loader, String data) {
        try {
            // Convert the response into a JSON object.
            JSONObject jsonObject = new JSONObject(data);
            // Get the JSONArray of book items.
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            // Initialize iterator and results fields.
            int i = 0;
            String title = null;
            String authors = null;

            // Look for results in the items array, exiting when both the
            // title and author are found or when all items have been checked.
            while (i < itemsArray.length() &&
                    (authors == null && title == null)) {
                // Get the current item information.
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                // Try to get the author and title from the current item,
                // catch if either field is empty and move on.
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Move to the next item.
                i++;
            }

            // If both are found, display the result.
            if (title != null && authors != null) {
                ntitleText.setText(title);
                nauthorText.setText(authors);
                //mBookInput.setText("");
            } else {
                // If none are found, update the UI to show failed results.
                ntitleText.setText("No Result Found");
            }

        } catch (Exception e) {
            // If onPostExecute does not receive a proper JSON string,
            // update the UI to show failed results.
            ntitleText.setText("No Result Found!");

            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull @NotNull Loader<String> loader) {
//
    }
}