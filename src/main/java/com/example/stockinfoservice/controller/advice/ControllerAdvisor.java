package com.example.stockinfoservice.controller.advice;

import com.example.stockinfoservice.exception.StockNotFoundException;
import com.example.stockinfoservice.exception.UnableToGetStockPriceException;
import com.example.stockinfoservice.exception.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<ResponseError> handleStockNotFound(StockNotFoundException stockNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseError(Map.of("Error", stockNotFoundException.getMessage())));
    }

    @ExceptionHandler(UnableToGetStockPriceException.class)
    public ResponseEntity<ResponseError> handleUnableToGetStockPrice(UnableToGetStockPriceException e) {
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY)
                .body(new ResponseError(Map.of("Error", e.getMessage())));
    }

}
