package com.example.registerandlogin.apiService.login;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.util.Log;

import com.example.registerandlogin.R;
import com.example.registerandlogin.apiService.JsonPlaceHolderApi;
import com.example.registerandlogin.apiService.userCredentials.Credentials;
import com.example.registerandlogin.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginService {

    public static void loginUser(JsonPlaceHolderApi jsonPlaceHolderApi, UserLogin userLogin, final LoginActivity activity) {
        Call<UserLoginResponse> call = jsonPlaceHolderApi.loginUser(userLogin);
        call.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                if(!response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        Log.d("wallet-app", "Code: " + jsonObject.getString("message"));
                        activity.onLoginFailed(jsonObject.getString("message"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                UserLoginResponse user = response.body();
                Credentials.setFirstName(user.getFirstName());
                Credentials.setUserId(user.getId());
                activity.onLoginSuccess();
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                activity.onLoginFailed("Unexpected error");
            }
        });
    }
}
