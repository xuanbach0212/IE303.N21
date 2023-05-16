package com.ie303.springbootlibrary.dao;

import com.ie303.springbootlibrary.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndBookId(String userEmail, Long BookId);

    List<Checkout> findBooksByUserEmail(String userEmail);
    @Modifying
    @Query("delete from Checkout where book_id in :book_id")
    void deleteAllByBookId(@Param("book_id") Long bookId);
}
