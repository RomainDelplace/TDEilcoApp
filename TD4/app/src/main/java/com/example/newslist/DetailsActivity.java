package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        setTitle(getLocalClassName());
    }

    public void GotoNewsActivity(){
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
        this.finish();
    }

}