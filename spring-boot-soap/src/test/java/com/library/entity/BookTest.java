package com.library.entity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookTest {


    @Test
    public void testBook() {
        String bookName = "TestBook";
        int nbPage=1;
        String editeurs= "TestEditors";
        String author= "TestAuthor";
        int dispo=0;

        Book bookTest = new Book(bookName, nbPage, editeurs, author, dispo);
        assertTrue(bookTest.getBookName().equals("TestBook"));
        assertTrue(bookTest.getEditeurs().equals("TestEditors"));
        assertTrue(bookTest.getDispo()==0);
        assertTrue(bookTest.getAuthor().equals("TestAuthor"));
        assertTrue(bookTest.getNbPage()==1);
        }
}
