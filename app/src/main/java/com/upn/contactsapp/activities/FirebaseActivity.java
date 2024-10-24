package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

import java.util.UUID;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Button button = findViewById(R.id.buttonFirebase);

        button.setOnClickListener(v -> {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contacts");


            Contact c1 = new Contact("Luis","123456");
            c1.uuid = UUID.randomUUID().toString();
            Contact c2 = new Contact("Miguel","123456");
            c2.uuid = UUID.randomUUID().toString();;

            Contact c3 = new Contact("San","123456");
            c3.uuid = UUID.randomUUID().toString();;

            Contact c4 = new Contact("Henry","123450");
            c4.uuid = UUID.randomUUID().toString();;


            //myRef.child(String.valueOf(c1.uuid)).setValue(c1);
           // myRef.child(String.valueOf(c2.uuid)).setValue(c2);
            //myRef.child(String.valueOf(c3.uuid)).setValue(c3);

            myRef.child(String.valueOf(c4.uuid)).setValue(c4);

            Toast.makeText(FirebaseActivity.this, "Información enviada", Toast.LENGTH_SHORT).show();


        });
    }
}
