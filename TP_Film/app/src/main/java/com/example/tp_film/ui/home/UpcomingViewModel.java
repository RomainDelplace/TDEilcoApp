package com.example.tp_film.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UpcomingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UpcomingViewModel() {
        // API
        mText = new MutableLiveData<>();
        mText.setValue("This is upcoming fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}