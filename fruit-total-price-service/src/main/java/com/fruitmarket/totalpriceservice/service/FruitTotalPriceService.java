package com.fruitmarket.totalpriceservice.service;

import com.fruitmarket.totalpriceservice.config.MyConfiguration;
import com.fruitmarket.totalpriceservice.dto.FruitTotalPriceResponse;
import com.fruitmarket.totalpriceservice.model.FruitMonthPrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class FruitTotalPriceService {

    private final MyConfiguration config;
    private final WebClient webClient;

    public FruitTotalPriceResponse getTotalPrice(String fruitName, String monthName, int fruitQuantity) {

        FruitMonthPrice response;

        try {
            response =
                    webClient.get().uri("http" +
                                    "://localhost" +
                                    ":8000" +
                                    "/fruit" +
                                    "-month" +
                                    "-price" +
                                    "/fruit" +
                                    "/" + fruitName +
                                    "/month" +
                                    "/" + monthName)
                            .retrieve()
                            .bodyToMono(new ParameterizedTypeReference<FruitMonthPrice>() {
                            })
                            .block();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Fruit is not in stock, " +
                            "please try again " +
                            "later");
        }
        
        assert response != null;
        return new FruitTotalPriceResponse(response.getId(),
                fruitName, monthName,
                response.getFmp(),
                fruitQuantity,
                fruitQuantity * response.getFmp(),
                config.getPort());
    }
}
