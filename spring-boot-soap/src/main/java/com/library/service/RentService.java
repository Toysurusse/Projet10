package com.library.service;

import com.library.Latebook;
import com.library.entity.Rent;
import com.library.Rentbook;
import com.library.Book;

import com.library.mapper.BookMapper;
import com.library.mapper.RentMapper;
import com.library.mapper.UserMapper;
import com.library.repository.BookRentRepository;
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
    public List<com.library.Rentbook> findAll() {
        List<com.library.Rentbook> obj = rentMapper.rentListDtoE((List<Rent>) rentRepository.findAll());
        return obj;
    }

    @Override
    public String add(com.library.Rentbook rentbook) {
        rentRepository.save(rentMapper.convertEtoD(rentbook));
        String statut="Ok";
        return statut;
    }

    @Override
    public String back(com.library.Rentbook rentbook) {
        String statut="Impossible";
        Book book = bookService.findById(rentbook.getBookId());
        rentRepository.save(rentMapper.convertEtoD(rentbook));
        book.setDispo(book.getDispo()+1);
        bookService.add(book);
        statut="Ok";
        return statut;
    }

    @Override
    public com.library.Rentbook findById(int id) {
        com.library.Rentbook obj = rentMapper.convertDtoE(rentRepository.findOne(id));
        return obj;
    }

    @Override
    public List<com.library.Rentbook> findByUserId(int id) {
        List<com.library.Rentbook> data = rentMapper.rentListDtoE((List<Rent>) rentRepository.findAll());
        List<com.library.Rentbook> obj=new ArrayList<>();
        for (Rentbook a:data) {
            if (a.getUserId() == id) {
                obj.add(a);
            }
        }
        return obj;
    }

    @Override
    public List<Latebook> findByLate() {
        List<com.library.Rentbook> data =rentMapper.rentListDtoE((List<Rent>) rentRepository.findDelayPassed());
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