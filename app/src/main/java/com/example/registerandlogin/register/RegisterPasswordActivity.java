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
import com.example.registerandlogin.apiService.JsonPlaceHolderApi;
import com.example.registerandlogin.apiService.JsonPlaceHolderApiFactory;
import com.example.registerandlogin.apiService.registration.UserRegistration;
import com.example.registerandlogin.apiService.registration.UserRegistrationService;
import com.example.registerandlogin.login.LoginActivity;
import com.example.registerandlogin.objects.RegisterUser;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterPasswordActivity extends AppCompatActivity {
    UserRegistration registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);

        JsonPlaceHolderApi api = JsonPlaceHolderApiFactory.getApi();

        registerUser = (UserRegistration) getIntent().getSerializableExtra("UserRegistration");
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
            Log.d("wallet-app", registerUser.toString());
            UserRegistrationService.createUser(api, registerUser, this);
        });
    }

    public void onRegisterSuccess() {
        startActivity(new Intent(RegisterPasswordActivity.this , LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
    }

    public void onLoginFailed(String message) {
        TextView errorMessage = findViewById(R.id.errorMessage);
        errorMessage.setText(message);
    }
}