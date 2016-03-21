package com.library.controllers;


import com.library.domain.Book;
import com.library.domain.BookLending;
import com.library.domain.Member;
import com.library.services.BookLendingService;
import com.library.services.BookService;
import com.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;


@Controller
@RequestMapping("/bookLeading")
public class BookLendingController {

    private BookLendingService bookLeadingService;

    private BookService bookService;

    private MemberService readerService;

    @Autowired
    public BookLendingController(final BookLendingService bookLeadingService,
                                 final BookService bookService,
                                 MemberService readerService) {
        this.bookLeadingService = bookLeadingService;
        this.bookService = bookService;
        this.readerService = readerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String bookLeadingFrame(Model model) {
        List<BookLending> getAll = bookLeadingService.getAll();
        model.addAttribute("bookLeadings", getAll);
        return "bookLeading/bookLending";
    }

    @RequestMapping(value = "/addNewBookLeading", method = RequestMethod.GET)
    public String addBookLeading(Model model) {
        model.addAttribute("bookLeading", new BookLending());
        model.addAttribute("books", bookService.getAll());
        model.addAttribute("readers", readerService.getAll());
        return "bookLeading/newBookLending";
    }

    @RequestMapping(value = "/returnBookLeading", method = RequestMethod.GET)
    public String returnBookLeading(Model model) {
        List<BookLending> booklend = bookLeadingService.getAll();
        List<Book> books = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        for (BookLending names : booklend) {
            for (Book bookName : names.getBook()) {
                books.add(bookName);
                for (Member fullName : names.getReader()) {
                    members.add(fullName);
                }
            }
        }
        model.addAttribute("bookName", books);
        model.addAttribute("fullName", members);
        model.addAttribute("bookLeading", new BookLending());
        return "bookLeading/returnBookLending";
    }

    //TODO: I didn't get what you were trying to do here, so I just took a guess.

    /**
     * It is a very simplistic implementation of "lending" creation.
     * Basically, we will go through the chosen books and keep them on a HashSet ( no duplicate collection ),
     * then you can subtract the amount from the quantity.
     *
     * Should we assume that for lending a book the member always have to pick it up from the shelf first ?
     * This way we won't need to control the quantity, because if the book is not on the shelf there is no
     * more available. Again, this is only an assumption of mine.
     * If not, we than have to cope with the fact the member can go to the counter and ask for the book,
     * so, we have to check if the book has any exemplary available.
     *
     * @see com.library.controllers.BookLendingControllerTest
     * @param bookLeading
     * @return
     */
    @Transactional
    @RequestMapping(value = "/createBookLeading", method = RequestMethod.POST)
    public String createBookLeading(@ModelAttribute BookLending bookLeading) {

        // Dumb implementation, does not take in account about the quantities
        Map<Long, Book> chosenBooks = new HashMap<>();

        for (Book book : bookLeading.getBook()) {
            //Look inside the map, if exists get from there. If not, then get from the repository.
            Book chosenBook;

            if (chosenBooks.containsKey(book.getId())) {
                chosenBook = chosenBooks.get(book.getId());
            } else {
                chosenBook = bookService.findOne(book.getId());
            }
            chosenBook.setCount(chosenBook.getCount()-1);
            chosenBooks.put(chosenBook.getId(), chosenBook);
        }

        // We should save the Books with new values after subtracted their the quantities.
        for (Book book : chosenBooks.values()) {
            bookService.save(book);
        }

        bookLeadingService.addBookLeading(bookLeading);


        return "redirect:/bookLeading";
    }

// TODO: YOU CAN KILL THIS ONE IF YOU WANT !!!
//    @RequestMapping(value="/createBookLeading",method=RequestMethod.POST)
//    public String createBookLeading(@ModelAttribute BookLending bookLeading){
//        for(Book bookName : bookLeading.getBook()){
//           counter = bookName.getCount() - 1;
//            bookName.setCount(counter);
//            bookService.editBook(bookName);
//            for(Member fullName : bookLeading.getReader()){
//               for(Member secondMember : readerService.getAll()){
//                   if(secondMember.getFullName().equals(fullName.getFullName())){
//                       secondMember.setBookInHand(bookName.getNameBook());
//                       readerService.editReader(secondMember);
//                   }
//               }
//            }
//        }
//        bookLeadingService.addBookLeading(bookLeading);
//        return "redirect:/bookLeading";
//    }

    @RequestMapping(value = "/deleteBookLeading", method = RequestMethod.POST)
    public String deleteBookLeading(@ModelAttribute BookLending bookLeading) {
        for (Book book : bookLeading.getBook()) {
            for (Member member : bookLeading.getReader()) {

            }
        }

        return "redirect:/bookLeading";
    }


}
