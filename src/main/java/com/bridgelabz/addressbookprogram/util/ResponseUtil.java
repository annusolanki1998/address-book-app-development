package com.bridgelabz.addressbookprogram.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseUtil {
    private int errorCode;
    private String message;

    public ResponseUtil() {

    }
}
