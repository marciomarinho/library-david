package com.library.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class BookLending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Book> book;

    //TODO: Once you remove the below List<Member> remove this transient (non-persistent) annotation.
    @Transient
    private Member member;

    //TODO: Get rid of this thing. it does not exist !!!
    //TODO: You have only 1 member per lending. You cannot lend the same book to 2 people at same time !!!
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Member> reader;

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

    public List<Member> getReader() {
        return reader;
    }

    public void setReader(List<Member> reader) {
        this.reader = reader;
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

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
