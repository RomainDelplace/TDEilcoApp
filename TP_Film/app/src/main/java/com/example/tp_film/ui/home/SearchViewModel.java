package com.example.tp_film.ui.home;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp_film.FilmAPI;
import com.example.tp_film.ListeFilm;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchViewModel extends ViewModel {

    private MutableLiveData<ListeFilm> mListeFilm;
    private FilmAPI filmapi;
    public LiveData<ListeFilm> getListeFilm(){
        return mListeFilm;
    }

    public SearchViewModel() {
        mListeFilm = new MutableLiveData<>();
        filmapi = new Retrofit.Builder()
                .baseUrl(FilmAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FilmAPI.class);
    }

    public void recherche(String motcle){
        filmapi.getsearch(motcle).enqueue(new Callback<ListeFilm>() {
            @Override
            public void onResponse(Call<ListeFilm> call, Response<ListeFilm> response) {
                mListeFilm.setValue(response.body());
            }
            @Override
            public void onFailure(Call<ListeFilm> call, Throwable t) {
            }
        });
    }

}