package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.R;

public class activity_firebase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        Button btn = findViewById(R.id.btnCreateFirebase);
        btn.setOnClickListener(v ->{
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReferences("message");

            myRef.setValue("Hello, World!");
        });
    }
}