package com.fruitmarket.totalpriceservice.service;

import com.fruitmarket.totalpriceservice.config.MyConfiguration;
import com.fruitmarket.totalpriceservice.dto.FruitTotalPriceResponse;
import com.fruitmarket.totalpriceservice.model.FruitMonthPrice;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
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
    private final EurekaClient eurekaClient;

    public FruitTotalPriceResponse getTotalPrice(String fruitName, String monthName, int fruitQuantity) throws Exception {

        FruitMonthPrice response;

        // Eureka
        InstanceInfo service =
                eurekaClient.getApplication(
                        "fruit-month-price").getInstances().get(0);

        String hostName = service.getHostName();
        int port = service.getPort();
        String url = String.format("http://%s" +
                        ":%s/" + "/fruit/%s" +
                        "/month/%s", hostName,
                port,
                fruitName, monthName);
        
        try {
            response =
                    webClient.get().uri(url)
                            .retrieve()
                            .bodyToMono(new ParameterizedTypeReference<FruitMonthPrice>() {
                            })
                            .block();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
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
