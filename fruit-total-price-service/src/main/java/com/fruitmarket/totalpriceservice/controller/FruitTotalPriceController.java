package com.fruitmarket.totalpriceservice.controller;

import com.fruitmarket.totalpriceservice.dto.FruitTotalPriceResponse;
import com.fruitmarket.totalpriceservice.service.FruitTotalPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fruit")
@RequiredArgsConstructor
public class FruitTotalPriceController {

    private final FruitTotalPriceService fruitTotalPriceService;

    @GetMapping("/{fruitName}/month/{monthName" +
            "}/quantity/{fruitQuantity}")
    @ResponseStatus(HttpStatus.OK)
    public FruitTotalPriceResponse getTotalPrice(@PathVariable("fruitName") String fruitName,
                                                 @PathVariable("monthName") String monthName,
                                                 @PathVariable("fruitQuantity") int fruitQuantity) throws Exception {

        return fruitTotalPriceService.getTotalPrice(fruitName, monthName, fruitQuantity);
    }
}
