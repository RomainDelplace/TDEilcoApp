package com.example.tp_film;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.layout.nav_bar);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item ){
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.layout.frame_popular:
                            selectedFragment = new FramePopular();
                            break;
                        case R.layout.frame_search:
                            selectedFragment = new FrameSearch();
                            break;
                        case R.layout.frame_favorite:
                            selectedFragment = new FrameFavorite();
                            break;
                        case R.layout.frame_upcoming:
                            selectedFragment = new FrameUpcoming();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, selectedFragment).commit();
                    return true;
                }
            };
}