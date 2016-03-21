package com.library.controllers;

import com.library.domain.Book;
import com.library.domain.BookLending;
import com.library.domain.Member;
import com.library.services.BookLendingService;
import com.library.services.BookService;
import com.library.services.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookLendingControllerTest {

    private BookLendingController bookLendingController;

    @Mock
    private BookLendingService bookLeadingService;

    @Mock
    private BookService bookService;

    @Mock
    private MemberService readerService;

    @Before
    public void setup() {
        bookLendingController = new BookLendingController(bookLeadingService, bookService, readerService);
    }

    @Test
    public void shouldCreateBookLeading() throws Exception {
        Book harryPotter = new Book(1, "Harry Potter 1", "SomeOne", 5);
        Book javaTheMission = new Book(2, "Java The Mission", "SomeOne Else", 2);
        Book warAndPeace = new Book(3, "War and Peace", "Wolverine", 1);

        List<Book> bookList = new ArrayList<Book>() {{
            add(new Book(1l, null, null, 0)); //this is the actual data you receive from UI.
            add(new Book(2l, null, null, 0));
            add(new Book(3l, null, null, 0));
        }};

        Member scarlet = new Member(1, "Scarlet Johansson");

        BookLending bookLending = new BookLending();
        bookLending.setMember(scarlet);
        bookLending.setBook(bookList);

        when(bookService.findOne(new Long(1))).thenReturn(harryPotter);
        when(bookService.findOne(new Long(2))).thenReturn(javaTheMission);
        when(bookService.findOne(new Long(3))).thenReturn(warAndPeace);

        bookLendingController.createBookLeading(bookLending);

        assertThat(harryPotter.getCount(), is(4));
        assertThat(javaTheMission.getCount(), is(1));
        assertThat(warAndPeace.getCount(), is(0));
    }
}
