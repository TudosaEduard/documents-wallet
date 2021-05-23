package com.example.registerandlogin.register;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import com.example.registerandlogin.R;
import com.example.registerandlogin.login.LoginActivity;
import com.example.registerandlogin.objects.RegisterUser;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterPasswordActivity extends AppCompatActivity {
    RegisterUser registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);
        registerUser = (RegisterUser) getIntent().getSerializableExtra("RegisterObject");
        Log.d("wallet-app" , registerUser.toString());
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
            TextInputLayout password = (TextInputLayout) findViewById(R.id.passwordRegister);
            registerUser.setPassword(password.getEditText().getText().toString());

            startActivity(new Intent(RegisterPasswordActivity.this , LoginActivity.class));
            overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
        });
    }
}