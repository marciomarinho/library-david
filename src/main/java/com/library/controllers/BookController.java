package com.library.controllers;

import com.library.domain.Book;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String bookFrame(Model model) {
        Iterable<Book> getAll = bookService.getAll();
        model.addAttribute("books", getAll);
        return "book/book";
    }

    @RequestMapping(value = "/addNewBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/newBook";
    }

    @RequestMapping(value = "/createBook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/{id}/editBook", method = RequestMethod.GET)
    public String editsBook(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "book/editBook";
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute Book book) {
        bookService.editBook(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/{id}/deleteBook", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
        bookService.delete(id);
        return "redirect:/book";
    }
}
