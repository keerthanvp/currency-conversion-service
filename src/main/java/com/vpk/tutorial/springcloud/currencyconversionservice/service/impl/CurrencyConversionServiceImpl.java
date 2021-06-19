package com.vpk.tutorial.springcloud.currencyconversionservice.service.impl;

import com.vpk.tutorial.springcloud.currencyconversionservice.model.CurrencyConversion;
import com.vpk.tutorial.springcloud.currencyconversionservice.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private static String URL = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

    @Override
    public CurrencyConversion convert(String from, String to, Double quantity) {
        CurrencyConversion currencyConversion = fetch(from, to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculatedAmount(quantity * currencyConversion.getConversionMultiple());
        return currencyConversion;
    }

    private CurrencyConversion fetch(String from, String to){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
                .getForEntity(URL, CurrencyConversion.class, uriVariables);
        return responseEntity.getBody();
    }
}
