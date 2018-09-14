package com.javainuse.service;

import com.javainuse.entity.Book;
import java.util.List;

import com.javainuse.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javainuse.repository.BookRepository;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<com.javainuse.Book> findAll() {
        List<com.javainuse.Book> obj = bookMapper.bookListDtoE((List<Book>) bookRepository.findAll());
        return obj;
    }

    @Override
    public List<com.javainuse.Book> findBySearch(String place) {
        System.out.println(place);
        List<com.javainuse.Book> obj = bookMapper.bookListDtoE((List<Book>) bookRepository.search(place));
        for (com.javainuse.Book b:obj) {
            System.out.println(b.getBookName());
        }
        return obj;
    }

    @Override
    public void add(com.javainuse.Book book) {
        bookRepository.save(bookMapper.convertEtoD(book));
    }

    @Override
    public void delete(com.javainuse.Book book) {
        bookRepository.delete(bookMapper.convertEtoD(book));
    }

    @Override
    public com.javainuse.Book findById(int id) {
        com.javainuse.Book obj = bookMapper.convertDtoE(bookRepository.findOne(id));
        return obj;
    }

}