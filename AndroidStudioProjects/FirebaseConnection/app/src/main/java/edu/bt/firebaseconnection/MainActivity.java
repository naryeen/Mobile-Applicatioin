package edu.bt.firebaseconnection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private EditText editTextTitle ;
    private EditText editTextDescription;
    private TextView textViewData;
    private FirebaseFirestore db =  FirebaseFirestore.getInstance();
    private DocumentReference noteRef = db.document("Notebook/My First Note");
    private Object notebookRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        textViewData = findViewById(R.id.text_view_data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        noteRef.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(error != null){
                    Toast.makeText(MainActivity.this, "Error While Loading", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, error.toString());
                    return;
                }
                if(documentSnapshot.exists()){
                    Note note = documentSnapshot.toObject(Note.class);
                    String title = note.getTitle();
                    String description = note.getDescription();
                    textViewData.setText("Title: "+ title + " \n "+"Description:" +description  );
                }else{
                    textViewData.setText("");
                }
            }
        });
    }

    public void addNote(View v) {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();

//        Map<String, Object> note = new HashMap<>();
//        note.put(KEY_TITLE,title);
//        note.put(KEY_DESCRIPTION,description);
        Note note  = new Note(title,description);



//        notebookRef.add(note);
    }
//    public void loadNotes(View v) {
//        notebookRef.get()
//                .addOnSucc
//    }


}