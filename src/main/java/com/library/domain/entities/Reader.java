package com.library.domain.entities;

import com.library.domain.entities.BookLeading;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="book_in_hand")
    private String bookInHand;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "reader")
    private List<BookLeading> bookLeading;

    public Reader(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<BookLeading> getBookLeading() {
        return bookLeading;
    }

    public void setBookLeading(List<BookLeading> bookLeading) {
        this.bookLeading = bookLeading;
    }

    public String getBookInHand() {
        return bookInHand;
    }

    public void setBookInHand(String bookInHand) {
        this.bookInHand = bookInHand;
    }
}
