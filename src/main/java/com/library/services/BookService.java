package com.library.services;

import com.library.domain.Book;
import com.library.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        Book saveBook = bookRepository.save(book);
        return saveBook;
    }

    public void delete(long id) {
        bookRepository.delete(id);
    }

    public Book editBook(Book book) {
        Book editBook = bookRepository.save(book);
        return editBook;
    }

    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book findOne(long id) {
        return bookRepository.findOne(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
