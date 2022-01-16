package com.example.tp_film;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.List;

public class Adapteur extends RecyclerView.Adapter<Adapteur.ViewHolder>{

    private final List<Film> mListeFilm;

    public Adapteur(List<Film> film){
        mListeFilm=film;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View filmView = inflater.inflate(R.layout.item_film, parent, false);

        return new ViewHolder(filmView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Film film = mListeFilm.get(position);

        ImageView imageView = holder.imageView;
        String url = "https://image.tmdb.org/t/p/w500" + film.getPoster_path();
        Glide.with(imageView).load(url).placeholder(R.drawable.ic_launcher_foreground).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intend versdetail film ( autre activité )
            }
        });

    }

    @Override
    public int getItemCount() { return mListeFilm.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }


}
