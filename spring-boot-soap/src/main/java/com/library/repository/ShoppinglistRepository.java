package com.library.repository;

import com.library.entity.Rent;
import com.library.entity.Shoppinglist;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ShoppinglistRepository extends CrudRepository<Shoppinglist, Integer>  {
    @Transactional
    @Modifying
    @Query(
            value = "UPDATE public.shoppinglist\n" +
                    "\tSET dispo=false\n" +
                    "\tWHERE end_at<CURRENT_TIMESTAMP;",
            nativeQuery = true
    )
    void maj();
    @Query(
            value = "SELECT * FROM shoppinglist WHERE idusershop = :searchTerm AND end_at > CURRENT_TIMESTAMP AND dispo =TRUE ",
            nativeQuery = true
    )
    List<Shoppinglist> search(@Param("searchTerm") int searchTerm);

    @Query(value = "SELECT * FROM shoppinglist WHERE id=%id%", nativeQuery = true)
    Shoppinglist findOne(int id);
}

