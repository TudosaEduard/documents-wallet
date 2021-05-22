package com.example.registerandlogin.document;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.registerandlogin.R;
import com.example.registerandlogin.login.LoginActivity;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button btnDone = findViewById(R.id.buttonDone);
        btnDone.setOnClickListener(v -> {
            startActivity(new Intent(AddActivity.this , ViewActivity.class));
            overridePendingTransition(R.anim.slide_in_left , R.anim.slide_out_right);
        });
    }
}