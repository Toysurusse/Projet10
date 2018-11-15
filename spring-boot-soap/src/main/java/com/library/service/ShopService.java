package com.library.service;

import com.library.entity.Shoppinglist;
import com.library.mapper.ShopMapper;
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
        return shopMapper.shopListDtoE((List<Shoppinglist>)  shopRepository.findAll());
    }

    @Override
    public List<com.library.Shop> findBySearch(int place) {
        shopRepository.maj();
        return shopMapper.shopListDtoE((List<Shoppinglist>) shopRepository.search(place));
    }

    @Override
    public String add(com.library.Shop shop) {
        shopRepository.save(shopMapper.convertEtoD(shop));
        return "Ok";
    }

    @Override
    public com.library.Shop findById(int id) {
        return shopMapper.convertDtoE(shopRepository.findOne(id));
    }
}