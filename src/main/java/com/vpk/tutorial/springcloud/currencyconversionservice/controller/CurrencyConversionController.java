package com.vpk.tutorial.springcloud.currencyconversionservice.controller;

import com.vpk.tutorial.springcloud.currencyconversionservice.model.CurrencyConversion;
import com.vpk.tutorial.springcloud.currencyconversionservice.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convert(@PathVariable String from, @PathVariable String to,
                                      @PathVariable Double quantity){
        return currencyConversionService.convert(from, to, quantity);
    }
}
