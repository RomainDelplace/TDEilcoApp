package com.example.tp_film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        // recupere item xml + intend
        Intent intent = getIntent();
        String idfilm = "1";
        if (intent.hasExtra("idfilm")) {
            idfilm = intent.getStringExtra("idfilm");
        }

        FilmAPI filmapi = new Retrofit.Builder()
                .baseUrl(FilmAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FilmAPI.class);

        filmapi.getfilmdetail(idfilm).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                afficherFilm(response.body());
            }
            @Override
            public void onFailure(Call<Film> call, Throwable t) {
            }
        });

        Button boutonretour = (Button) findViewById(R.id.boutonretour);
        boutonretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void afficherFilm(Film film){
        ImageView imageView = (ImageView) findViewById(R.id.imagefilm);
        TextView filmtitre = (TextView) findViewById(R.id.textfilmtitre);
        TextView filmdetail = (TextView) findViewById(R.id.textfilmdetail);

        filmtitre.setText(film.getTitle());
        filmdetail.setText(film.getOverview());
        String url = "https://image.tmdb.org/t/p/w500" + film.getPoster_path();
        Glide.with(imageView).load(url).placeholder(R.drawable.ic_launcher_foreground).into(imageView);

    }
}