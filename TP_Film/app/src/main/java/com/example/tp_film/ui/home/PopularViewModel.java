package com.example.tp_film.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PopularViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PopularViewModel() {
        // API
        mText = new MutableLiveData<>();
        mText.setValue("This is populare fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}