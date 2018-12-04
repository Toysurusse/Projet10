package com.library.repository;

import com.library.entity.Rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRentRepository extends CrudRepository<Rent, Integer> {
    @Query(value = "SELECT * FROM rentbook WHERE end_at < current_date", nativeQuery = true)
    List<Rent> findDelayPassed();

    @Query(value = "SELECT * FROM rentbook WHERE end_at < current_date + integer '2' AND end_at > current_date", nativeQuery = true)
    List<Rent> findDelayEnd();
}
