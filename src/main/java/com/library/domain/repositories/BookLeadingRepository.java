package com.library.domain.repositories;


import com.library.domain.entities.BookLeading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLeadingRepository extends JpaRepository<BookLeading,Long> {

}
