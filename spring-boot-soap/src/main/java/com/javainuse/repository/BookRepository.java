package com.javainuse.repository;

import com.javainuse.entity.Book;
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
}
