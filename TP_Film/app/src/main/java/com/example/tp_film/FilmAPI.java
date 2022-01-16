package com.example.tp_film;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmAPI {
    public static final String ENDPOINT = "https://api.themoviedb.org/";

    @GET("/3/movie/upcoming?api_key=ccc5559c8290ac347ae3a25a1177012d")
    Call<ListeFilm> getupcoming();

    @GET("/3/movie/popular?api_key=ccc5559c8290ac347ae3a25a1177012d")
    Call<ListeFilm> getpopular();

    @GET("/3/movie/{id}?api_key=ccc5559c8290ac347ae3a25a1177012d")
    Call<Film> getfilmdetail(@Path("id") String id);

    @GET("/3/search/movie?api_key=ccc5559c8290ac347ae3a25a1177012d")
    Call<ListeFilm> getsearch(@Query("query") String query);
}
