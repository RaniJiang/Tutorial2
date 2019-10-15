package com.example.tutorial2;


import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFrag extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_articles, container, false);


        // Inflate the layout for this fragment

        //Creating a RecyclerView
        recyclerView = view.findViewById(R.id.rv_main);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        //Creating and using Custom Adapter
        ArticleAdapter articleAdapter = new ArticleAdapter();
        articleAdapter.setData(FakeDatabase.getAllArticles());
        recyclerView.setAdapter(articleAdapter);

        return view;
    }

}
