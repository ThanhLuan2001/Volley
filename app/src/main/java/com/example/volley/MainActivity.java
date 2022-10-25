package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.volley.Bai1.MainActivity1;
import com.example.volley.Bai2.MainActivity2;
import com.example.volley.Bai3.MainActivity3;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btnBai1);
        btn2 = findViewById(R.id.btnBai2);
        btn3 = findViewById(R.id.btnBai3);

        btn1.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MainActivity1.class));
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        btn3.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MainActivity3.class));
        });
    }
}