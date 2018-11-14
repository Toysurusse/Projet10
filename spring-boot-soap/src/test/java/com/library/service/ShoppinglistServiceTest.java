package com.library.service;

import com.library.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppinglistServiceTest {

    @Autowired
    private ShopService shoppinglistService;

    @Test
    public void testservicesShoppinglist () {
        List<Shop> shoppinglistList = shoppinglistService.findAll();
        shoppinglistService.add(shoppinglistList.get(0));
        shoppinglistService.findById(shoppinglistList.get(0).getId());
        shoppinglistService.findBySearch(shoppinglistList.get(0).getIdusershop());
    }
}
