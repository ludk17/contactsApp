package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.IssueComment;
import com.upn.contactsapp.services.IssueService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearComentarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_comentario);

        // cuando haga clic

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jiraupn.atlassian.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IssueService issueService = retrofit.create(IssueService.class);


        Button btn = findViewById(R.id.btnComentar);
        EditText edIssueKey = findViewById(R.id.edIssueKey);
        EditText edComentario = findViewById(R.id.edComentario);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String issueKey = edIssueKey.getText().toString();
                String comentario = edComentario.getText().toString();

                IssueComment issueComment = new IssueComment();
                issueComment.body = comentario;

                issueService.comentar(issueKey, issueComment).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Se agrego el comentario", Toast.LENGTH_LONG).show();
                        } else {
                            String error = response.message();
                            Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable throwable) {

                    }
                });

            }
        });

    }
}