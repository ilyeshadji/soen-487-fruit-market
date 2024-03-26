package com.fruitmarket.monthpriceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FruitPriceAndIdResponse {
    private int id;
    private double fmp;
}
