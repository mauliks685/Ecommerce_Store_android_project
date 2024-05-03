package com.maulik_shah.ecommercestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    EditText userName, userEmail, userPassword;
    private FirebaseAuth auth;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.editTextUsername);
        userEmail = findViewById(R.id.editTextEmail);
        userPassword = findViewById(R.id.editTextPassword);
    }

    public void login(View view) {
        startActivity(new Intent(SignupActivity.this, LoginActivity.class));
    }

    public void signup(View view) {
        String name = userName.getText().toString();
        String email = userEmail.getText().toString();
        String password  = userPassword.getText().toString();

        if(TextUtils.isEmpty(name)) {
            Toast.makeText(this,"Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)) {
            Toast.makeText(this,"Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.length() < 8 ) {
            Toast.makeText(this,"Password must have atleast 8 chars.",Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this,"Registration Completed Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(SignupActivity.this,"Registration Failed! Try Again"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}