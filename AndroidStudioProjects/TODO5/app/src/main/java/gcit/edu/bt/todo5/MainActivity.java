package gcit.edu.bt.todo5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {
    // Class name for Log tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE
            = "gcit.edu.bt.todo5.extra.MESSAGE";
    // Unique tag for the intent reply
    public static final int TEXT_REQUEST = 1;
    String activity = "activity1";

    // EditText view for the message
    private EditText mMessageEditText;
    // TextView for the reply header
    private TextView mReplyHeadTextView;
    // TextView for the reply body
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        if(savedInstanceState!=null){
            if(savedInstanceState.getBoolean("bundle1")){
                mReplyHeadTextView.setVisibility(View.VISIBLE);

                // Set the reply and make it visible.
                mReplyTextView.setText(savedInstanceState.getString("bundle2"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity2.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Test for the right intent reply.
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);

                // Make the reply head visible.
                mReplyHeadTextView.setVisibility(View.VISIBLE);

                // Set the reply and make it visible.
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(activity, "oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(activity, "onstart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(activity, "onresume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(activity, "onpause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(activity, "onstop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(activity, "ondestroy");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(activity, "onrestart");

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle bundle){
        super.onSaveInstanceState(bundle);
        if(mReplyHeadTextView.getVisibility()==View.VISIBLE){
            bundle.putBoolean("bundle1",true);
            bundle.putString("bundle2",mReplyTextView.getText().toString());
        }
    }

}