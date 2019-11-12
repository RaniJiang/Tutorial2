package com.example.tutorial2.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tutorial2.model.Book;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface BookDao {

    //Conflict Strategy - Room
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    //... -> can be 1 or an array of thing - only works for array, not list or arraylist
    public void insert(Book...BOOK);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    public void insert(ArrayList<Book> booksArrayList);

    @Update
    public void update(Book...BOOK);

    @Delete
    public void delete(Book BOOK);

    @Query("SELECT * FROM BOOK")
    //the thing below is what java sees
    public List<Book> getBooks();

    @Query("SELECT * FROM BOOK WHERE price >= 10")
    public List<Book> getExpensiveBooks();

    @Insert
    public void insertBookList (ArrayList<Book> book);


}
