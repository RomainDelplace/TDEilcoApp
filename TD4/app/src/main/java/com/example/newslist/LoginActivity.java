package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle(getLocalClassName());

        NewListApplication app = (NewListApplication) getApplicationContext();
        String log = app.getLog();

    }

    public void GotoNewsActivity(View view) {
        EditText username = (EditText) findViewById(R.id.text1);
        String Susername = String.valueOf(username.getText());
        Intent intent = new Intent(this, NewsActivity.class);
        Intent login = intent.putExtra("login", Susername );
        startActivity(intent);

        NewListApplication app = (NewListApplication) getApplicationContext();
        app.setLog(Susername);

        this.finish();
    }


}
