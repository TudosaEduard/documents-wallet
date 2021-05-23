package com.example.registerandlogin.apiService.wallet;

import android.util.Log;

import com.example.registerandlogin.apiService.JsonPlaceHolderApi;
import com.example.registerandlogin.document.AddActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DocumentUploadService {
    public static void uploadDocument(JsonPlaceHolderApi jsonPlaceHolderApi,
                                DocumentUpload document,
                                final AddActivity activity) {

        Call<ResponseBody> call = jsonPlaceHolderApi.uploadFile(
                document.getFile(),
                document.getOwnerid(),
                document.getUserFileName());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(!response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        Log.d("WalletApp", "Code: " + jsonObject.getString("message"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                activity.onUploadSuccess();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
