package com.example.registerandlogin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.registerandlogin.R;
import com.example.registerandlogin.register.RegisterUserActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView text = findViewById(R.id.clickSingup);
        text.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this , RegisterUserActivity.class));
            text.setPaintFlags(text.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
        });
    }
}