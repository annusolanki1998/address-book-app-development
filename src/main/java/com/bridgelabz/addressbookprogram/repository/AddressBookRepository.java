package com.bridgelabz.addressbookprogram.repository;

import com.bridgelabz.addressbookprogram.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {

    Optional<AddressBookModel> findByEmailId(String emailId);
    List<AddressBookModel> findByCityContainsIgnoreCase(String city);
    @Query(value = "select * from addressbook where state=:state", nativeQuery = true)
    List<AddressBookModel> findByState(String state);
}
