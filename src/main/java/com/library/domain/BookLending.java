package com.library.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class BookLending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> book;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Member> member;


    @Column(name="date_took")
    private Date dateTook;

    @Column(name="date_back")
    private Date dateBack;

    public BookLending(){
    }


    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    public Date getDateTook() {
        return dateTook;
    }

    public void setDateTook(Date dateTook) {
        this.dateTook = dateTook;
    }

    public Date getDateBack() {
        return dateBack;
    }

    public void setDateBack(Date dateBack) {
        this.dateBack = dateBack;
    }




}
