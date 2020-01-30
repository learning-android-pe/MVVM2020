package com.example.mvvm2020.di;

import com.example.mvvm2020.model.SaveUserRepository;

public class Injector {

    private static Injector injector;
    private SaveUserRepository saveUserRepository = new SaveUserRepository();

    public static Injector getInstance(){
        if (injector == null){
            injector = new Injector();
        }
        return injector;
    }


    public SaveUserRepository provideRepository(){
        return saveUserRepository;
    }

}
