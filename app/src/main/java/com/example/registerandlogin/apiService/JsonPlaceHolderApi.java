package com.example.registerandlogin.apiService;

import com.example.registerandlogin.apiService.login.UserLogin;
import com.example.registerandlogin.apiService.login.UserLoginResponse;
import com.example.registerandlogin.apiService.registration.UserRegistration;
import com.example.registerandlogin.apiService.wallet.Document;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @POST("registration")
    Call<ResponseBody> registerUser(@Body UserRegistration userRegistration);

    @POST("auth")
    Call<UserLoginResponse> loginUser(@Body UserLogin userLogin);

    @Multipart
    @POST("wallet")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part file,
                                  @Query("ownerid") Long ownerid,
                                  @Query("userFileName") String userFileName);

    @GET("wallet/{id}")
    Call<List<Document>> getDocuments(@Path("id") Long id);
}
