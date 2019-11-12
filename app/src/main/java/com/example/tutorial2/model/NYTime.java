package com.example.tutorial2.model;

import java.util.ArrayList;

public class NYTime {
    private ArrayList<ViewedArticle> results;

    public NYTime(ArrayList results) {
        this.results = results;
    }

    public ArrayList getResults() {
        return results;
    }

    public void setResults(ArrayList results) {
        this.results = results;
    }
}
