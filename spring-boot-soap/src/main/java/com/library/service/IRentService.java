package com.library.service;

import com.library.Latebook;

import java.util.List;

public interface IRentService {
    String add(com.library.Rentbook rent);
    com.library.Rentbook findById(int id);
    List<com.library.Rentbook> findAll ();
    List<com.library.Rentbook> findByUserId(int id);
    List<Latebook> findByLate();
    List<Latebook> findByEnd();
    String back(com.library.Rentbook rentbook);
}
