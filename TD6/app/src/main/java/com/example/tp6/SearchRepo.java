package com.example.tp6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SearchRepo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_repo);
        setTitle(getLocalClassName());

    }

    public void Rechercher(View view) {
        EditText Trecherche = (EditText) findViewById(R.id.text1);
        String Srecherche = String.valueOf( Trecherche.getText());
        Intent intent = new Intent(this, ListRepo.class);
        Intent recherche = intent.putExtra("recherche", Srecherche );
        startActivity(intent);
        this.finish();
    }



}
