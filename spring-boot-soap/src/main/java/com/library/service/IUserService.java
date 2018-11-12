package com.library.service;

import com.library.User;

import java.util.List;

public interface IUserService {
        String add(com.library.User user);
        void delete(com.library.User user);
        com.library.User findById(int id);
        List<com.library.User> findAll ();
        com.library.User control(com.library.User user);
}
