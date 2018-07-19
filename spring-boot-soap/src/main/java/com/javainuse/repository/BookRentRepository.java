package com.javainuse.repository;

import com.javainuse.entity.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentRepository extends CrudRepository<Rent, Integer> {

}
