package com.example.tutorial2;

import java.util.ArrayList;

public class NYBooks {
    public BookMeta results;

    public NYBooks(BookMeta results) {
        this.results = results;
    }

    public BookMeta getResults() {
        return results;
    }

    public void setResults(BookMeta results) {
        this.results = results;
    }
}
