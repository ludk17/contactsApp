package com.upn.contactsapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.upn.contactsapp.entities.Contact;
import com.upn.contactsapp.services.IContactService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ContactFormActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 1001;
    private Button btnTakePhoto;
    private Button btnSelectPhoto;

    private ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);


        Button btnGuardar = findViewById(R.id.btnGuardar);
        btnTakePhoto = findViewById(R.id.btnTakePhoto);
        ivPhoto = findViewById(R.id.ivPhoto);
        btnSelectPhoto = findViewById(R.id.btnSelectPhoto);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtLastName = findViewById(R.id.edtLastName);
        EditText edtPhoneNumber = findViewById(R.id.edtPhoneNumber);

        setUpTakePhoto();
        setUpSelectPhoto();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://661d24b4e7b95ad7fa6c43d1.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Instanciar IContactService
        IContactService service = retrofit.create(IContactService.class);
        btnGuardar.setOnClickListener(view -> {

            Contact contact = new Contact();
            contact.name = edtName.getText().toString();
            contact.lastName = edtLastName.getText().toString();
            contact.phoneNumber = edtPhoneNumber.getText().toString();

            service.create(contact).enqueue(new Callback<Contact>() {
                @Override
                public void onResponse(Call<Contact> call, Response<Contact> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(ContactFormActivity.this, "Se creo contacto correctamente", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<Contact> call, Throwable throwable) {

                }
            });
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST_CODE) {
            // capturar la foto y mostrarla en el ImageView
            Bitmap bm = (Bitmap) data.getExtras().get("data");
            ivPhoto.setImageBitmap(bm);
        }
    }

    private void setUpTakePhoto() {
        btnTakePhoto.setOnClickListener(view -> {
            // preguntar por el permiso de camara
            if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                takePhoto();
            } else {
                requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 100);
            }

        });
    }

    private void setUpSelectPhoto() {
        btnSelectPhoto.setOnClickListener(view -> {

            // if sdk < 33
            if (android.os.Build.VERSION.SDK_INT <= 32 ) {
                if(checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectPhoto();
                }
                else {
                    requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
                }
            }
            else {
                selectPhoto();
            }

            // preguntar por el permiso de almacenamiento


        });

    }

    private void takePhoto() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    private void selectPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 102);
    }



}