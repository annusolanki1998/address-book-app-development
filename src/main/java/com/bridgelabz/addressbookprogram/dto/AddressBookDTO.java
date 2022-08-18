package com.bridgelabz.addressbookprogram.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @NotNull(message = "FirstName should not be empty ")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Firstname should start with capital letter and  atleast min of three character")
    private String firstName;

    @NotNull(message = "LastName should not be empty ")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Lastname should start with capital letter and  atleast min of three character")
    private String lastName;

    @NotNull(message = "Address should not be empty")
    private String address;

    @NotNull(message = "City should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message ="Invalid city name")
    private String city;

    @NotNull(message = "State should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message ="Invalid state name")
    private String state;

    @NotNull(message = "Phonenumber should not be empty")
    @Pattern(regexp = "[+]91 [6-9]\\d{9}", message ="Invalid phone number")
    private long phoneNumber;

    @NotNull(message = "Zip should not be empty")
    @Pattern(regexp = "[0-9]{6,}", message ="Invalid zip code")
    private int zip;

    @NotNull(message = "Email id should not be empty")
    @Pattern(regexp = "[a-z][A-Z a-z 0-9]+[@][a-z]+[.][a-z]{2,}", message = "Invalid email id")
    private String emailId;

    @NotNull(message = "Password should not be empty")
    @Pattern(regexp = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}", message = "Invalid password")
    private String password;
}

