package com.bridgelabz.addressbookprogram.controller;


import com.bridgelabz.addressbookprogram.dto.AddressBookDTO;
import com.bridgelabz.addressbookprogram.model.AddressBookModel;
import com.bridgelabz.addressbookprogram.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    IAddressBookService addressBookService;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Address Book Spring application";
    }

    @PostMapping("addcontact")
    public AddressBookModel addContact(@RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.addContact(addressBookDTO);
    }

    @PutMapping("updatecontact/{id}")
    public AddressBookModel updateContact(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.updateContact(id, addressBookDTO);
    }

    @GetMapping("getcontacts")
    public List<AddressBookModel> getContacts() {
        return addressBookService.getContacts();
    }

    @DeleteMapping("deletecontact/{id}")
    public AddressBookModel deleteContact(@PathVariable Long id) {
        return addressBookService.deleteContact(id);
    }

    @GetMapping("getcontact/{id}")
    public AddressBookModel getContact(@PathVariable Long id) {
        return addressBookService.getContact(id);
    }

}

