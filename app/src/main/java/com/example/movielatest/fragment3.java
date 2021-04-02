package com.example.movielatest;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment3 extends Fragment {
    private RecyclerView mRecyclerView;
    private moviesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<movies> mMoviesData;
    movies movie = new movies();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment3_layout, container, false);


        mLayoutManager = new LinearLayoutManager(getContext());;
        mAdapter = new moviesAdapter(movie.fillMoviesList(),view.getContext());
        mRecyclerView = view.findViewById(R.id.recyclerview3);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        EditText searchText = view.findViewById(R.id.search_text);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


        return view;
    }



    //        Worked....
    private void filter(String text){
        ArrayList<movies> filteredMovieList = new ArrayList<>();
        String searchParameter = text.toLowerCase();
        for (movies movieEntry : movie.fillMoviesList()){
            if (movieEntry.getTitle().toLowerCase().contains(searchParameter)){
                filteredMovieList.add(movieEntry);
            }
        }
        mAdapter.filterList(filteredMovieList);
    }



    }


