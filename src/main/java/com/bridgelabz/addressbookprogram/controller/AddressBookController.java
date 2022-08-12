package com.bridgelabz.addressbookprogram.controller;


import com.bridgelabz.addressbookprogram.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    IAddressBookService addressBookService;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Address Book Spring application";

    }
}
