package com.javainuse.service;

import com.javainuse.entity.Book;

import java.util.List;

public interface IBookService {

    void add(com.javainuse.Book book);
    void delete(com.javainuse.Book book);
    com.javainuse.Book findById(int id);
    List<com.javainuse.Book> findAll ();
    List<com.javainuse.Book> findBySearch (String place);
}
