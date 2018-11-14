package com.library.mapper;

import com.library.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMapper {

    public Book convertEtoD (com.library.Book book) {
        Book bookEntity = new Book(book.getBookName(), book.getNbPage(), book.getEditeurs(), book.getAuthor(), book.getDispo());
        bookEntity.setId(book.getId());

        return bookEntity;
    }

    public com.library.Book convertDtoE (Book book) {
        com.library.Book bookEntity = new com.library.Book();

        bookEntity.setId(book.getId());
        bookEntity.setBookName(book.getBookName());
        bookEntity.setEditeurs(book.getEditeurs());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setNbPage(book.getNbPage());
        bookEntity.setDispo(book.getDispo());

        return bookEntity;
    }


    public List<com.library.Book> bookListDtoE(List<Book> bookData) {

        List<com.library.Book> booksE = new ArrayList<>();

        for (int i = 0; i < bookData.size(); i++) {
            com.library.Book book =convertDtoE(bookData.get(i));
            booksE.add(book);
        }
        return booksE;
    }

    public List<Book> bookListEtoD(List<com.library.Book> bookEntity) {

        List<Book> booksD = new ArrayList<>();

        for (int i = 0; i < bookEntity.size(); i++) {
            Book book = convertEtoD(bookEntity.get(i));
            booksD.add(book);
        }
        return booksD;

    }
}
