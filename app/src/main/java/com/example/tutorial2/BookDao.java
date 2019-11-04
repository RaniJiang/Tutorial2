package com.example.tutorial2;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

public interface BookDao {

    @Insert
    public void insert(Book...BOOK);

    @Update
    public void update(Book...BOOK);

    @Delete
    public void delete(Book BOOK);

    @Query("SELECT * FROM BOOK")
    public ArrayList<Book> getBooks();

    @Query("SELECT * FROM BOOK WHERE price >= 10")
    public ArrayList<Book> getExpensiveBooks();



}
