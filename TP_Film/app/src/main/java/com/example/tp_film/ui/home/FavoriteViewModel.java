package com.example.tp_film.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoriteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FavoriteViewModel() {
        //

        mText = new MutableLiveData<>();
        mText.setValue("Work in progress");
    }

    public LiveData<String> getText() {
        return mText;
    }
}