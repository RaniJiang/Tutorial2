package com.example.tutorial2;

import java.util.ArrayList;

public class NYBooks {
    private ArrayList<BookMeta> results;

    public NYBooks(ArrayList results) {
        this.results = results;
    }

    public ArrayList getResults() {
        return results;
    }

    public void setResults(ArrayList results) {
        this.results = results;
    }

    public class BookMeta {
        private ArrayList<Book> book_details;

        public BookMeta(ArrayList<Book> book_details) {
            this.book_details = book_details;
        }

        public ArrayList<Book> getBook_details() {
            return book_details;
        }

        public void setBook_details(ArrayList<Book> book_details) {
            this.book_details = book_details;
        }
    }
}
