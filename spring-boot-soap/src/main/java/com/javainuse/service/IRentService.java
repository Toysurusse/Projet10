package com.javainuse.service;

import com.javainuse.entity.Rent;

import java.util.List;

public interface IRentService {
    void add (Rent rent);
    List<Rent> findAll ();
}
