package com.library.service;

import com.library.Shop;
import com.library.SpringBootLibraryApplication;
import com.library.entity.Book;
import com.library.entity.Shoppinglist;
import com.library.mapper.ShopMapper;
import com.library.repository.ShoppinglistRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements IShopService {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(SpringBootLibraryApplication.class);
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
        logger.trace("Test id shop : "+shop.getId());
        shopRepository.save(shopMapper.convertEtoD(shop));
        return "Ok";
    }

    @Override
    public com.library.Shop findById(int id) {
        return optional(shopRepository.findById(id));
    }

    private com.library.Shop optional(Optional<Shoppinglist> book){
        Shoppinglist bookById=new Shoppinglist(0,0,null,null,false,null);
        if (book.isPresent()){
            bookById=book.get();
        }
        return shopMapper.convertDtoE(bookById);
    }
}