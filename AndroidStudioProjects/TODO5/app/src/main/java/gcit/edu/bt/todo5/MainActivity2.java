package gcit.edu.bt.todo5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    // Unique tag for the intent reply.
    public static final String EXTRA_REPLY =
            "gcit.edu.bt.todo5.extra.REPLY";
    // EditText for the reply.
    private EditText mReply;

    String activity2 = "activity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Initialize view variables.
        mReply = findViewById(R.id.editText_second);

        // Get the intent that launched this activity, and the message in
        // the intent extra.
        Intent intent = getIntent();
        String message = intent.getStringExtra(gcit.edu.bt.todo5.MainActivity.EXTRA_MESSAGE);

        // Put that message into the text_message TextView
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

    }
    public void returnReply(View view) {
        // Get the reply message from the edit text.
        String reply = mReply.getText().toString();

        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(activity2, "oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(activity2, "onstart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(activity2, "onresume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(activity2, "onpause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(activity2, "onstop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(activity2, "ondestroy");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(activity2, "onrestart");

    }

}



