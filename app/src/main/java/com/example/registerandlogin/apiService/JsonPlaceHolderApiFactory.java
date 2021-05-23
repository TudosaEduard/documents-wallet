package com.example.registerandlogin.apiService;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonPlaceHolderApiFactory {

    private static JsonPlaceHolderApi jsonPlaceHolderApi = null;

    private final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.122:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private JsonPlaceHolderApiFactory(){}

    public static JsonPlaceHolderApi getApi() {
        if (jsonPlaceHolderApi == null) {
            jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        }
        return jsonPlaceHolderApi;
    }
}
