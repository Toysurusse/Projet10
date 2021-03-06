package com.library.entity;

import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertTrue;

public class BookrentTest {


    @Test
    public void testRentBook() {
        int nbPage = 1;

        Rent rent = new Rent();
        rent.setId(1);
        assertTrue(rent.getId()==1);
        rent.setBook_id(1);
        rent.setUser_id(1);
        rent.setCreate_at(new Date(5000000));
        rent.setEnd_at(new Date(5000000));
        rent.setReturnbook(true);
        rent.setReload(true);

        Rent rent1 = new Rent (nbPage,nbPage,rent.getCreate_at(),rent.getEnd_at(),true,true);
        assertTrue(rent.getId()==1);
        assertTrue(rent.isReload());
        assertTrue(rent1.isReturnbook());
        assertTrue(rent.getUser_id()==1);
        assertTrue(rent.getBook_id()==1);

    }
}
