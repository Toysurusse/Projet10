package com.javainuse.service;

import com.javainuse.User;

import java.util.List;

public interface IUserService {
        String add(com.javainuse.User user);
        void delete(com.javainuse.User user);
        com.javainuse.User findById(int id);
        List<com.javainuse.User> findAll ();
        com.javainuse.User control(com.javainuse.User user);
}
