package com.library.service;

import com.library.entity.Book;
import java.util.List;
import java.util.Optional;

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
        return bookMapper.bookListDtoE((List<Book>)  bookRepository.findAll());
    }

    @Override
    public List<com.library.Book> findBySearch(String place) {
        return bookMapper.bookListDtoE((List<Book>) bookRepository.search(place));
    }

    @Override
    public void add(com.library.Book book) {
        bookRepository.save(bookMapper.convertEtoD(book));
    }

    @Override
    public com.library.Book findById(int id) {
        return optional(bookRepository.findById(id));
    }

    private com.library.Book optional(Optional<Book> book){
        Book bookById=new Book(null,0,null,null,0);
        if (book.isPresent()){
            bookById=book.get();
        }
        return bookMapper.convertDtoE(bookById);
    }
}