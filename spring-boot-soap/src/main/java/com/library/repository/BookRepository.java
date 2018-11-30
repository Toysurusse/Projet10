package com.library.repository;

import com.library.entity.Book;
import com.library.entity.Rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query(
            value = "SELECT * FROM book WHERE bookname LIKE %:searchTerm%",
            nativeQuery = true
    )
    List<Book> search(@Param("searchTerm") String searchTerm);

    @Query(value = "SELECT * FROM book WHERE bookid=%id%", nativeQuery = true)
    Book findOne(@Param("id") int id);
}
