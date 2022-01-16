package com.example.tp_film.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp_film.ListeFilm;
import com.example.tp_film.R;
import com.example.tp_film.databinding.FrameUpcomingBinding;

public class FrameUpcoming extends Fragment {

    private UpcomingViewModel upcomingViewModel;
    private FrameUpcomingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        upcomingViewModel =
                new ViewModelProvider(this).get(UpcomingViewModel.class);

        binding = FrameUpcomingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textupcoming;
        upcomingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final TextView textViewfilm = binding.textupcoming;
        upcomingViewModel.getListeFilm().observe(getViewLifecycleOwner(), new Observer<ListeFilm>() {
            @Override
            public void onChanged(@Nullable ListeFilm listefilm)
            {
                // adapteur

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
