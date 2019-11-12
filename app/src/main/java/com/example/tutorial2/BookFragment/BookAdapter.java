package com.example.tutorial2.BookFragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tutorial2.model.Book;
import com.example.tutorial2.DetailActivity;
import com.example.tutorial2.R;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    ArrayList<Book> books;
    Context context;

    public BookAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
        public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book, parent, false);
            this.context = parent.getContext();
            BookViewHolder bookViewHolder = new BookViewHolder(view);
            return bookViewHolder;

        }

        //onclick give onclick listener
        public void onBindViewHolder(@NonNull BookViewHolder holder, final int position){
            final Book bookAtPosition = books.get(position);
            holder.titleTv.setText(bookAtPosition.getTitle());
            holder.authorTv.setText(bookAtPosition.getAuthor());
            holder.synopsisTv.setText(bookAtPosition.getDescription());
            Glide.with(context).load(bookAtPosition.getBook_image()).into(holder.bookImage);

            holder.bookll.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("ID",bookAtPosition.getId());
                    v.getContext().startActivity(intent);

                }
            });

        }

        public int getItemCount(){
            return books.size();
        }

        public void setData(ArrayList<Book> books) {
            this.books = new ArrayList<>(books);
        }


    public class BookViewHolder extends RecyclerView.ViewHolder {
        public View bookll;
        public TextView titleTv;
        public TextView authorTv;
        public TextView synopsisTv;
        public ImageView bookImage;

        public BookViewHolder(View view) {
            super(view);
            bookll = view;
            titleTv = view.findViewById(R.id.titleTv);
            authorTv = view.findViewById(R.id.authorTv);
            synopsisTv = view.findViewById(R.id.synopsisTv);
            bookImage = view.findViewById(R.id.bookImage);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + titleTv.getText() + "'";
        }
    }
}
