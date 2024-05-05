package com.example.stockinfoservice.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Stock {

    private String symbol;
    private double price;
    private LocalDateTime dateTime;

}
