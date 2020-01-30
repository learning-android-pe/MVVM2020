package com.example.mvvm2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_activity_guardar).setOnClickListener(v -> gotoSaveDataView());
    }

    private void gotoSaveDataView(){
        startActivity(new Intent(this, SaveDataActivity.class));
    }

}
