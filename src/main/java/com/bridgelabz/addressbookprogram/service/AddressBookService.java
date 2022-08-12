package com.bridgelabz.addressbookprogram.service;

import com.bridgelabz.addressbookprogram.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;
}
