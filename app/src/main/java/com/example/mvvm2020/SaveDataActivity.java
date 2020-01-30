package com.example.mvvm2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvm2020.viewmodel.UserViewModel;

public class SaveDataActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button grabar;
    private UserViewModel userViewModel;

    String username = "";
    String password = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        //viemodel
        userViewModel = ViewModelProviders.of(SaveDataActivity.this).get(UserViewModel.class);
        ui();

    }

    private Boolean validateForm(){
        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        if(username.isEmpty()){
            return false;
        }

        if(password.isEmpty()){
            return false;
        }
        return true;
    }

    private void showMessage(String message){
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }

    private void saveData(){
        userViewModel.saveData(username,password).observe(this , data ->{
            if(data!=null){
                if(data.getData()!=null){
                    showMessage(data.getData());
                }else{
                    showMessage(data.getError().toString());
                }
            }
        });
    }

    private void ui(){
        editTextUsername = findViewById(R.id.txt_username);
        editTextPassword = findViewById(R.id.txt_pwd);
        grabar = findViewById(R.id.btn_grabar);

        //events
        grabar.setOnClickListener(v -> {
            if(validateForm()){
                saveData();
            }else{
                showMessage("Validar campos");
            }
        });
    }
}
