package com.example.mvvm2020.save_mvvm;

import com.example.mvvm2020.save_mvvm.object.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiClient {

    @FormUrlEncoded
    @POST("retrofit_save_mvvm.php")
    Call<Usuario> saveUsuario(
            @Field("id") String id,
            @Field("password") String password
    );
}
