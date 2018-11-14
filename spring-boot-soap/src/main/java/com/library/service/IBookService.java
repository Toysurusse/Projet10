package com.library.service;

import java.util.List;

public interface IBookService {

    void add(com.library.Book book);
    com.library.Book findById(int id);
    List<com.library.Book> findAll ();
    List<com.library.Book> findBySearch (String place);
}
