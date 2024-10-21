package com.upn.contactsapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.entities.Contact;

public class ActivityFirebase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        // Encontrar el botón en el layout
        Button btn = findViewById(R.id.btnCreateOnFirebase);

        // Configurar el listener para el clic del botón
        btn.setOnClickListener(v -> {
            // Obtener una instancia de FirebaseDatabase
            FirebaseDatabase database = FirebaseDatabase.getInstance();

            // Crear una referencia a un nodo en la base de datos llamado "contacts"
            DatabaseReference myRef = database.getReference("contacts");

            // Crear dos objetos de tipo Contact
            Contact c1 = new Contact("Luis", "12345678");
            c1.setId(1); // Asignar ID al contacto
            Contact c2 = new Contact("Miguel", "123456");
            c2.setId(2); // Asignar ID al contacto

            // Guardar los contactos en Firebase usando su ID como clave
            myRef.child(String.valueOf(c1.getId())).setValue(c1)
                    .addOnSuccessListener(aVoid -> {
                        Log.d("Firebase", "Contacto c1 guardado exitosamente");
                    })
                    .addOnFailureListener(e -> {
                        Log.e("Firebase", "Error al guardar contacto c1", e);
                    });

            myRef.child(String.valueOf(c2.getId())).setValue(c2)
                    .addOnSuccessListener(aVoid -> {
                        Log.d("Firebase", "Contacto c2 guardado exitosamente");
                    })
                    .addOnFailureListener(e -> {
                        Log.e("Firebase", "Error al guardar contacto c2", e);
                    });
        });
    }
}
