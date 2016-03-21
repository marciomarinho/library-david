package com.library.services;

import com.library.domain.BookLending;
import com.library.domain.repositories.BookLendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLendingService {

    @Autowired
    @Qualifier("bookLendingRepository")
    private BookLendingRepository bookLeadingRepository;

    public BookLending addBookLeading(BookLending bookLeading) {
        BookLending addBookLeading = bookLeadingRepository.saveAndFlush(bookLeading);
        return addBookLeading;
    }


    public List<BookLending> getAll() {
        return bookLeadingRepository.findAll();
    }


    public void delete(long id) {
        bookLeadingRepository.delete(id);
    }
}
