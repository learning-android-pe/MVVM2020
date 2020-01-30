package com.example.mvvm2020.save_mvvm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModul {

    public static final String BASE_URL = "https://xxxxxxxxxx.000webhostapp.com/faucet/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }

}
