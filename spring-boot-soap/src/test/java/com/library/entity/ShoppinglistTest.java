package com.library.entity;

import com.library.Shop;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;

public class ShoppinglistTest {


    @Test
    public void testShop() {
        String bookName = "TestBook";
        int nbPage = 1;
        String editeurs = "TestEditors";
        String author = "TestAuthor";
        int dispo = 0;

        Shoppinglist shoppinglist = new Shoppinglist(nbPage, nbPage, new Timestamp(110000000), new Timestamp(110000000), true, "dispo");
        shoppinglist.setId(1);
        assertTrue(shoppinglist.getId() == 1);
        assertTrue(shoppinglist.getIdbookshop() == 1);
        assertTrue(shoppinglist.getIdusershop() == 1);
        assertTrue(shoppinglist.getCreate_at().getTime() == 110000000);
        assertTrue(shoppinglist.getEnd_at().getTime() == 110000000);

        Shoppinglist shoppinglist1 = new  Shoppinglist();
        shoppinglist1.setId(1);
        assertTrue(shoppinglist1.getId()==1);
        shoppinglist1.setIdbookshop(1);
        shoppinglist1.setIdusershop(1);
        shoppinglist1.setDispo(true);
        shoppinglist1.setCreate_at(new Timestamp(1000));
        shoppinglist1.setEnd_at(new Timestamp(1000));
        assertTrue(shoppinglist.getIdpannier().equals("dispo"));
    }
}
