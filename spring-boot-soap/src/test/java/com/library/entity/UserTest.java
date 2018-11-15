package com.library.entity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {


    @Test
    public void testUser() {
        String bookName = "TestBook";
        int nbPage = 1;

        User user = new User(bookName, bookName, bookName, bookName, nbPage, true);

        User user1 = new User();
        user1.setId(1);
        assertTrue(user1.getId()==1);
        user1.setMail("Auteur");
        user1.setPassword("Nom");
        user.setPseudo("Test");
        user1.setSalt("Test");
        user1.setRole(1);
        user1.setDelete(true);
        user1.setGender(true);
    }
}
