package com.library.controllers;

import com.library.domain.Member;
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
        List<Member> getAll = readerService.getAll();
        model.addAttribute("readers",getAll);
        return "reader/reader";
    }

    @RequestMapping(value="/addNewReader",method=RequestMethod.GET)
    public String addReader(Model model){
        model.addAttribute("reader",new Member());
        return "reader/newReader";
    }

    @RequestMapping(value="/createReader",method = RequestMethod.POST)
    public String createReader(@ModelAttribute Member member){
        readerService.addReader(member);
        return "redirect:/reader";
    }

    @RequestMapping(value="/{id}/editReader",method=RequestMethod.GET)
    public String editsReader(@PathVariable long id, Model model){
        Member member = readerService.findOne(id);
        model.addAttribute("reader", member);
        return "reader/editReader";
    }

    @RequestMapping(value="/updateReader",method=RequestMethod.POST)
    public String updateReader(@ModelAttribute Member member){
        readerService.editReader(member);
        return "redirect:/reader";
    }

    @RequestMapping(value="/{id}/deleteReader",method=RequestMethod.GET)
    public String delete(@PathVariable long id){
        readerService.delete(id);
        return "redirect:/reader";
    }
}
