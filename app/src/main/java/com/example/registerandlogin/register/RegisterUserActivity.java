package com.example.registerandlogin.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.registerandlogin.R;
import com.example.registerandlogin.apiService.registration.UserRegistration;
import com.example.registerandlogin.login.LoginActivity;
import com.example.registerandlogin.objects.RegisterUser;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterUserActivity extends AppCompatActivity {
    UserRegistration registerUser;

    private TextInputLayout firstName;
    private TextInputLayout lastName;
    private TextInputLayout email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        TextView text = findViewById(R.id.clickLogin);
        text.setOnClickListener(v -> {
            startActivity(new Intent(RegisterUserActivity.this , LoginActivity.class));
            text.setPaintFlags(text.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            overridePendingTransition(R.anim.slide_in_left , R.anim.slide_out_right);
        });

        Button btnNext = findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(v -> {
            firstName = (TextInputLayout) findViewById(R.id.firstName);
            lastName = (TextInputLayout) findViewById(R.id.lastName);
            email = (TextInputLayout) findViewById(R.id.emailRegister);

            if(validateFirstName() && validateLastName() && validateEmail()){
                registerUser = new UserRegistration(firstName.getEditText().getText().toString() ,
                        lastName.getEditText().getText().toString(),
                        email.getEditText().getText().toString());

                Intent intent = new Intent(RegisterUserActivity.this , RegisterPasswordActivity.class);
                intent.putExtra("UserRegistration" , registerUser);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
            }
        });
    }

    private boolean validateFirstName(){
        String firstInput = firstName.getEditText().getText().toString();
        if(firstInput.isEmpty()){
            firstName.setError("Field can't be empty");
            return false;
        } else if(firstInput.length() > 15){
            firstName.setError("First name too long");
            return false;
        } else {
            firstName.setError(null);
            return true;
        }
    }

    private boolean validateLastName(){
        String lastInput = lastName.getEditText().getText().toString();
        if(lastInput.isEmpty()){
            lastName.setError("Field can't be empty");
            return false;
        } else if(lastInput.length() > 15){
            lastName.setError("First name too long");
            return false;
        } else {
            lastName.setError(null);
            return true;
        }
    }

    private boolean validateEmail(){
        String emailInput = email.getEditText().getText().toString();
        if(emailInput.isEmpty()){
            email.setError("Field can't be empty");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

}