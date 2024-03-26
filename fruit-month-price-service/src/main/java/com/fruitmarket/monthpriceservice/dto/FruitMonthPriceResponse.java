package com.fruitmarket.monthpriceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FruitMonthPriceResponse {
    private int id;
    private String fruit;
    private String month;
    private double fmp;
    private String environment;
}
