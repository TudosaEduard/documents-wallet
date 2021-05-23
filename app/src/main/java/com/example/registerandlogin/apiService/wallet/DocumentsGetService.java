package com.example.registerandlogin.apiService.wallet;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.registerandlogin.apiService.JsonPlaceHolderApi;
import com.example.registerandlogin.document.ViewActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DocumentsGetService {
    public static void getDocuments(JsonPlaceHolderApi jsonPlaceHolderApi, Long ownerId, final ViewActivity activity) {
        Call<List<Document>> call = jsonPlaceHolderApi.getDocuments(ownerId);
        call.enqueue(new Callback<List<Document>>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<List<Document>> call, Response<List<Document>> response) {
                if (!response.isSuccessful()) {
                    Log.d("WalletApp", "Err Code: " + response.code());
                    return;
                }

                List<Document> results = response.body();
                /*imageView = findViewById(R.id.imageView);
                byte[] rawImage = results.get(0).decodeFile();
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(rawImage, 0, rawImage.length));*/
                activity.onGetUploadsSuccess(results);
            }

            @Override
            public void onFailure(Call<List<Document>> call, Throwable t) {
                Log.d("WalletApp", t.getMessage());
            }
        });
    }
}
