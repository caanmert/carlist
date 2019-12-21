package com.canmert.carlist.exception;

/**
 * CarNotFoundException
 */
public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException() {
        super("No Car Found");
    }
}