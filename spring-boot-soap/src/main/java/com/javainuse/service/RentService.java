package com.javainuse.service;

import com.javainuse.Rentbook;
import com.javainuse.Book;
import com.javainuse.entity.Rent;
import com.javainuse.mapper.RentMapper;
import com.javainuse.repository.BookRentRepository;
import com.javainuse.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService implements IRentService {

    @Autowired
    private BookRentRepository rentRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private RentMapper rentMapper;

    @Override
    public List<com.javainuse.Rentbook> findAll() {
        List<com.javainuse.Rentbook> obj = rentMapper.rentListDtoE((List<Rent>) rentRepository.findAll());
        return obj;
    }

    @Override
    public String add(com.javainuse.Rentbook rentbook) {
        String statut="Impossible";
        Book book = bookService.findById(rentbook.getBookId());
        System.out.println(book.getId()+" ; "+book.getBookName()+" ; "+book.getAuthor()+" ; "+book.getEditeurs()+" ; "+book.getNbPage()+" ; "+book.isDispo()+" ; ");
        if (book.isDispo() == true) {
            rentRepository.save(rentMapper.convertEtoD(rentbook));
            book.setDispo(false);
            bookService.add(book);
            statut="Ok";
        }
        return statut;
    }

    @Override
    public void delete(com.javainuse.Rentbook rentbook) {
        rentRepository.delete(rentMapper.convertEtoD(rentbook));
    }

    @Override
    public com.javainuse.Rentbook findById(int id) {
        com.javainuse.Rentbook obj = rentMapper.convertDtoE(rentRepository.findOne(id));
        return obj;
    }
}
