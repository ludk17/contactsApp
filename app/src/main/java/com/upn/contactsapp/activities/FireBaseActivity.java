package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

public class FireBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_firebase);

        Button boton = findViewById(R.id.btnFirebase);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("contact");
        Contact contacto = new Contact("contacto","123456789");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef. child("1").setValue(contacto);

            }
        });
    }
}