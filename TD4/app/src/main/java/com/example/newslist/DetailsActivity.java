package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        setTitle(getLocalClassName());

        TextView texte = (TextView) findViewById(R.id.text1);
        NewListApplication app = (NewListApplication) getApplicationContext();
        String log = app.getLog();
        texte.setText(log);
    }

    public void GotoNewsActivity(View view){
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
        this.finish();
    }


}