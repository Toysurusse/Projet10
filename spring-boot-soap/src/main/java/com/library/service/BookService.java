package com.library.service;

import com.library.entity.Book;
import java.util.List;

import com.library.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<com.library.Book> findAll() {
        List<com.library.Book> obj = bookMapper.bookListDtoE((List<Book>)  bookRepository.findAll());
        return obj;
    }

    @Override
    public List<com.library.Book> findBySearch(String place) {
        List<com.library.Book> obj = bookMapper.bookListDtoE((List<Book>) bookRepository.search(place));
        return obj;
    }

    @Override
    public void add(com.library.Book book) {
        System.out.println(book.getId());
        bookRepository.save(bookMapper.convertEtoD(book));
    }

    @Override
    public void delete(com.library.Book book) {
        bookRepository.delete(bookMapper.convertEtoD(book));
    }

    @Override
    public com.library.Book findById(int id) {
        com.library.Book obj = bookMapper.convertDtoE(bookRepository.findOne(id));
        return obj;
    }

}