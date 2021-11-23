package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailsActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        setTitle(getLocalClassName());
    }

    public void GotoNewsActivity(View view){
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
        this.finish();
    }

}