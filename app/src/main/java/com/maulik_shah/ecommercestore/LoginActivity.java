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

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    private FirebaseAuth auth;

    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        sharedPreferences = getSharedPreferences("Dashboard", MODE_PRIVATE);
        boolean isFirstTime = sharedPreferences.getBoolean("FirstTime", true);

//        if(isFirstTime) {
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putBoolean("FirstTime", false);
//            editor.commit();
//
//            Intent intent = new Intent(LoginActivity.this, RecyclerViewActivity.class);
//            startActivity(intent);
//            finish();
//        }

//        if(auth.getCurrentUser() != null) {
//            startActivity(new Intent(LoginActivity.this, RecyclerViewActivity.class));
//            finish();
//        }
    }

    public void signup(View view) {
        startActivity(new Intent(LoginActivity.this, SignupActivity.class));
    }

    public void login(View view) {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if(TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this,"Enter Email", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this,"Enter Password", Toast.LENGTH_SHORT).show();
        }

        if(userPassword.length() < 8 ) {
            Toast.makeText(this,"Password is too Short, min 8 Characters", Toast.LENGTH_SHORT).show();
        }

        auth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,RecyclerViewActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Error" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}