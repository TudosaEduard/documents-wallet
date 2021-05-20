package com.example.registerandlogin.register;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import com.example.registerandlogin.R;
import com.example.registerandlogin.login.LoginActivity;

public class RegisterPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);
        TextView text = findViewById(R.id.clickLogin);
        text.setOnClickListener(v -> {
            startActivity(new Intent(RegisterPasswordActivity.this , LoginActivity.class));
            text.setPaintFlags(text.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            overridePendingTransition(R.anim.slide_in_left , R.anim.slide_out_right);
        });

        Button btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(RegisterPasswordActivity.this , RegisterUserActivity.class));
            overridePendingTransition(R.anim.slide_in_left , R.anim.slide_out_right);
        });

        Button btnRegister = findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(RegisterPasswordActivity.this , LoginActivity.class));
            overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
        });
    }
}