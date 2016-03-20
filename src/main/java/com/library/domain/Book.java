package com.library.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name_book")
    private String nameBook;

    @Column(name="author")
    private String author;

    @Column(name="count")
    private int count;

    @ManyToMany( mappedBy = "book")
    private List<BookLending> bookLending;

    public Book(){

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public List<BookLending> getBookLending() {
        return bookLending;
    }

    public void setBookLending(List<BookLending> bookLending) {
        this.bookLending = bookLending;
    }


}
