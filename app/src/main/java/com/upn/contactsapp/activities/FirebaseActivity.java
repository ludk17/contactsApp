package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


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
        btn.setOnClickListener(v -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contacts");

            Contact ct1 = new Contact("Juan","123454556");
            ct1.id=1;
            Contact c2 = new Contact("Pedro","1255534576");
            c2.id=2;

            myRef.child(String .valueOf(ct1.id)).setValue(ct1);
            myRef.child(String .valueOf(c2.id)).setValue(c2);
        });

    }
}