package com.example.tutorial2;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;

public class BooksFrag extends Fragment {

    ArrayList<Book> books;

    public BooksFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        //Volley API
        String url = "https://api.nytimes.com/svc/books/v3/lists.json";


        //Gson Conversion
        String api = FakeApi.getMostViewedStoriesJsonString();
        Gson gson = new Gson();
        NYBooks nyBooks = gson.fromJson(api, NYBooks.class);

        // Set the adapter
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setAdapter(new BookAdapter(nyBooks.getResults()));

        return view;
    }





}
