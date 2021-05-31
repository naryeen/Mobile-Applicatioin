package edu.bt.pythonquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SetsActivity extends AppCompatActivity {
     GridView sets_grid;
     private FirebaseFirestore firestore;
     private  int lesson_id;
     private Dialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

//        getSupportActionBar().setTitle("Lessons");
//        Toolbar toolbar = findViewById(R.id.sets_toolbar);
//        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("LESSON");
        lesson_id = getIntent().getIntExtra("LESSON_ID",1);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sets_grid =findViewById(R.id.sets_gridView);

        loadingDialog = new Dialog(SetsActivity.this);
        loadingDialog.setContentView(R.layout.loading_progressbar);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progresss_background);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();

        firestore = FirebaseFirestore.getInstance();
        loadSets();
        // this is for static only. adapter is created but only after getting data from server
//        SetsAdapter adapter = new SetsAdapter(6);
//        sets_grid.setAdapter(adapter);

    }
    public void loadSets(){
        firestore.collection("QUIZ").document("LESSON"+String.valueOf(lesson_id))
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    if (doc.exists()) {
                        //fetch the sets list here
                        //how many sets are there
                        long sets = (long) doc.get("SETS");

                        SetsAdapter adapter = new SetsAdapter((int) sets);
                        sets_grid.setAdapter(adapter);

                    } else {
                        //no no document on the server
                        Toast.makeText(SetsActivity.this, "No sets activity Document Exists", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(SetsActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
                loadingDialog.cancel();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            SetsActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}