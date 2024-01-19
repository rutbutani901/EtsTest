package com.example.etstest.apiCalling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiInterface apiInterface;

    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .build();

    public static synchronized ApiInterface getApiInterface() {
        if (apiInterface == null) {
            apiInterface = new Retrofit
                    .Builder()
                    .baseUrl("https://app-interview.easyglue.in/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(ApiInterface.class);
        }
        return apiInterface;
    }
}
