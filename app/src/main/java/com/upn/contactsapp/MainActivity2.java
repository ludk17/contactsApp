package com.upn.contactsapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.entities.Contact;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn = findViewById(R.id.buttondatabase);
        btn.setOnClickListener(view -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contact");

            Contact c1 = new Contact("Luis", "12345");
            c1.id = 1;
            Contact c2 = new Contact("Luis", "12345");
            c2.id = 2;

            myRef.child(String.valueOf(c1.id)).setValue(c1);
            myRef.child(String.valueOf(c2.id)).setValue(c2);


        });
    }


}