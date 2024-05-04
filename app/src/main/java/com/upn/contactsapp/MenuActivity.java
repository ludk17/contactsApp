package com.upn.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnPerfil = findViewById(R.id.btnProfile);
        btnPerfil.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}