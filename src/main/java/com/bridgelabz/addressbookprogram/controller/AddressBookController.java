package com.bridgelabz.addressbookprogram.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Address Book Spring application";

    }
}
