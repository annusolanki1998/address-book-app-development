package com.bridgelabz.addressbookprogram.service;

import com.bridgelabz.addressbookprogram.dto.AddressBookDTO;
import com.bridgelabz.addressbookprogram.exception.AddressBookException;
import com.bridgelabz.addressbookprogram.model.AddressBookModel;
import com.bridgelabz.addressbookprogram.repository.AddressBookRepository;
import com.bridgelabz.addressbookprogram.util.ResponseUtil;
import com.bridgelabz.addressbookprogram.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public AddressBookModel addContact(AddressBookDTO addressBookDTO) {
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDTO);
        addressBookModel.setRegisterDate(LocalDateTime.now());
        addressBookRepository.save(addressBookModel);
        return addressBookModel;
    }


    public AddressBookModel updateContact(Long id, AddressBookDTO addressBookDTO) {
        Optional<AddressBookModel> isContactPresent = addressBookRepository.findById(id);
        if (isContactPresent.isPresent()) {
            isContactPresent.get().setFirstName(addressBookDTO.getFirstName());
            isContactPresent.get().setLastName(addressBookDTO.getLastName());
            isContactPresent.get().setAddress(addressBookDTO.getAddress());
            isContactPresent.get().setCity(addressBookDTO.getCity());
            isContactPresent.get().setState(addressBookDTO.getState());
            isContactPresent.get().setZip(addressBookDTO.getZip());
            isContactPresent.get().setPhoneNumber(addressBookDTO.getPhoneNumber());
            isContactPresent.get().setUpdatedDate(LocalDateTime.now());
            addressBookRepository.save(isContactPresent.get());
            return isContactPresent.get();
        } else {
            throw new AddressBookException(400, "Contact is not Found");
        }
    }

    @Override
    public List<AddressBookModel> getContacts(String token) {
        Long contactId =tokenUtil.decodeToken(token);
        Optional<AddressBookModel> isContactIsPresent=addressBookRepository.findById(contactId);
        if (isContactIsPresent.isPresent()) {
            List<AddressBookModel> isContactPresent = addressBookRepository.findAll();
            if (isContactPresent.size() > 0) {
                return isContactPresent;
            } else {
                throw new AddressBookException(400, "No Contacts Is there");
            }
        }
        throw new AddressBookException(400,"Token is wrong");
    }


    @Override
    public AddressBookModel deleteContact(Long id) {
        Optional<AddressBookModel> isContactPresent = addressBookRepository.findById(id);
        if (isContactPresent.isPresent()) {
            addressBookRepository.delete(isContactPresent.get());
            return isContactPresent.get();
        } else {
            throw new AddressBookException(400, "Contact not Found");
        }
    }

    @Override
    public AddressBookModel getContact(Long id) {
        Optional<AddressBookModel> isContactPresent = addressBookRepository.findById(id);
        if (isContactPresent.isPresent()) {
            return isContactPresent.get();
        } else {
            throw new AddressBookException(400, "Contact not found");
        }
    }

    @Override
    public ResponseUtil login(String emailId, String password) {
        Optional<AddressBookModel> isEmailPresent = addressBookRepository.findByEmailId(emailId);
        if (isEmailPresent.isPresent()) {
            if (isEmailPresent.get().getPassword().equals(password)) {
                String token = tokenUtil.createToken(isEmailPresent.get().getId());
                return new ResponseUtil(200, "LoginSuccess", token);
            } else {
                throw new AddressBookException(400, "Password wrong");
            }
        }
        throw new AddressBookException(400, "No Contact Found");
    }

}

