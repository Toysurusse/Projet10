package com.library.entity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {


    @Test
    public void testUser() {
        String bookName = "TestBook";
        int nbPage = 1;
        String editeurs = "TestEditors";
        String author = "TestAuthor";
        int dispo = 0;

        Book bookTest = new Book(bookName, nbPage, editeurs, author, dispo);
        assertTrue(bookTest.getBookName().equals("TestBook"));
        assertTrue(bookTest.getEditeurs().equals("TestEditors"));
        assertTrue(bookTest.getDispo() == 0);
        assertTrue(bookTest.getAuthor().equals("TestAuthor"));
        assertTrue(bookTest.getNbPage() == 1);

        Book book = new Book();
        book.setId(1);
        assertTrue(book.getId()==1);
        book.setAuthor("Auteur");
        book.setBookName("Nom");
        book.setDispo(1);
        book.setEditeurs("Test");
        book.setNbPage(1);

    }
}
