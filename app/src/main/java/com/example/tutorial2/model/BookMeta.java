package com.example.tutorial2.model;

import java.util.ArrayList;

public class BookMeta {
        private ArrayList<Book> books;

        public BookMeta(ArrayList<Book> books) {
            this.books = books;
        }

        public ArrayList<Book> getBooks() {
            return books;
        }

        public void setBooks(ArrayList<Book> books) {
            this.books = books;
        }
}