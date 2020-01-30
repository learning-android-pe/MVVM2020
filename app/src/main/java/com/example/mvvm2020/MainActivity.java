package com.example.mvvm2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvvm2020.save_mvvm.SaveDataActivity;

public class MainActivity extends AppCompatActivity {

    Button grabarActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grabarActivity = findViewById(R.id.btn_activity_guardar);


        grabarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SaveDataActivity.class);
                startActivity(i);
            }
        });
    }

}
