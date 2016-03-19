package com.library.controllers;

import com.library.domain.entities.Reader;
import com.library.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @RequestMapping(method= RequestMethod.GET)
    public String readerFrame(Model model){
        List<Reader> getAll = readerService.getAll();
        model.addAttribute("readers",getAll);
        return "reader/reader";
    }

    @RequestMapping(value="/addNewReader",method=RequestMethod.GET)
    public String addReader(Model model){
        model.addAttribute("reader",new Reader());
        return "reader/newReader";
    }

    @RequestMapping(value="/createReader",method = RequestMethod.POST)
    public String createReader(@ModelAttribute Reader reader){
        readerService.addReader(reader);
        return "redirect:/reader";
    }

    @RequestMapping(value="/{id}/editReader",method=RequestMethod.GET)
    public String editsReader(@PathVariable long id, Model model){
        Reader reader = readerService.findOne(id);
        model.addAttribute("reader",reader);
        return "reader/editReader";
    }

    @RequestMapping(value="/updateReader",method=RequestMethod.POST)
    public String updateReader(@ModelAttribute Reader reader){
        readerService.editReader(reader);
        return "redirect:/reader";
    }

    @RequestMapping(value="/{id}/deleteReader",method=RequestMethod.GET)
    public String delete(@PathVariable long id){
        readerService.delete(id);
        return "redirect:/reader";
    }
}
