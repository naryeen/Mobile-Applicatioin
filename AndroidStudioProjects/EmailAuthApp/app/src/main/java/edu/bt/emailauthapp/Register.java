  package edu.bt.emailauthapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText editTextTextPersonName;
    EditText editTextTextEmailAddress;
    EditText registerPassword;
    EditText confirm_Password;
    Button btnRegister;
    Button btnloginfromregis;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        registerPassword = findViewById(R.id.registerpassword);
        confirm_Password = findViewById(R.id.confirm_Password);
        btnRegister = findViewById(R.id.btnregister);
        btnloginfromregis = findViewById(R.id.btnloginfromregis);

        fAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Extact the data from the form.....
                String fullName = editTextTextPersonName.getText().toString();
                String email = editTextTextEmailAddress.getText().toString();
                String password = registerPassword.getText().toString();
                String confirmPassword = confirm_Password.getText().toString();

                if(fullName.isEmpty()){
                    editTextTextPersonName.setError("Full Name is required");
                    return;
                }
                if(email.isEmpty()){
                    editTextTextEmailAddress.setError("Email is required");
                    return;
                }
                if(password.isEmpty()){
                    registerPassword.setError("Password field cannot be empty");
                    return;
                }
                if(confirmPassword.isEmpty()){
                    confirm_Password.setError("Confirm Password field cannot be empty");
                    return;
                }
                if(!password.equals(confirmPassword)){
                    registerPassword.setError("Password does not match,Type again!");
                    return;
                }
                //data is validated by then
                Toast.makeText(Register.this, "data is validated", Toast.LENGTH_SHORT).show();


                fAuth.createUserWithEmailAndPassword(email,password).addSu;

            }
        });


    }
}