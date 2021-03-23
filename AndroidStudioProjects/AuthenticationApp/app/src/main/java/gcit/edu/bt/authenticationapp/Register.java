package gcit.edu.bt.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText nUserName, nEmail,nPassword,nConfirmPassword;
    Button  nRegistrationBtn;
    TextView  nLoginbtn;
    FirebaseAuth fAuth;
    ProgressBar nProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nUserName=findViewById(R.id.nfullname);
        nEmail=findViewById(R.id.nemail);
        nPassword = findViewById(R.id.npasswd);
        nConfirmPassword = findViewById(R.id.nconpasswd);
        nRegistrationBtn = findViewById(R.id.nRegBtn);
        nLoginbtn = findViewById(R.id.nLoginr);
        fAuth = FirebaseAuth.getInstance();
        ProgressBar = findViewById(R.id.proBar);

    }
}