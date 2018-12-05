package com.library.service;

import com.library.Book;
import com.library.mapper.BookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testservicesBook () {
        List<Book> bookList = bookService.findAll();
        bookService.add(bookList.get(0));
        for (Book b:bookList
             ) {
            System.out.println("Test BookName : "+b.getBookName());
        }
        bookService.findBySearch(bookList.get(0).getBookName());
        bookMapper.bookListEtoD(bookList);
        bookService.findById(10);
    }
}
