package com.javainuse.service;

import com.javainuse.Latebook;
import com.javainuse.entity.Rent;

import java.util.List;

public interface IRentService {
    String add(com.javainuse.Rentbook rent);
    void delete(com.javainuse.Rentbook rent);
    com.javainuse.Rentbook findById(int id);
    List<com.javainuse.Rentbook> findAll ();
    List<com.javainuse.Rentbook> findByUserId(int id);
    List<Latebook> findByLate();
    String back(com.javainuse.Rentbook rentbook);
}
