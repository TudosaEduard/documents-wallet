package com.example.registerandlogin.apiService.registration;

import android.util.Log;

import com.example.registerandlogin.apiService.JsonPlaceHolderApi;
import com.example.registerandlogin.register.RegisterPasswordActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegistrationService {

    public static void createUser(JsonPlaceHolderApi jsonPlaceHolderApi,
                                  UserRegistration userRegistration,
                                  final RegisterPasswordActivity activity) {
        Call<ResponseBody> call = jsonPlaceHolderApi.registerUser(userRegistration);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
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

                activity.onRegisterSuccess();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("wallet-app", t.getMessage());
                activity.onLoginFailed("unexpected error");
            }
        });
    }
}
