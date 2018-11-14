package com.library.service;

import com.library.Shop;

import java.util.List;

public interface IShopService {
        String add(Shop shop);
        Shop findById(int id);
        List<Shop> findAll();
        List<com.library.Shop> findBySearch(int place);
}
