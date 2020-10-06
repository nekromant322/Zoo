package com.nekromant.zoo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class ContactsController {


    @GetMapping("/contacts")
    public ModelAndView contactsPage() {
        ModelAndView modelAndView = new ModelAndView("contacts");
//        modelAndView.addObject("phoneNumber", PhoneNumber);
//
//        modelAndView.addObject("locationX", LocationX);
//        modelAndView.addObject("locationY", LocationY);
//        List<Contacts> filmsList = ContactsDAO.findAll();
        return new ModelAndView("contacts");
    }

}
