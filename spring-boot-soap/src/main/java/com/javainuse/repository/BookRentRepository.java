package com.javainuse.repository;

import com.javainuse.entity.Rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRentRepository extends CrudRepository<Rent, Integer> {
    @Query(value = "SELECT * FROM rentbook", nativeQuery = true)
    List<Rent> findDelayPassed();
}
