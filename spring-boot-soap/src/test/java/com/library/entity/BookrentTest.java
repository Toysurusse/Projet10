package com.library.entity;

import org.junit.Test;


import java.sql.Date;

import static org.junit.Assert.assertTrue;

public class BookrentTest {


    @Test
    public void testRentBook() {
        String bookName = "TestBook";
        int nbPage = 1;
        String editeurs = "TestEditors";
        String author = "TestAuthor";
        int dispo = 0;



        Rent rent = new Rent();
        rent.setId(1);
        assertTrue(rent.getId()==1);
        rent.setBook_id(1);
        rent.setUser_id(1);
        rent.setCreate_at(new Date(5000000));
        rent.setEnd_at(new Date(5000000));
        rent.setReturnbook(true);
        rent.setReload(true);
    }
}
