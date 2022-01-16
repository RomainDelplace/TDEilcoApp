package com.example.tp_film.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_film.Adapteur;
import com.example.tp_film.ListeFilm;
import com.example.tp_film.R;
import com.example.tp_film.databinding.FrameSearchBinding;

public class FrameSearch extends Fragment {

    private SearchViewModel searchViewModel;
    private FrameSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FrameSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView recyclerViewfilm = binding.recyclerviewsearch;
        searchViewModel.getListeFilm().observe(getViewLifecycleOwner(), new Observer<ListeFilm>() {
            @Override
            public void onChanged(ListeFilm listeFilm) {
                recyclerViewfilm.setAdapter(new Adapteur(listeFilm.getListefilm()));
                recyclerViewfilm.setLayoutManager(new GridLayoutManager(root.getContext(),2));
            }
        });

        Button button = binding.button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String motcle = binding.recherche.getText().toString();
                if (!motcle.equals("")){
                    searchViewModel.recherche(motcle);
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
