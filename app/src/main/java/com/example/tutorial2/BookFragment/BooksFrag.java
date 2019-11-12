package com.example.tutorial2.BookFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.example.tutorial2.database.AppDatabase;
import com.example.tutorial2.model.Book;
import com.example.tutorial2.database.BookDao;
import com.example.tutorial2.model.NYBooks;
import com.example.tutorial2.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class BooksFrag extends Fragment {

    //ArrayList<Book> books;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;

    public BooksFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_books, container, false);

        //Volley API
        String url = "https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=DCTNAA6QLfKcudy4YXSlGRruJTVu14Gv";
        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);

                //Gson Conversion
                Gson gson = new Gson();
                NYBooks nyBooks = gson.fromJson(response, NYBooks.class);

                //Get Book Array Created by GSON
                ArrayList<Book> books = nyBooks.getResults().getBooks();
                //Pass this Array into Database
                AppDatabase appDatabase = AppDatabase.getInstance(view.getContext());
                BookDao bookDao = appDatabase.bookDao();
                bookDao.insert(books);
                //Get From Database BookList
                ArrayList<Book> dbBooks =(ArrayList<Book>) bookDao.getBooks();

                // Set the adapter
                recyclerView = view.findViewById(R.id.rv_books);
                layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new BookAdapter(dbBooks));
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("GSON VOLLEY ERROR !");

            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);



        return view;
    }





}
