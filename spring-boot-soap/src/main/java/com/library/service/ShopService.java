package com.library.service;

import com.library.entity.Shoppinglist;
import com.library.mapper.ShopMapper;
import com.library.repository.ShoppinglistRepository;
import com.library.repository.ShoppinglistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements IShopService {

    @Autowired
    private ShoppinglistRepository shopRepository;

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<com.library.Shop> findAll() {
        List<com.library.Shop> obj = shopMapper.shopListDtoE((List<Shoppinglist>)  shopRepository.findAll());
        return obj;
    }

    @Override
    public List<com.library.Shop> findBySearch(int place) {
        System.out.println("Test");
        shopRepository.maj();
        System.out.println("Test");
        List<com.library.Shop> obj = shopMapper.shopListDtoE((List<Shoppinglist>) shopRepository.search(place));
        System.out.println("Test");
        return obj;
    }

    @Override
    public String add(com.library.Shop shop) {
        String result="Ok";
        shopRepository.save(shopMapper.convertEtoD(shop));
        return result;
    }

    @Override
    public void delete(com.library.Shop shop) {
        shopRepository.delete(shopMapper.convertEtoD(shop));
    }

    @Override
    public com.library.Shop findById(int id) {
        com.library.Shop obj = shopMapper.convertDtoE(shopRepository.findOne(id));
        return obj;
    }
}