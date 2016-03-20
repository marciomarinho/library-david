package com.library.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="book_in_hand")
    private String bookInHand;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "reader")
    private List<BookLending> bookLending;

    public Member(){

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

    public List<BookLending> getBookLending() {
        return bookLending;
    }

    public void setBookLending(List<BookLending> bookLending) {
        this.bookLending = bookLending;
    }

    public String getBookInHand() {
        return bookInHand;
    }

    public void setBookInHand(String bookInHand) {
        this.bookInHand = bookInHand;
    }
}
