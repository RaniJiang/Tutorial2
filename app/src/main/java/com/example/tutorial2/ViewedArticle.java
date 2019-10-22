package com.example.tutorial2;

import com.google.gson.annotations.SerializedName;

public class ViewedArticle
{
    private long id;
    private String title;
    private String byline;
    @SerializedName("abstract")
    private String _abstract;

    public ViewedArticle() {
    }

    public ViewedArticle(long id, String title, String byline, String _abstract) {
        this.id = id;
        this.title = title;
        this.byline = byline;
        this._abstract = _abstract;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }
}
