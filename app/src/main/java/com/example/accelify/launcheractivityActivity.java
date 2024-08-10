package com.example.accelify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.accelify.teachers.Login_teacher;
import com.example.accelify.teachers.teacherregister;

public class launcheractivityActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.launcher);

        Button teacher = findViewById(R.id.button);
        Button student = findViewById(R.id.button2);


        teacher.setOnClickListener(v ->
                startActivity(new Intent(launcheractivityActivity.this, Login_teacher.class))

                );

        student.setOnClickListener(v ->
                startActivity(new Intent(launcheractivityActivity.this, LoginActivity.class))

                );


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}