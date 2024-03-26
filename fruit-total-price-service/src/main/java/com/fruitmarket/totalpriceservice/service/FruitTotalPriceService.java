package com.fruitmarket.totalpriceservice.service;

import com.fruitmarket.totalpriceservice.config.MyConfiguration;
import com.fruitmarket.totalpriceservice.dto.FruitTotalPriceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FruitTotalPriceService {

    private final MyConfiguration config;

    public FruitTotalPriceResponse getTotalPrice(String fruitName, String monthName, int fruitQuantity) {

        // TODO: Communication with
        //  month-price-service to get id and fmp

        // TODO: to remove
        double fmp = 10.00;

        return new FruitTotalPriceResponse(1,
                fruitName, monthName, fmp,
                fruitQuantity,
                fruitQuantity * fmp,
                config.getPort());
    }
}
