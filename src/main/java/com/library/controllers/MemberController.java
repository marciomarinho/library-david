package com.library.controllers;

import com.library.domain.Member;
import com.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reader")
public class MemberController {

    @Autowired
    private MemberService readerService;

    @RequestMapping(method= RequestMethod.GET)
    public String readerFrame(Model model){
        List<Member> getAll = readerService.getAll();
        model.addAttribute("readers",getAll);
        return "reader/member";
    }

    @RequestMapping(value="/addNewReader",method=RequestMethod.GET)
    public String addReader(Model model){
        model.addAttribute("reader",new Member());
        return "reader/newMember";
    }

    @RequestMapping(value="/createReader",method = RequestMethod.POST)
    public String createReader(@ModelAttribute Member reader){
        readerService.addReader(reader);
        return "redirect:/reader";
    }

    @RequestMapping(value="/{id}/editReader",method=RequestMethod.GET)
    public String editsReader(@PathVariable long id, Model model){
        Member reader = readerService.findOne(id);
        model.addAttribute("reader",reader);
        return "reader/editMember";
    }

    @RequestMapping(value="/updateReader",method=RequestMethod.POST)
    public String updateReader(@ModelAttribute Member reader){
        readerService.editReader(reader);
        return "redirect:/reader";
    }

    @RequestMapping(value="/{id}/deleteReader",method=RequestMethod.GET)
    public String delete(@PathVariable long id){
        readerService.delete(id);
        return "redirect:/reader";
    }
}
