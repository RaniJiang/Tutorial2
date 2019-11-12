package com.example.tutorial2.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "BOOK")
public class Book {
    public String author;
    public String description;
    public int price;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "isbn")
    public String primary_isbn10;
    public String publisher;
    public String title;
    @ColumnInfo(name = "imageUrl")
    public String book_image;
    //@Ignore can be used if variable too complex e.g. an array

    //No Arguments Constructor is Important for Room
    public Book() {
    }

    @Ignore
    public Book(String author, String description, int price, String primary_isbn10, String publisher, String title, String book_image) {
        this.author = author;
        this.description = description;
        this.price = price;
        this.primary_isbn10 = primary_isbn10;
        this.publisher = publisher;
        this.title = title;
        this.book_image = book_image;
    }

    @NonNull
    public String getPrimary_isbn10() {
        return primary_isbn10;
    }

    public void setPrimary_isbn10(@NonNull String primary_isbn10) {
        this.primary_isbn10 = primary_isbn10;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public String getId() {
        return primary_isbn10;
    }

    public void setId(String id) {
        this.primary_isbn10 = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
