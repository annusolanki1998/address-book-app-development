package com.bridgelabz.addressbookprogram.repository;

import com.bridgelabz.addressbookprogram.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
}
