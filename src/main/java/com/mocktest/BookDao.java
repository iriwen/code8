package com.mocktest;

import java.util.Collections;
import java.util.List;

/**
 * Created by a0285 on 2018/7/19.
 */

public class BookDao {

    private static BookDao bookDAL = new BookDao();

    public List<Book> getAllBooks(){
        return Collections.EMPTY_LIST;
    }

    public Book getBook(String isbn){
        return null;
    }

    public String addBook(Book book){
        return book.getIsbn();
    }

    public String updateBook(Book book){
        return book.getIsbn();
    }

    public static BookDao getInstance(){
        return bookDAL;
    }
}