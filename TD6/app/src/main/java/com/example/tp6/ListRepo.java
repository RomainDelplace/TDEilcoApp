package com.example.tp6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListRepo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_repo);
        setTitle(getLocalClassName());

        TextView texte = (TextView) findViewById(R.id.text1);

        Intent intent = getIntent();
        String recherche;
        if (intent.hasExtra("recherche")) {
            recherche = intent.getStringExtra("recherche");
            texte.setText(recherche);

        }
    }
}