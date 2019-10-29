package com.example.tutorial2;

public class Book {
    public String author;
    public String description;
    public int price;
    public String primary_isbn10;
    public String publisher;
    public String title;

    public Book() {
    }

    public Book(String author, String description, int price, String primary_isbn10, String publisher, String title) {
        this.author = author;
        this.description = description;
        this.price = price;
        this.primary_isbn10 = primary_isbn10;
        this.publisher = publisher;
        this.title = title;
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
