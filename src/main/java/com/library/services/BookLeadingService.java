package com.library.services;

import com.library.domain.entities.BookLeading;
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

    public BookLeading addBookLeading(BookLeading bookLeading) {
        BookLeading addBookLeading = bookLeadingRepository.saveAndFlush(bookLeading);
        return addBookLeading;
    }


    public List<BookLeading> getAll() {
        return bookLeadingRepository.findAll();
    }


    public void delete(long id) {
        bookLeadingRepository.delete(id);
    }
}
