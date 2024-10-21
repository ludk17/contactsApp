package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.view.View;
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
        Button btn = findViewById(R.id.btnCreateFirebase);
        btn.setOnClickListener(v ->{
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contacts");

            Contact c1 = new Contact("Juan","123456");
            c1.id=1;
            Contact c2 = new Contact("Carlos","123456");
            c2.id=2;
            Contact c3 = new Contact("Marcos","1234568");
            c3.id=3;

            myRef.child(String .valueOf(c1.id)).setValue(c1);
            myRef.child(String .valueOf(c2.id)).setValue(c2);
        });


    }
}