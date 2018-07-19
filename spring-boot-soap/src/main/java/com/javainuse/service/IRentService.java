package com.javainuse.service;

import com.javainuse.entity.Rent;

import java.util.List;

public interface IRentService {
    void add(com.javainuse.Rentbook rent);
    void delete(com.javainuse.Rentbook rent);
    com.javainuse.Rentbook findById(int id);
    List<com.javainuse.Rentbook> findAll ();
}
