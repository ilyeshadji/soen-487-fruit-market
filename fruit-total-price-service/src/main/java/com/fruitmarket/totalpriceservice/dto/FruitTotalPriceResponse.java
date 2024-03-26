package com.fruitmarket.totalpriceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FruitTotalPriceResponse {
    private int id;
    private String fruit;
    private String month;
    private double fmp;
    private int quantity;
    private double totalPrice;
    private String environment;
}
