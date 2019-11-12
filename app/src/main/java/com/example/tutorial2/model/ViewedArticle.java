package com.example.tutorial2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ViewedArticle
{
    private long id;
    private String title;
    private String byline;
    @SerializedName("abstract")
    private String _abstract;
    private String url;
    @SerializedName("published_date")
    private String publishedDate;
    private ArrayList media;

    public ViewedArticle() {

    }

    public ViewedArticle(long id, String title, String byline, String _abstract, String url, String publishedDate, ArrayList media) {
        this.id = id;
        this.title = title;
        this.byline = byline;
        this._abstract = _abstract;
        this.url = url;
        this.publishedDate = publishedDate;
        this.media = media;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public ArrayList getMedia() {
        return media;
    }

    public void setMedia(ArrayList media) {
        this.media = media;
    }
}
