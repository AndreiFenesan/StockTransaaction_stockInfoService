package com.example.stockinfoservice.exception;

public class UnableToGetStockPriceException extends RuntimeException {
    public UnableToGetStockPriceException(String message) {
        super(message);
    }
}
