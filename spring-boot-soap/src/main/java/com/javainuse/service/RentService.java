package com.javainuse.service;

import com.javainuse.Latebook;
import com.javainuse.entity.Rent;
import com.javainuse.Rentbook;
import com.javainuse.Book;
import com.javainuse.entity.Rent;
import com.javainuse.mapper.BookMapper;
import com.javainuse.mapper.RentMapper;
import com.javainuse.mapper.UserMapper;
import com.javainuse.repository.BookRentRepository;
import com.javainuse.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentService implements IRentService {

    @Autowired
    private BookRentRepository rentRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private UserMapper userMapper;

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
        if (book.isDispo()) {
            rentRepository.save(rentMapper.convertEtoD(rentbook));
            book.setDispo(false);
            bookService.add(book);
            statut="Ok";
        }
        else {
            rentRepository.save(rentMapper.convertEtoD(rentbook));
            book.setDispo(true);
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

    @Override
    public List<com.javainuse.Rentbook> findByUserId(int id) {
        List<com.javainuse.Rentbook> data = rentMapper.rentListDtoE((List<Rent>) rentRepository.findAll());
        List<com.javainuse.Rentbook> obj=new ArrayList<>();
        for (Rentbook a:data) {
            if (a.getUserId() == id) {
                obj.add(a);
            }
        }
        return obj;
    }

    @Override
    public List<Latebook> findByLate() {
        List<com.javainuse.Rentbook> data =rentMapper.rentListDtoE((List<Rent>) rentRepository.findDelayPassed());
        List<Latebook> mails=new ArrayList<>();

        for (Rentbook r: data) {
            Latebook l = new Latebook();
            l.setMail(userMapper.convertEtoD(userService.findById(r.getUserId())).getMail());
            l.setPseudo(userMapper.convertEtoD(userService.findById(r.getUserId())).getPseudo());
            l.setBookname(bookMapper.convertEtoD(bookService.findById(r.getBookId())).getBookName());
            System.out.println(l.getBookname());
            mails.add(l);
        }

        return mails;
    }
}