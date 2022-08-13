package com.bridgelabz.addressbookprogram.service;

import com.bridgelabz.addressbookprogram.dto.AddressBookDTO;
import com.bridgelabz.addressbookprogram.model.AddressBookModel;
import com.bridgelabz.addressbookprogram.util.ResponseUtil;

import javax.xml.ws.Response;
import java.util.List;

public interface IAddressBookService {

    AddressBookModel addContact(AddressBookDTO addressBookDTO);

    AddressBookModel updateContact(Long id, AddressBookDTO addressBookDTO);

    List<AddressBookModel> getContacts(String token);

    AddressBookModel deleteContact(Long id);

    AddressBookModel getContact(Long id);

    ResponseUtil login(String emailId, String password);
}