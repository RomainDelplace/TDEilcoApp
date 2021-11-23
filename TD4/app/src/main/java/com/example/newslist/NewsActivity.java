package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        setTitle(getLocalClassName());

        TextView texte = (TextView) findViewById(R.id.text2);

        Intent intent = getIntent();
        String login;
        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
            texte.setText(login);
        }
    }

    public void GotoDetailsActivity(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    public void GotoLoginActivity(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //TODO
        finish();
    }

    public void GotoLibelle(View view) {
        String url = "https://news.google.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}