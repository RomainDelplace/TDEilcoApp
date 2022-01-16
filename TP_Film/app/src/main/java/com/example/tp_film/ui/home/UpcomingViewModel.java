package com.example.tp_film.ui.home;

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

public class UpcomingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private MutableLiveData<ListeFilm> mListeFilm;

    public LiveData<ListeFilm> getListeFilm(){
        return mListeFilm;
    }

    public UpcomingViewModel() {
        // API
        mListeFilm = new MutableLiveData<>();
        FilmAPI filmapi = new Retrofit.Builder()
                .baseUrl(FilmAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FilmAPI.class);

        filmapi.getupcoming().enqueue(new Callback<ListeFilm>() {
            @Override
            public void onResponse(Call<ListeFilm> call, Response<ListeFilm> response) {
                mListeFilm.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ListeFilm> call, Throwable t) {
            }
        });

        mText = new MutableLiveData<>();
        mText.setValue("This is upcoming fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


}