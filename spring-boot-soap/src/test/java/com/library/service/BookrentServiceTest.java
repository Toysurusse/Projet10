package com.library.service;

import com.library.Book;
import com.library.Rentbook;
import com.library.Shop;
import com.library.mapper.RentMapper;
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

    @Autowired
    private RentMapper rentMapper;

    @Test
    public void testservicesBookrent () {
        List<Rentbook> bookrentList = bookrentService.findAll();
        bookrentService.add(bookrentList.get(0));
        rentMapper.rentListEtoD(bookrentList);
        bookrentService.findByLate();
        bookrentService.findByEnd();
        bookrentService.findById(120);
        bookrentService.findByUserId(108);
    }
}
