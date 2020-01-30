package com.example.mvvm2020.model;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm2020.data.ApiClient;
import com.example.mvvm2020.data.RetrofitModul;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @see : https://medium.com/@amtechnovation/android-architecture-component-mvvm-part-1-a2e7cff07a76
 */
public class SaveUserRepository {

    private MutableLiveData<UserResponse> userResponse = new MutableLiveData<>();

    public MutableLiveData<UserResponse> setData(String id, String password){

        ApiClient apiClient = RetrofitModul.getApiClient().create(ApiClient.class);
        Call<Usuario> usuarioCall = apiClient.saveUsuario(id,password);
        usuarioCall.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful() && response.body() != null){
                    if (response.body().getSuccess()){
                        userResponse.setValue(new UserResponse(response.body().getMessage(),null));
                    }else{
                        userResponse.setValue(new UserResponse(null,new Exception("Ocurrió error")));
                    }
                }else{
                    userResponse.setValue(new UserResponse(null,new Exception("Ocurrió error")));
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                userResponse.setValue(new UserResponse(null,new Exception(t)));
            }
        });
        return userResponse;
    }

    public void cancelTask(){
        //TODO implementar
    }

}
