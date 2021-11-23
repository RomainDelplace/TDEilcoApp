package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        setTitle(getLocalClassName());
    }

    public void GotoDetailsActivity(){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    public void GotoLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
}