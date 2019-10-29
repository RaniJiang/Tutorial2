package com.example.tutorial2;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
        final View view = inflater.inflate(R.layout.fragment_books, container, false);

        //Volley API
        String url = "https://api.nytimes.com/svc/books/v3/lists.json";
        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Gson Conversion
                String api = response;
                Gson gson = new Gson();
                NYBooks nyBooks = gson.fromJson(api, NYBooks.class);

                // Set the adapter
                RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setAdapter(new BookAdapter(nyBooks.getResults()));
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);



        return view;
    }





}
