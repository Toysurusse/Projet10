package com.library.service;

import com.library.Rentbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookrentServiceTest {

    @Autowired
    private RentService bookrentService;

    @Test
    public void testservicesBookrent () {
        List<Rentbook> bookrentList = bookrentService.findAll();
        bookrentService.add(bookrentList.get(0));
        bookrentService.findById(bookrentList.get(0).getRentid());
        bookrentService.findByLate();
        bookrentService.findByUserId(bookrentList.get(0).getUserId());
        bookrentService.back(bookrentList.get(0));
    }
}
