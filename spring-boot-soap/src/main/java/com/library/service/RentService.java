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
        return rentMapper.rentListDtoE((List<Rent>) rentRepository.findAll());
    }

    @Override
    public String add(com.library.Rentbook rentbook) {
        rentRepository.save(rentMapper.convertEtoD(rentbook));
        return "Ok";
    }

    @Override
    public String back(com.library.Rentbook rentbook) {
        Book book = bookService.findById(rentbook.getBookId());
        rentRepository.save(rentMapper.convertEtoD(rentbook));
        book.setDispo(book.getDispo()+1);
        bookService.add(book);
        return "Ok";
    }

    @Override
    public com.library.Rentbook findById(int id) {
        return rentMapper.convertDtoE(rentRepository.findOne(id));
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