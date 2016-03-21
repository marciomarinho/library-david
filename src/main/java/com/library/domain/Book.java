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

    @ManyToMany(mappedBy = "book")
    private List<BookLending> bookLeading;

    public Book(){
    }

    public Book(long id, String nameBook, String author, int count) {
       this.id = id;
        this.nameBook = nameBook;
        this.author = author;
        this.count = count;
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


    public List<BookLending> getBookLeading() {
        return bookLeading;
    }

    public void setBookLeading(List<BookLending> bookLeading) {
        this.bookLeading = bookLeading;
    }


}
