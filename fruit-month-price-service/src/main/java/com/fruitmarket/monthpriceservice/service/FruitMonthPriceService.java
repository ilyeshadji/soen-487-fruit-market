package com.fruitmarket.monthpriceservice.service;

import com.fruitmarket.monthpriceservice.dto.FruitMonthPriceResponse;
import com.fruitmarket.monthpriceservice.dto.FruitPriceAndIdResponse;
import com.fruitmarket.monthpriceservice.config.MyConfiguration;
import com.fruitmarket.monthpriceservice.repository.FruitMonthPriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FruitMonthPriceService {
    private final FruitMonthPriceRepository fruitMonthPriceRepository;
    private final MyConfiguration config;

    public FruitMonthPriceResponse getMonthPrice(String fruitName, String monthName) {

        FruitPriceAndIdResponse fmpAndPrice =
                fruitMonthPriceRepository.fetchFruitMonthPriceByFruitAndMonth(fruitName, monthName);

        return new FruitMonthPriceResponse(fmpAndPrice.getId(), fruitName, monthName, fmpAndPrice.getFmp(), config.getPort());
    }
}
