package com.example.tp_film;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListeFilm {

    @SerializedName("results")
    private List<Film> listefilm;

    public List<Film> getListefilm() {
        return listefilm;
    }
}
