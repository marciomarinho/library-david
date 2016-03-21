package com.library.domain.repositories;


import com.library.domain.BookLending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLendingRepository extends JpaRepository<BookLending,Long> {

}
