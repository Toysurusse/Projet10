package com.javainuse.service;

import com.javainuse.Rentbook;
import com.javainuse.entity.Rent;
import com.javainuse.mapper.RentMapper;
import com.javainuse.repository.BookRentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RentService implements IRentService {

    @Autowired
    private BookRentRepository rentRepository;

    @Autowired
    private RentMapper rentMapper;

    @Override
    public List<com.javainuse.Rentbook> findAll() {
        List<com.javainuse.Rentbook> obj = rentMapper.rentListDtoE((List<Rent>) rentRepository.findAll());
        return obj;
    }

    @Override
    public void add(com.javainuse.Rentbook rentbook) {
        rentRepository.save(rentMapper.convertEtoD(rentbook));
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
