package com.fruitmarket.monthpriceservice.controller;

import com.fruitmarket.monthpriceservice.dto.FruitMonthPriceResponse;
import com.fruitmarket.monthpriceservice.service.FruitMonthPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fruit")
@RequiredArgsConstructor
public class FruitMonthPriceController {

    private final FruitMonthPriceService fruitMonthPriceService;

    @GetMapping("/{fruitName}/month/{monthName}")
    @ResponseStatus(HttpStatus.OK)
    public FruitMonthPriceResponse getTotalPrice(@PathVariable("fruitName") String fruitName,
                                                 @PathVariable("monthName") String monthName) {

        return fruitMonthPriceService.getMonthPrice(fruitName, monthName);
    }
}
