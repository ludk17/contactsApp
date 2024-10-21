package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);


        Button btn = findViewById(R.id.btnCreateOnFirebase);

        btn.setOnClickListener(view -> {// Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contact");

            Contact c1 = new Contact("Luis", "123456789");
            c1.id=1;
            Contact c2 = new Contact("Kike", "987654321");
            c2.id=2;
            Contact c3 = new Contact("Kike", "987654321");
            c3.id=3;
            Contact c4 = new Contact("Marta", "321654987");
            c4.id = 4;
            Contact c5 = new Contact("Juan", "789123456");
            c5.id = 5;
            Contact c6 = new Contact("Sara", "654321789");
            c6.id = 6;
            Contact c7 = new Contact("Carlos", "987123456");
            c7.id = 7;
            Contact c8 = new Contact("Laura", "321987654");
            c8.id = 8;
            Contact c9 = new Contact("Pedro", "159753486");
            c9.id = 9;
            Contact c10 = new Contact("Javier", "753159486");
            c10.id = 10;


            myRef.child(String.valueOf(c1.id)).setValue(c1);
            myRef.child(String.valueOf(c2.id)).setValue(c2);
            myRef.child(String.valueOf(c3.id)).setValue(c3);
            myRef.child(String.valueOf(c4.id)).setValue(c4);
            myRef.child(String.valueOf(c5.id)).setValue(c5);
            myRef.child(String.valueOf(c6.id)).setValue(c6);
            myRef.child(String.valueOf(c7.id)).setValue(c7);
            myRef.child(String.valueOf(c8.id)).setValue(c8);
            myRef.child(String.valueOf(c9.id)).setValue(c9);
            myRef.child(String.valueOf(c10.id)).setValue(c10);


        });

    }
}