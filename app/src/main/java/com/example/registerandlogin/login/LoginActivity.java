package com.example.registerandlogin.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.registerandlogin.R;
import com.example.registerandlogin.apiService.JsonPlaceHolderApi;
import com.example.registerandlogin.apiService.JsonPlaceHolderApiFactory;
import com.example.registerandlogin.apiService.login.UserLogin;
import com.example.registerandlogin.apiService.login.UserLoginService;
import com.example.registerandlogin.document.ViewActivity;
import com.example.registerandlogin.objects.LoginUser;
import com.example.registerandlogin.objects.RecyclerViewList;
import com.example.registerandlogin.register.RegisterUserActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private RecyclerViewList recyclerViewList;
    private UserLogin userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        JsonPlaceHolderApi api = JsonPlaceHolderApiFactory.getApi();

        TextView text = findViewById(R.id.clickSingup);
        text.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this , RegisterUserActivity.class));
            text.setPaintFlags(text.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
        });
        Button btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(v -> {

            TextInputLayout email= (TextInputLayout) findViewById(R.id.emailLogin);
            TextInputLayout password = (TextInputLayout) findViewById(R.id.passwordLogin);

            userLogin = new UserLogin(email.getEditText().getText().toString() ,
                                                password.getEditText().getText().toString());

            UserLoginService.loginUser(api, userLogin, this);
        });
    }

    public void onLoginSuccess() {
        Intent intent = new Intent(LoginActivity.this , ViewActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
    }

    public void onLoginFailed(String message) {
        TextView errorMessage = findViewById(R.id.errorMessage);
        errorMessage.setText(message);
    }
}