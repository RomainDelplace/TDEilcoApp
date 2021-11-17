package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = (Button) findViewById(R.id.button); // récupération id boutton
        rollButton.setOnClickListener(new View.OnClickListener() { // Si on appuie sur le boutton
            @Override
            public void onClick(View view) {
                EditText Edit = findViewById(R.id.EditText); // récupération id de l'Edit Text
                String nombre=Edit.getText().toString(); // récuréation de la valeur entrée par l'utilisateur
                boolean verifier = TextUtils.isDigitsOnly(nombre); // vérification si la valeur est bien un chiffre/nombre
                if (verifier && !nombre.isEmpty()) { //Si la valeur est correct
                    int resultat = Integer.parseInt(nombre); // On transforme la valeur récupéré en int
                    int rand = (int) (Math.random() * (resultat - 0)) + 1; // On crée un nombre aléatoire qui renvoi un nombre entre 1 et le chiffre entré
                    TextView Text = findViewById(R.id.textView); // On va cherche l'id du textview
                    Text.setText(String.valueOf(rand));// On écrit a l'emplacement du text du textView la valeur aléatoire créait précédement
                    rand = (int) (Math.random() * (resultat - 0)) + 1;
                    TextView Text2 = findViewById(R.id.textView3); // On va cherche l'id du textview
                    Text2.setText(String.valueOf(rand));
                }
                else{ // Si la valeur ne correspond pas on fait un toast pour prévenir l'utilisateur
                    Toast toast = Toast.makeText(MainActivity.this, "Valeur incorrect ou inexistant", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}