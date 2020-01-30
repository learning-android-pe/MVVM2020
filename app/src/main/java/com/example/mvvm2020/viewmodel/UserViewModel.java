package com.example.mvvm2020.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm2020.di.Injector;
import com.example.mvvm2020.model.SaveUserRepository;
import com.example.mvvm2020.model.UserResponse;

/**
 * @see : https://developer.android.com/topic/libraries/architecture/viewmodel#java
 */
public class UserViewModel extends ViewModel {
    private SaveUserRepository saveUsuarioUseCase = Injector.getInstance().provideRepository();

    public LiveData<UserResponse> saveData(String username, String password){
        return saveUsuarioUseCase.setData(username,password);
    }

}
