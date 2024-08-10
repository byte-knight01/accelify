package com.example.accelify.teachers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.accelify.DashboardActivity;
import com.example.accelify.LoginActivity;
import com.example.accelify.R;
import com.example.accelify.RegisterActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Login_teacher extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Get references to the UI elements
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        // Set up the login button click listener
        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Authenticate the user
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // If login is successful, go to MainActivity
                            startActivity(new Intent(Login_teacher.this, teachersdashboard.class));
                        } else {
                            // If login fails, show a toast message
                            Toast.makeText(Login_teacher.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        // Set up the register button click listener
        registerButton.setOnClickListener(v -> startActivity(new Intent(Login_teacher.this, teacherregister.class)));
    }
}


