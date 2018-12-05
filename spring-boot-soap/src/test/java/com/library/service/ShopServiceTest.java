package com.library.service;


import com.library.Book;
import com.library.Shop;
import com.library.entity.Shoppinglist;
import com.library.mapper.BookMapper;
import com.library.mapper.ShopMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void testservicesBook () {
        List<Shop> bookList = shopService.findAll();
        shopService.add(bookList.get(0));
        for (Shop b:bookList
                ) {
            System.out.println("Test BookName : "+b.getId());
        }
        shopService.findBySearch(108);
    }
}