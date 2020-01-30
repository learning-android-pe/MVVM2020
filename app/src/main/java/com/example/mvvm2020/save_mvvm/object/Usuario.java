package com.example.mvvm2020.save_mvvm.object;

import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("id")
    public String id;

    @SerializedName("password")
    public String pass;

    @SerializedName("success")
    public Boolean success;

    @SerializedName("message")
    public String message;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
