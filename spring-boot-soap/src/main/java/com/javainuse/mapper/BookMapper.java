package com.javainuse.mapper;

import com.javainuse.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import com.javainuse.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMapper {

    public Book convertEtoD (com.javainuse.Book book) {
        Book bookEntity = new Book(book.getBookName(), book.getNbPage(), book.getEditeurs(), book.getAuthor(), book.isDispo());
        bookEntity.setId(book.getId());
        return bookEntity;
    }

    public com.javainuse.Book convertDtoE (Book book) {
        com.javainuse.Book bookEntity = new com.javainuse.Book();

        bookEntity.setId(book.getId());
        bookEntity.setBookName(book.getBookName());
        bookEntity.setEditeurs(book.getEditeurs());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setNbPage(book.getNbPage());
        bookEntity.setDispo(book.getDispo());

        return bookEntity;
    }


    public List<com.javainuse.Book> bookListDtoE(List<Book> bookData) {

        List<com.javainuse.Book> booksE = new ArrayList<>();

        for (int i = 0; i < bookData.size(); i++) {
            com.javainuse.Book book =convertDtoE(bookData.get(i));
            booksE.add(book);
        }
        return booksE;
    }

    public List<Book> bookListEtoD(List<com.javainuse.Book> bookEntity) {

        List<Book> booksD = new ArrayList<>();

        for (int i = 0; i < bookEntity.size(); i++) {
            Book book = convertEtoD(bookEntity.get(i));
            booksD.add(book);
        }
        return booksD;

    }
}
