package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

public class FirabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faribase_activitt);
        Button btn =findViewById(R.id.btnCreateOnFirebase);
        btn.setOnClickListener(v -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef =database.getReference("contacts");
            Contact c1 = new Contact("Miguel","145556");
            c1.id=1;
            Contact c2 = new Contact("Juan","245556");
            c2.id=2;
            myRef.setValue("Hola Mundo!");
            myRef.child(String .valueOf(c1.id)).setValue(c1);
            myRef.child(String .valueOf(c2.id)).setValue(c2);
        });

    }
}