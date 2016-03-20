package com.library.services;

import com.library.domain.BookLending;
import com.library.domain.repositories.BookLeadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLeadingService {

    @Autowired
    @Qualifier("bookLeadingRepository")
    private BookLeadingRepository bookLeadingRepository;

    public BookLending addBookLeading(BookLending bookLending) {
        BookLending addBookLending = bookLeadingRepository.saveAndFlush(bookLending);
        return addBookLending;
    }


    public List<BookLending> getAll() {
        return bookLeadingRepository.findAll();
    }


    public void delete(long id) {
        bookLeadingRepository.delete(id);
    }
}
