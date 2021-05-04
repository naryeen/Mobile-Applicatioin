package edu.bt.emailauthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btn_logout,btn_verifyEmail;
    TextView verifyMEssage, reset_password;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_logout = findViewById(R.id.btn_logout);
        verifyMEssage = findViewById(R.id.verifyMEssage);
        btn_verifyEmail = findViewById(R.id.btn_verifyEmail);
        reset_password = findViewById(R.id.reset_password);

        auth = FirebaseAuth.getInstance();
        if(!auth.getCurrentUser().isEmailVerified()){
            btn_verifyEmail.setVisibility(View.VISIBLE);
            verifyMEssage.setVisibility(View.VISIBLE);
        }
        btn_verifyEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Verification Email sent.", Toast.LENGTH_SHORT).show();
                        btn_verifyEmail.setVisibility(View.GONE);
                        btn_verifyEmail.setVisibility(View.GONE);
                    }
                });
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.reset_password){
            startActivity(new Intent(getApplicationContext(),ResetPassword.class));
        }
        return super.onOptionsItemSelected(item);
    }
}