package com.library.controllers;


import com.library.domain.Book;
import com.library.domain.BookLending;
import com.library.domain.Member;
import com.library.services.BookLendingService;
import com.library.services.BookService;
import com.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/bookLeading")
public class BookLendingController {

    @Autowired
    private BookLendingService bookLeadingService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService readerService;

    private static int counter;

    @RequestMapping(method= RequestMethod.GET)
    public String bookLeadingFrame(Model model){
        List<BookLending> getAll = bookLeadingService.getAll();
        model.addAttribute("bookLeadings",getAll);
        return "bookLeading/bookLending";
    }

    @RequestMapping(value="/addNewBookLeading",method=RequestMethod.GET)
    public String addBookLeading(Model model){
        model.addAttribute("bookLeading",new BookLending());
        model.addAttribute("books",bookService.getAll());
        model.addAttribute("readers",readerService.getAll());
        return "bookLeading/newBookLending";
    }

    @RequestMapping(value="/returnBookLeading",method=RequestMethod.GET)
    public String returnBookLeading(Model model){
        List<BookLending> booklend = bookLeadingService.getAll();
        List<Book> books = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        for(BookLending names : booklend){
            for(Book bookName : names.getBook()) {
               books.add(bookName);
                for (Member fullName : names.getReader()) {
                    members.add(fullName);
                }
            }
        }
        model.addAttribute("bookName",books);
        model.addAttribute("fullName",members);
        model.addAttribute("bookLeading",new BookLending());
        return "bookLeading/returnBookLending";
    }

    @RequestMapping(value="/createBookLeading",method=RequestMethod.POST)
    public String createBookLeading(@ModelAttribute BookLending bookLeading){
        for(Book bookName : bookLeading.getBook()){
           counter = bookName.getCount() - 1;
            bookName.setCount(counter);
            bookService.editBook(bookName);
            for(Member fullName : bookLeading.getReader()){
               for(Member secondMember : readerService.getAll()){
                   if(secondMember.getFullName().equals(fullName.getFullName())){
                       secondMember.setBookInHand(bookName.getNameBook());
                       readerService.editReader(secondMember);
                   }
               }
            }
        }
        bookLeadingService.addBookLeading(bookLeading);
        return "redirect:/bookLeading";
    }

    @RequestMapping(value="/deleteBookLeading",method=RequestMethod.POST)
    public String deleteBookLeading(@ModelAttribute BookLending bookLeading){
        for(Book book : bookLeading.getBook()){
            for(Member member : bookLeading.getReader()){

            }
        }

        return "redirect:/bookLeading";
    }



}
